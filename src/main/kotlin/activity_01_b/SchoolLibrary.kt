package activity_01_b

import java.time.LocalDateTime

// updated 10-17-22

fun main() {

    var bookList = ArrayList<String>()
    var bookAllowedToBorrowList = ArrayList<String>()
    var bookBorrowed = ArrayList<String>()
    var bookReturned = ArrayList<String>()

    // book info
    var bookName: String? = null
    var bookAuthor: String? = null
    var bookPublisher: String? = null
    var bookISBN: Int? = null
    var bookType: String? = null
    var bookCondition: String? = null
    var bookQuantity: Int? = null
    var bookRemarks: String? = null // for other book info
    var bookBorrowStatus: String? = null

    // book borrow and return date and time
    var totalItemsInLibrary: Int? = null
}