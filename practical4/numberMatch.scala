object NumberCategorizer {
  def categorizeNumber(number: Int): String = number match {
    case n if n <= 0 => "Negative/Zero is input"
    case n if n % 2 == 0 => "Even number is given"
    case _ => "Odd number is given"
  }

  def main(args: Array[String]): Unit = {
    // if (args.length != 1) {
    //   println("Please provide exactly one integer argument.")
    // } else {
    //   try {
    //     val input = args(0).toInt
    //     val result = categorizeNumber(input)
    //     println(result)
    //   } catch {
    //     case _: NumberFormatException =>
    //       println("Please provide a valid integer.")
    //   }
    // }
    val input=scala.io.StdIn.readLine("Enter a number: ").toInt
    println(categorizeNumber(input))
  }
}