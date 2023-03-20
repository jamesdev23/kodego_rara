package activity_07_b

import java.util.*

open class Publication(var title: String, var author: Authors, open var yearPublished: Int, open var publisher: Publisher) {
    open fun getDetails(): String {
        return "Title: $title, Authors: ${author.firstName} ${author.lastName}, Year Published: $yearPublished, Publisher: ${publisher.name}"
    }
    open fun searchByTitle(title: String): Boolean {
        return this.title.equals(title, ignoreCase = true)
    }
}
class Book(var title: String) {
    var authors: Authors = Authors("","")
    var yearPublished: Int = 0
    var edition: Int = 0
    var ISBN: String = ""
    var publisher: Publisher = Publisher("")
    var chapters: List<String> = emptyList()
    var pages: Int = 0
}

open class Article(var title: String,var content: String,var author: Authors)

class Magazines(var editor: String, var monthPublished: Int, title:String, author:Authors,yearPublished: Int,publisher: Publisher) : Publication(title,author,yearPublished,publisher) {
    override var yearPublished: Int = 0
}
class Newspaper(var name: String, var dayPublished: Int, var monthPublished: Int, var headline: String, title:String, author:Authors,yearPublished: Int,publisher: Publisher) : Publication(title,author,yearPublished,publisher) {
    override var yearPublished: Int = 0
}

class Comics(var monthPublished: Int, var illustrators: Illustrator, title: String,author: Authors,yearPublished: Int, publisher: Publisher) : Publication(title,author,yearPublished,publisher) {
    override var yearPublished:Int = 0
    override var publisher:Publisher = Publisher("")
}

class Publisher (var name: String){
    var address: String = ""
    var dateEstablished: Date = Date()
}

class Authors(var firstName: String, var lastName: String){
    var middleName: String = ""
    var dateOfBirth: Date = Date()
    // class for books, magazines and newspaper
}

class Illustrator(var firstName: String, var lastName: String){
    var middleName: String = ""
    var dateOfBirth: Date = Date()
    // class for comics
}

class audioVideoRecording(var length: Int, var dateRecorded: String, var title: String, var publisher: Publisher) {
    var hasVideo: Boolean = true
    var hasAudio: Boolean = true
    var hasBoth: Boolean = true
}

enum class AudioVideoTypes {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT
}

// added class and methods for act_6b

data class User(var name:String){
    var borrowCount:Int = 0
    var unpaidDues:Double = 0.0
}

class Library{
    // book list w/ Status (Available/Reserved/Internal Use/For Fixing)
    var bookList:HashMap<String,String> = hashMapOf(
        "Book 1" to "Available",
        "Book 2" to "Reserved",
        "Book 3" to "Internal Use",
        "Book 4" to "For Fixing"
    )

    var borrowedItem:HashMap<User,Book> = HashMap()
}

fun acceptAndBorrowItem(user:User,book:Book){
    val library = Library()
    val reserved = library.bookList.getValue(book.title) == "Reserved"
    val forInternalUse = library.bookList.getValue(book.title) == "Internal Use"
    val forFixing = library.bookList.getValue(book.title) == "For Fixing"

    when {
        user.borrowCount >= 5 ->
            throw LibraryException.UserException.UserHas5orMoreItems()

        user.unpaidDues > 0.0 ->
            throw LibraryException.UserException.UserHasUnpaidDues()

        reserved ->
            throw LibraryException.ItemException.ItemIsReserved()

        forInternalUse ->
            throw LibraryException.ItemException.ItemIsForInternalUse()

        forFixing ->
            throw LibraryException.ItemException.ItemIsForFixing()
    }

    library.borrowedItem[user] = book
    ++user.borrowCount

}

sealed class LibraryException(message:String) : Exception(message){
    sealed class UserException(message:String) : LibraryException(message){
        class UserHas5orMoreItems(message:String = "Cannot borrow due to too many items still borrowed") : UserException(message)
        class UserHasUnpaidDues(message:String = "Cannot borrow due to unpaid dues") : UserException(message)
    }
    sealed class ItemException(message: String) : LibraryException(message){
        class ItemIsReserved(message:String = "Cannot borrow due to reserved"):ItemException(message)
        class ItemIsForInternalUse(message:String = "Cannot borrow due to item only used in library"):ItemException(message)
        class ItemIsForFixing(message:String = "Cannot borrow due to item needs to be fixed"):ItemException(message)
    }
}

fun main() {
//    val user1 = User("James")
//
//    val book1 = Book("Book 1")
//    val book2 = Book("Book 2")
//    val book3 = Book("Book 3")
//    val book4 = Book("Book 4")
//
//    val library = Library()
//
//    library.bookList[book1.title] = "Available"
//    library.bookList[book2.title] = "Reserved"
//    library.bookList[book3.title] = "Internal Use"
//    library.bookList[book4.title] = "For Fixing"
//
//    // user 5 or more borrowed items exception
//    user1.borrowCount = 5
//    library.borrowItem(user1,book1)
//
//    // unpaid dues exception
//    user1.unpaidDues = 500.0
//    library.borrowItem(user1,book1)
//
//    // "reserved" exception
//    library.borrowItem(user1,book2)
//
//    // "internal use" exception
//    library.borrowItem(user1,book3)
//
//    // "for fixing" exception
//    library.borrowItem(user1,book4)
}
