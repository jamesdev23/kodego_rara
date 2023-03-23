package activity_03_c

private val groceryItems = arrayListOf("Coke","Sprite","C2 Lemon","C2 Apple","Fita",
    "Rebisco","Cloud 9","Refined White Sugar","Datu Puti Toyo","Datu Puti Suka",
    "Well-milled rice","Fidel Iodized Salt","UFC Ketchup","Ajinomoto MSG","Nutella",
    "Pinoy Tasty","Lily's Peanut Butter","Nescafe 3-in-1 Coffee","Nissin Noodles","Payless Pancit Canton")

private var cart = hashMapOf<String,Int>()

fun addToCart(item:String, quantity:Int) {
    var entry = 1
    var newItem = item
    if(cart.containsKey(item)){
        while(cart.containsKey(newItem)){
            if(entry < 10){
                newItem = item + "_0${entry}"
            }else{
                newItem = item + "_${entry}"
            }
            entry++
        }
    }
    cart[newItem] = quantity
}

fun checkOut(){
    println("Checkout > Item in exercise_oop.Cart: ")
    if(cart.isEmpty()){
        println("exercise_oop.Cart is empty.")
    }else {
        cart.forEach{
            println("Item: ${it.key} | Quantity: ${it.value}")
        }
        print("Total: ${cart.size} item/s")
    }
}

fun removefromCart(itemName:String){
    var entry = 1
    while(cart.containsKey(itemName)){
        cart.remove(itemName)
        println("Removed $itemName to cart.")
        entry++
    }
}

fun main() {
    var item:String? = null
    var quantity:Int? = null
    var prompt = ""
    println("Grocery Item List: ")
    groceryItems.forEach{
        println("- $it")
    }
    while(true) {
        print("Choose item to add: ")
        item = readLine().toString()
        if(item.isEmpty()){
            println("Item name can't be empty")
            break
        }
        print("Quantity: ")
        quantity = readLine()!!.toInt()
        if(quantity > 0){
            addToCart(item,quantity)
        }else{
            println("Quantity can't be 0 or below")
            break
        }

        print("Do you want to add more item? (Y/N): ")
        prompt = readLine().toString()
        if(prompt.equals("N", true)){
            break
        }
    }

    print("Do you want to remove item? (Y/N): ")
    prompt = readLine().toString()
    if (prompt.equals("Y", true)) {
        println("Items in cart: ")
        cart.forEach {
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


