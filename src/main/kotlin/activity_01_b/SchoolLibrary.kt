package activity_01_b

import java.time.LocalDateTime
import java.time.Month

fun main() {
    var ItemAllowedToBorrow = listOf("textbook1","dictionary1","novel1")  // etc.
    var itemName: String? = null
    var itemType: String? = null
    var itemCharacteristic: String? = null
    var itemCount: Int? = null
    var itemBorrowStatus: String? = null
    var itemBorrowed = listOf("textbook1")
    var itemReturned = listOf("novel1")
    var itemBorrowDateTime = LocalDateTime.of(2022, Month.OCTOBER, 10, 19, 0,0)
    var itemReturnDateTime = LocalDateTime.of(2022, Month.OCTOBER, 17, 19, 0,0)
    var totalItemsInLibrary: Int? = null
}