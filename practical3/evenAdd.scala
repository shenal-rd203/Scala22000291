import scala.collection.immutable.List

object EvenNumberSum {
  def sumEven(numbers: List[Int]): Int = {
    var sum = 0
    var currentList = numbers
    
    while (!currentList.isEmpty) {
        val head = currentList.head
        if (head % 2 == 0) {
            sum += head
        }
        currentList = currentList.tail
    }   
    sum
}

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(s"The sum of even numbers is: "+ sumEven(numbers))
  }
}