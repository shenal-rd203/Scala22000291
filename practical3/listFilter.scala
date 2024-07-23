object List{
  def filterStrings(strings: List[String]): List[String] = {
    strings.filter(_.length > 5)
  }

  def main(args: Array[String]):Unit={
    val input=scala.io.StdIn.readLine("Enter strings separated by spaces: ")
    val strings=input.split(" ").toList
    println("Strings with length greater than 5: "+filterStrings(strings))
  }
}