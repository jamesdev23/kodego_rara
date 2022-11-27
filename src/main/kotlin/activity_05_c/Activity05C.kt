package activity_05_c

// grocery in OOP

open class Grocery{
    var name:String = ""
    var price:Double = 0.0

    constructor(name:String,price:Double) {
        this.name = name
        this.price = price
    }
}

class CannedGoods(name:String, price:Double): Grocery(name, price) {
    var quantity:Float = 0.0F
    var quantityUnits:String = "per Piece"
}
class Condiments(name:String, price: Double): Grocery(name,price){
    var quantity:Float = 0.0F
    var quantityUnits:String = "per Piece"
}
class Poultry(name:String, price: Double): Grocery(name,price){
    var quantity:Float = 0.0F
    var quantityUnits:String = "per Piece"
}


class Cart(var customer:Customer){
    var uniqueID = ""
    var items:HashMap<Grocery,Float> = HashMap()

    fun addItems(grocery:Grocery,quantity:Float){
        items[grocery] = quantity
    }
}

data class Customer(var name:String)

class Carts {
    fun addItemToCart(cart: Cart, grocery: Grocery, quantity: Float) {
        // add conditional to add duplicate item
        if (cart.items.containsKey(grocery)) {
            cart.addItems(grocery, quantity)
        }
        cart.addItems(grocery, quantity)
        println("Added ${grocery.name} (Qty:${quantity.toInt()}) to cart.")
    }

    fun removeFromCart(cart: Cart, grocery: Grocery) {
        // removes said item and its duplicate
        if (cart.items.containsKey(grocery)) {
            cart.items.remove(grocery)
        }
        println("Removed ${grocery.name} to cart.")
    }

    fun checkoutCart(cart: Cart) {
        if (cart.items.isEmpty()) {
            println("Cart is empty.")
        }
        cart.items.forEach {
            println("Item: ${it.key.name} | Price: ${it.key.price} | Quantity: ${it.value.toInt()}")
        }
        print("Total: ${cart.items.size} item/s")
    }
}

fun main(){
    var customer1 = Customer("James")
    var customer1Cart = Cart(customer1)
    var item1 = CannedGoods("Spam Regular Luncheon Meat 340g",228.0)
    var item2 = Poultry("Egg",8.0)
    var item3 = Condiments("Pepper Ground 28g",56.0)

    // add cart items
    Carts().addItemToCart(customer1Cart,item1,2.0F)
    Carts().addItemToCart(customer1Cart,item2,6.0F)
    Carts().addItemToCart(customer1Cart,item2,6.0F)
    Carts().addItemToCart(customer1Cart,item3,1.0F)

    // remove cart item
    Carts().removeFromCart(customer1Cart,item2)

    // cart checkout
    Carts().checkoutCart(customer1Cart)

}

