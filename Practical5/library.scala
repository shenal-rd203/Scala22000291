case class Book(title: String, author: String, isbn:String)

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

    def isBookInLibrary(isbn: String):Boolean={
        library.exists(_.isbn==isbn)
    }

    def displayLibrary(): Unit={
        library.foreach(book=>println(s"Title:${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def findBookTitle(title:String): Option[Book]={
        library.find(_.title.toLowerCase==title.toLowerCase)
    }

    def displayBook(author:String): Unit={
        library.filter(_.author.toLowerCase==author.toLowerCase).foreach(book=>println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }

    def main(args: Array[String]): Unit = {
        println("Initial Library Collection:")
        displayLibrary()

        println("\nAdd new book (Brave New World)")
        val newBook = Book("Brave New World", "Aldous", "0850524")
        addBook(newBook)
        displayLibrary()

        println("\nRemove book")
        removeBook("9780451")
        displayLibrary()

        println("\nCheck if a Book is in the Library by ISBN (820084):")
        println(isBookInLibrary("820084"))

        println("\nSearch for a Book by Title ('The Hobbit'):")
        findBookTitle("The Hobbit").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))

        println("\nDisplay Books by Tolkien:")
        displayBook("Tolkien")
  }
}