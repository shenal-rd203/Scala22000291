object NumberCategorizer {
  def categorizeNumber(number: Int): String = number match {
    case n if n <= 0 => "Negative/Zero is input"
    case n if n%3==0 => "Multiple of 3 is given"
    case n if n % 2 == 0 => "Even number is given"
    case _ => "Odd number is given"
  }

  def main(args: Array[String]): Unit = {
    val input=scala.io.StdIn.readLine("Enter a number: ").toInt
    println(categorizeNumber(input))
  }
}