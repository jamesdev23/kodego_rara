package activity_06_b

import java.util.*
import kotlin.collections.ArrayList

open class Publication {
    var publisherName:String = ""
    var address:String = ""
    var monthPublished:String = ""
    var yearPublished: Date = Date()

    fun publicationType(){
        // TODO: Not yet implemented
    }
}

class Book (var title:String) : Publication(){
    var authors:String = ""
    var edition:String = ""
    var ISBN:Int = 0
    var publisher:String = ""
    var chapterList:ArrayList<String> = ArrayList()
    private var numberOfPages:Int? = null
}

class Magazine : Publication(){
    var editor:String = ""
}

class Newspaper(var name:String) : Publication(){
    var dayPublished:String = ""
}

class Comics(var title:String) : Publication(){
    var illustrators:String = ""
    var publisher: String = ""
}

enum class AudioVideoTypes {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT
}

class Authors(var firstName:String,var lastName:String,var middleName:String){
    var birthDate: Date = Date()
}

class Illustrator(var firstName:String, var lastName:String, var middleName: String){
    var birthDate:Date = Date()
}

// added class and methods for act_6b

data class User(var name:String){
    var borrowCount:Int = 0
    var unpaidDues:Double = 0.0
}

class Library{

    // book list w/ Status (Available/Reserved/Internal Use/For Fixing)
    var bookList:HashMap<String,String> = hashMapOf(
        "Don Quixote" to "Available",
        "Alice's Adventures in Wonderland" to "Available",
        "The Adventures of Tom Sawyer" to "Available",
        "Treasure Island" to "Available",
        "Pride and Prejudice" to "Available",
        "Wuthering Heights" to "Reserved",
        "East of Eden" to "Internal Use",
        "The Scarlet Letter" to "For Fixing")

    var borrowedItem:HashMap<User,Book> = HashMap()

    fun borrowItem(user:User,item:Book){
        var isReserved = bookList.getValue(item.title) == "Reserved"
        var isForInternalUse = bookList.getValue(item.title) == "Internal Use"
        var isForFixing = bookList.getValue(item.title) == "For Fixing"

        if(user.borrowCount >= 5)
            throw LibraryException.UserException.UserHas5orMoreItems()

        if(user.unpaidDues > 0.0)
            throw LibraryException.UserException.UserHasUnpaidDues()

        if(isReserved)
            throw LibraryException.ItemException.ItemIsReserved()

        if(isForInternalUse)
            throw LibraryException.ItemException.ItemIsForInternalUser()

        if(isForFixing)
            throw LibraryException.ItemException.ItemIsForFixing()

        borrowedItem[user] = item
        ++user.borrowCount
    }

}

sealed class LibraryException(message:String) : Exception(message){
    sealed class UserException(message:String) : LibraryException(message){
        class UserHas5orMoreItems(message:String = "Cannot borrow due to too many items still borrowed") : UserException(message)
        class UserHasUnpaidDues(message:String = "Cannot borrow due to unpaid dues") : UserException(message)
    }
    sealed class ItemException(message: String) : LibraryException(message){
        class ItemIsReserved(message:String = "Cannot borrow due to reserved"):ItemException(message)
        class ItemIsForInternalUser(message:String = "Cannot borrow due to item only used in library"):ItemException(message)
        class ItemIsForFixing(message:String = "Cannot borrow due to item needs to be fixed"):ItemException(message)
    }
}

fun main() {
    var user1 = User("James")
    var book1 = Book("Don Quixote")
    var book2 = Book("Wuthering Heights")
    var book3 = Book("East of Eden")
    var book4 = Book("The Scarlet Letter")

    // user 5 or more borrowed items exception
    user1.borrowCount = 5
    Library().borrowItem(user1,book1)

    // unpaid dues exception
    user1.unpaidDues = 500.0
    Library().borrowItem(user1,book1)

    // "reserved" exception
    Library().borrowItem(user1,book2)

    // "internal use" exception
    Library().borrowItem(user1,book3)

    // "for fixing" exception
    Library().borrowItem(user1,book4)

}




