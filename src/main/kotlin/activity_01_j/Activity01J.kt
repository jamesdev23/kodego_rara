package activity_01_j
import java.time.LocalDate

// grocery cart. user: cashier

fun main(){
    var groceryItemList = ArrayList<String>()
    var isPerishable: Boolean? = null
    var itemSKU: String? = null
    var itemColor: String? = null
    var itemType: String? = null
    var itemOnSaleTotal: Int? = null
    var ItemSoldTotal: Int? = null

    // grocery cart var
    var itemName: String? = null
    var itemQuantity:Int? = null
    var itemPrice:Float? = null
    var optionsInput:String? = null
    var itemCount = 0
    var itemTotal:Float? = null
    var totalCost:Float? = null
    var itemPriceRounded = ""
    var totalPerItemRounded = ""
    var totalCostRounded = ""


    // array list for carts
    var itemsInCart = ArrayList<String>()
    var itemsInCartQuantity = ArrayList<Int>()
    var itemsInCartPrice = ArrayList<Float>()
    var totalPerItem = ArrayList<Float>()


    println("============")
    println("Grocery Cart")
    println("============")
    do{
        var addToCart = true
        println("Enter item name: ")
        itemName = readLine()!!.toString()
        println("Quantity (per piece): ")
        itemQuantity = readLine()!!.toInt()
        println("Price (per item): ")
        itemPrice = readLine()!!.toFloat()
        if(itemPrice > 0 && itemQuantity > 0){
            itemCount ++
            itemsInCart.add(itemName)
            itemsInCartQuantity.add(itemQuantity)
            itemsInCartPrice.add(itemPrice)
            itemTotal = itemQuantity * itemPrice
            totalPerItem.add(itemTotal)
        }else{
            println("Error: Quantity and price can't be 0")
            break
        }
        println("Item \"$itemName\" added to cart")
        println("Would you like to add another item? (Y/N): ")
        optionsInput = readLine().toString()
        if(optionsInput == "N" || optionsInput == "n"){
            addToCart = false
        }
    } while(addToCart)

    println("Proceeds to Checkout...")
    println("Items in Cart: ")
    println("======================================================================")
    for(index in 0 until itemCount){
        itemPriceRounded = String.format("%.2f", itemsInCartPrice[index])
        totalPerItemRounded = String.format("%.2f", totalPerItem[index])
        println("${index+1}. ${itemsInCart[index]} | ${itemsInCartQuantity[index]} pc/s. | P $itemPriceRounded | Total: P $totalPerItemRounded")
    }
    println("======================================================================")
    println("No. of items: $itemCount")
    totalCost = totalPerItem.sum()
    totalCostRounded = String.format("%.2f", totalCost)
    println("Total Cost: P $totalCostRounded")

}