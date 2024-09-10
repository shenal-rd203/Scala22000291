import scala.io.StdIn.readLine

class BankAccount(private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
    else if (amount > balance) println("Insufficient balance!")
  }

  def transfer(amount: Double, toAccount: BankAccount): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  def checkBalance(): Double = balance

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // 5% interest for positive balance
    } else {
      balance += balance * 0.10 // 10% overdraft interest for negative balance
    }
  }

  override def toString: String = s"Account(balance = $$${balance})"
}

object BankApp {
  var accounts: List[BankAccount] = List.empty

  def addAccount(balance: Double): Unit = {
    accounts = new BankAccount(balance) :: accounts
  }

  def getNegativeBalanceAccounts(): List[BankAccount] = {
    accounts.filter(_.checkBalance() < 0)
  }

  def calculateTotalBalance(): Double = {
    accounts.map(_.checkBalance()).sum
  }

  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  def menu(): Unit = {
    var continue = true
    while (continue) {
      println("\n--- Bank Operations Menu ---")
      println("1. Add an Account")
      println("2. List Accounts with Negative Balances")
      println("3. Calculate the Sum of All Account Balances")
      println("4. Apply Interest to All Accounts")
      println("5. Exit")

      val choice = readLine("Select an option (1-5): ").toInt

      choice match {
        case 1 =>
          val balance = readLine("Enter initial balance: ").toDouble
          addAccount(balance)
          println(s"Account with balance $$${balance} added.")

        case 2 =>
          val negativeAccounts = getNegativeBalanceAccounts()
          if (negativeAccounts.nonEmpty) {
            println("Accounts with negative balances:")
            negativeAccounts.foreach(println)
          } else {
            println("No accounts have negative balances.")
          }

        case 3 =>
          val totalBalance = calculateTotalBalance()
          println(s"Total balance across all accounts: $$${totalBalance}")

        case 4 =>
          applyInterestToAll()
          println("Interest applied to all accounts.")
          accounts.foreach(acc => println(s"Updated: $acc"))

        case 5 =>
          println("Exiting the program.")
          continue = false

        case _ =>
          println("Invalid option! Please select a valid choice.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    menu()
  }
}