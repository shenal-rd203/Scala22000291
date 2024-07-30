object Reverse{
    def reverseString(str: String): String = {
    if (str.isEmpty || str.length == 1) {
        str
    } else {
        reverseString(str.tail) + str.head
    }
    }

    def main(args: Array[String]): Unit={
        val input=scala.io.StdIn.readLine("Enter a string: ")
        println("Reverse: "+reverseString(input))
    }
}
