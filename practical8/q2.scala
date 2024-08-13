object NumberCategorizer {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Please provide exactly one integer argument.")
      return
    }

    val input = args(0).toInt

    val isMultipleOfThree = (n: Int) => n % 3 == 0
    val isMultipleOfFive = (n: Int) => n % 5 == 0

    val message = (input match {
      case n if isMultipleOfThree(n) && isMultipleOfFive(n) => "Multiple of Both Three and Five"
      case n if isMultipleOfThree(n) => "Multiple of Three"
      case n if isMultipleOfFive(n) => "Multiple of Five"
      case _ => "Not a Multiple of Three or Five"
    })

    println(message)
  }
}