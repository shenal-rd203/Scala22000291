import scala.io.StdIn.readLine

object StudentRecords {

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks"))
    } else {
      (true, None)
    }
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student's name: ")
    var marks = readLine("Enter marks obtained: ").toInt
    if (marks < -10) {
      throw new IllegalArgumentException("Marks cannot be less than -10")
    }else if(marks<0){
      marks=0
    }
    val totalMarks = readLine("Enter total possible marks: ").toInt

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
      throw new IllegalArgumentException(errorMessage.get)
    }

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
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
        case e: IllegalArgumentException => println(e.getMessage)
      }
    }

    record
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
} 