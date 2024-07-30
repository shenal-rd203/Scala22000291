object NameFormatter {
  def toUpper(str: String): String = str.toUpperCase

  def toLower(str: String): String = str.toLowerCase

  def formatNames(name: String)(formatter: String => String): String = formatter(name)

  def main(args: Array[String]): Unit = {
    println(formatNames("Benny")(toUpper))
    println(formatNames("Niroshan")(str => str.head.toUpper + str.tail.toLowerCase))
    println(formatNames("Saman")(toLower))
    println(formatNames("Kumara")(str => str.init + str.last.toUpper))
  }
}