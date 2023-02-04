package activity_03_c

import java.util.*

val groceryItems = arrayListOf("Coke","Sprite","C2 Lemon","C2 Apple","Fita",
    "Rebisco","Cloud 9","Refined White Sugar","Datu Puti Toyo","Datu Puti Suka",
    "Well-milled rice","Fidel Iodized Salt","UFC Ketchup","Ajinomoto MSG","Nutella",
    "Pinoy Tasty","Lily's Peanut Butter","Nescafe 3-in-1 Coffee","Nissin Noodles","Payless Pancit Canton")

var Cart = hashMapOf<String,Int>()

fun addToCart(item:String, quantity:Int) {
    var entry = 1
    var newItem = item
    if(Cart.containsKey(item)){
        while(Cart.containsKey(newItem)){
            if(entry < 10){
                newItem = item + "_0${entry}"
            }else{
                newItem = item + "_${entry}"
            }
            entry++
        }
    }
    Cart[newItem] = quantity
}

fun checkOut(){
    println("Checkout > Item in Cart: ")
    if(Cart.isEmpty()){
        println("Cart is empty.")
    }else {
        Cart.forEach{
            println("Item: ${it.key} | Quantity: ${it.value}")
        }
        print("Total: ${Cart.size} item/s")
    }
}

fun removefromCart(itemName:String){
    var entry = 1
    while(Cart.containsKey(itemName)){
        Cart.remove(itemName)
        println("Removed $itemName to cart.")
        entry++
    }
}

fun main() {
    var item:String? = null
    var quantity:Int? = null
    var prompt = ""
    var addMore = true
    println("Grocery Item List: ")
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
        if(prompt.equals("N", true)){
            addMore = false
        }
    }

    print("Do you want to remove item? (Y/N): ")
    prompt = readLine().toString()
    if (prompt.equals("Y", true)) {
        println("Items in cart: ")
        Cart.forEach {
            println("Item: ${it.key} | Quantity: ${it.value}")
        }
        print("Item to remove: ")
        item = readLine().toString()
        removefromCart(item)
    }

    print("Do you want to checkout? (Y/N): ")
    prompt = readLine().toString()
    if(prompt.equals("Y", true)) {
        checkOut()
    }
}


