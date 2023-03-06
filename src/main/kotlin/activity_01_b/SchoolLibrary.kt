package activity_01_b

import java.time.LocalDateTime

// updated 10-17-22

fun main() {

    var bookList = ArrayList<String>()
    var bookAllowedToBorrowList = ArrayList<String>()
    var bookBorrowed = ArrayList<String>()
    var bookReturned = ArrayList<String>()

    // book info
    var bookName: String = ""
    var bookAuthor: String = ""
    var bookPublisher: String = ""
    var bookISBN: Int = 0
    var bookType: String = ""
    var bookCondition: String = ""
    var bookQuantity: Int = 0
    var bookRemarks: String = "" // for other book info
    var bookBorrowStatus: String = ""

    // book borrow and return date and time
    var totalItemsInLibrary: Int = 0
}