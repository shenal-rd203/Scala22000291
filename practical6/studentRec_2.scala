import scala.io.StdIn.readLine

object StudentRecords {

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total marks must be positive integers"))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks"))
    } else {
      (true, None)
    }
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student's name: ")
    val marks = readLine("Enter marks obtained: ").toInt
    val totalMarks = readLine("Enter total possible marks: ").toInt

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
        errorMessage.get
    //   throw new IllegalArgumentException(errorMessage.get)
    }else{
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
        case p if p >= 90 => 'A'
        case p if p >= 75 => 'B'
        case p if p >= 50 => 'C'
        case _ => 'D'
     }
        (name, marks, totalMarks, percentage, grade)
    }

}

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Name: $name")
    println(s"Marks: $marks")
    println(s"Total Marks: $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var record: (String, Int, Int, Double, Char) = null

    while (!isValid) {
        
      try {
        record = getStudentInfo()
        isValid = true
      } catch {
        println(getMessage)
        // case e: IllegalArgumentException => println(e.getMessage)
      }
    }

    record
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}