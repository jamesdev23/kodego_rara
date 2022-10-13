package activity_01_b

import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

fun main() {
    var ItemAllowedToBorrow = listOf("textbook","dictionary","novel")  // etc.
    var itemName: String? = null
    var itemType: String? = null
    var itemCharacteristic: String? = null
    var itemCount: Int? = null
    var itemBorrowStatus: String? = null
    var itemBorrowed = listOf("textbook1")
    var itemReturned = listOf("novel1")
    var itemBorrowDateTime = LocalDateTime.parse("10-10-22T10:00:00")
    var itemReturnDateTime = LocalDateTime.parse("10-17-22T10:00:00")
    var totalItemsInLibrary: Int? = null
}