package activity_01_j

fun main(){
    var groceryItemList = ArrayList<String>()
    var isPerishable: Boolean = false
    var itemSKU: String = ""
    var itemColor: String = ""
    var itemType: String = ""
    var itemOnSaleTotal: Int = 0
    var ItemSoldTotal: Int = 0

    var itemName: String = ""
    var itemQuantity:Int = 0
    var itemPrice:Float = 0.0F
    var optionsInput:String = ""
    var itemCount = 0
    var itemTotal:Float = 0.0F
    var totalCost:Float = 0.0F
    var itemPriceRounded = ""
    var totalPerItemRounded = ""
    var totalCostRounded = ""

    var itemsInCart = ArrayList<String>()
    var itemsInCartQuantity = ArrayList<Int>()
    var itemsInCartPrice = ArrayList<Float>()
    var totalPerItem = ArrayList<Float>()


    println("Grocery exercise_oop.Cart")
    while(true){
        print("Enter item name: ")
        itemName = readLine()!!.toString()
        print("Quantity (per piece): ")
        itemQuantity = readLine()!!.toInt()
        print("Price (per item): ")
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
            break
        }
    }

    println("Proceeds to Checkout...")
    println("Items in exercise_oop.Cart: ")
    for(index in 0 until itemCount){
        itemPriceRounded = String.format("%.2f", itemsInCartPrice[index])
        totalPerItemRounded = String.format("%.2f", totalPerItem[index])
        println("${index+1}. ${itemsInCart[index]} | ${itemsInCartQuantity[index]} pc/s. | P $itemPriceRounded | Total: P $totalPerItemRounded")
    }
    println("No. of items: $itemCount")
    totalCost = totalPerItem.sum()
    totalCostRounded = String.format("%.2f", totalCost)
    println("Total Cost: P $totalCostRounded")

}