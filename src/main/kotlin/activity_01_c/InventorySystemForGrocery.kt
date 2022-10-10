package activity_01_c

import java.time.LocalDateTime
import java.time.Month

fun main() {
    var groceryItemOnSale = listOf("condiments","frozen goods","other items in grocery") // etc.
    var itemName: String? = null
    var itemSKU: String? = null
    var isPerishable: Boolean? = null
    var expiryDate = LocalDateTime.of(2027, Month.OCTOBER, 10, 19, 0,0)
    var itemCategory: String? = null
    var itemCharacteristic: String? = null
    var itemCount: Int? = null
    var itemOnSaleTotal: Int? = null
    var ItemSoldTotal: Int? = null
}