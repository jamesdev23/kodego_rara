package activity_01_b

import java.time.LocalDateTime

// updated 10-17-22

fun main() {
    var bookList = ArrayList<String>(100)
    var bookAllowedToBorrowList = ArrayList<String>(100)
    var bookBorrowed = ArrayList<String>(5)
    var bookReturned = ArrayList<String>(5)

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
    var itemBorrowDateTime = LocalDateTime.parse("10-10-22T10:00:00")
    var itemReturnDateTime = LocalDateTime.parse("10-17-22T10:00:00")
    var totalItemsInLibrary: Int? = null
}