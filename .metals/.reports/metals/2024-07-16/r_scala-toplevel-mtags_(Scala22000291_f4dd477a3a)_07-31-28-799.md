error id: file:///C:/Users/LENOVO/UCSC/2nd%20Year/semester%201/2204%20Functional%20Programming/Practicals/gitRepo/Scala22000291/Practical%205/library.scala:[456..457) in Input.VirtualFile("file:///C:/Users/LENOVO/UCSC/2nd%20Year/semester%201/2204%20Functional%20Programming/Practicals/gitRepo/Scala22000291/Practical%205/library.scala", "case class Book(title: String, author: String, isbn:String)

object LibraryManagement{
    var library: Set[Book]=Set(
        Book("The hobbit", "Tolkien","8797987"),
        Book("1984", "George Orwell", "9780451"),
        Book("Mocking", "Harper", "820084")
    )

    def addBook(book: Book): Unit={
        library+=book
    }

    def removeBook(isbn: String):Unit={
        library=library.filterNot(_.isbn==isbn)
    }

    def 
}")
file:///C:/Users/LENOVO/UCSC/2nd%20Year/semester%201/2204%20Functional%20Programming/Practicals/gitRepo/Scala22000291/Practical%205/library.scala
file:///C:/Users/LENOVO/UCSC/2nd%20Year/semester%201/2204%20Functional%20Programming/Practicals/gitRepo/Scala22000291/Practical%205/library.scala:19: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace