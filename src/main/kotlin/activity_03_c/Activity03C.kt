package activity_03_c

// create arraylist of 20 grocery items and make functions according to instruction

val groceryItems:ArrayList<String> = arrayListOf("Coke","Sprite","C2 Lemon","C2 Apple","Fita",
    "Rebisco","Cloud 9","Refined White Sugar","Datu Puti Toyo","Datu Puti Suka",
    "Well-milled rice","Fidel Iodized Salt","UFC Ketchup","Ajinomoto MSG","Nutella",
    "Pinoy Tasty","Lily's Peanut Butter","Nescafe 3-in-1 Coffee","Nissin Noodles","Payless Pancit Canton")

var Cart:HashMap<String,Int> = hashMapOf()
fun main(){
    var item:String? = null
    var quantity:Int? = null
    var prompt = ""
    var addMore = true
    var removeMore = true

    println("Grocery Item List: ")
    println("===================")
    groceryItems.forEach{
        println("- $it")
    }
    while(addMore) {
        print("Choose item to add: ")
        item = readLine().toString()
        // checks for empty item name. breaks loop if true and proceeds to next step
        if(item.isEmpty()){
            println("Item name can't be empty")
            break
        }
        print("Quantity: ")
        quantity = readLine()!!.toInt()
        // checks if quantity is 1 and above. if not, breaks loop and proceeds to next step
        if(quantity > 0){
            addToCart(item,quantity)
        }else{
            println("Quantity can't be 0 or below")
            break
        }

        println("Do you want to add more item? (Y/N): ")
        prompt = readLine().toString()
        if(prompt == "N" || prompt == "n"){
            addMore = false
        }
    }

    print("Do you want to remove item? (Y/N): ")
    prompt = readLine().toString()
    if (prompt == "Y" || prompt == "y") {
        println("Items in cart: ")
        println("===============")
        Cart.forEach {
            println("Item: ${it.key} | Quantity: ${it.value}")
        }
        println("===============")
        print("Item to remove: ")
        item = readLine().toString()
        removefromCart(item)
    }

    print("Do you want to checkout? (Y/N): ")
    prompt = readLine().toString()
    if(prompt == "Y" || prompt == "y") {
        checkOut()
    }

}

fun addToCart(itemName:String, quantity:Int){
    var entry = 0
    var newItemName = itemName
    // checks if item in cart. if it exists, creates a new entry
    if(Cart.contains(itemName)){
        while(Cart.contains(newItemName)){
            ++entry
            if(entry < 10){
                newItemName = itemName + "_0${entry}"
            }else{
                newItemName = itemName + "_${entry}"
            }
        }
        Cart.put(newItemName,quantity)
    }else{
        Cart.put(itemName,quantity)
    }
    println("Added $itemName (Qty:$quantity) to cart.")
}

fun checkOut(){
    println("Checkout > Item in Cart: ")
    println("=========================")
    if(Cart.isEmpty()){
        println("Cart is empty.")
    }
    Cart.forEach{
        println("Item: ${it.key} | Quantity: ${it.value}")
    }
    println("=========================")
    print("Total: ${Cart.size} item/s")
}

fun removefromCart(itemName:String){
    var entry = 0
    var newItemName = itemName
    // removes said item and it's duplicate
    if(Cart.containsKey(newItemName)){
        while(Cart.containsKey(newItemName)){
            Cart.remove(newItemName)
            println("Removed $newItemName to cart.")
            ++entry
            if(entry < 10){
                newItemName = itemName + "_0${entry}"
            }else{
                newItemName = itemName + "_${entry}"
            }
        }
    }else{
        Cart.remove(newItemName)
        println("Removed $newItemName to cart.")
    }
}