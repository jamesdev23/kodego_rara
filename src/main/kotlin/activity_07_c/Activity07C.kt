package activity_07_c

open class Grocery{
    var name:String = ""
    var price:Double = 0.0

    constructor(name:String,price:Double) {
        this.name = name
        this.price = price
    }
}

// grocery item type
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

class CartFunction {
    fun checkCart(itemname:String,price:Double,quantity:Float) {
        if(itemname.isEmpty())
            throw CartException.EmptyException.ItemNameIsEmpty()
        if(quantity > 999 || price > 999_999.0)
            throw CartException.QuantityPriceException.QuantityOrPriceExceedsMaxLimit()
        if(price == 0.0)
            throw CartException.QuantityPriceException.PriceIsZero()
        if(price < 0.0)
            throw CartException.QuantityPriceException.PriceBelowZero()
        if(quantity == 0.0F)
            throw CartException.QuantityPriceException.QuantityIsZero()
        if(quantity < 0.0F)
            throw CartException.QuantityPriceException.QuantityBelowZero()
    }

    fun addItemToCart(cart: Cart, grocery: Grocery, quantity: Float) {
        checkCart(grocery.name,grocery.price,quantity)
        cart.addItems(grocery, quantity)
        //println("Added ${grocery.name} (Qty:${quantity.toInt()}) to cart.")
    }

    fun removeFromCart(cart: Cart, grocery: Grocery) {
        // removes said item and its duplicate
        if (cart.items.containsKey(grocery)) {
            cart.items.remove(grocery)
        }
        //println("Removed ${grocery.name} to cart.")
    }

    fun checkoutCart(cart: Cart) {
        cart.items.forEach {
            checkCart(it.key.name,it.key.price,it.value)
            println("Item: ${it.key.name} | Price: ${it.key.price} | Quantity: ${it.value.toInt()}")
        }
        print("Total: ${cart.items.size} item/s")
    }
}

sealed class CartException(message:String) : Exception(message){
    sealed class EmptyException(message: String) : CartException(message){
        class ItemNameIsEmpty(message:String = "Item name is empty") : EmptyException(message)
    }
    sealed class QuantityPriceException(message: String) : CartException(message){
        class QuantityOrPriceExceedsMaxLimit(message:String = "Quantity or Price Exceeds Max Limit"):CartException(message)
        class QuantityIsZero(message:String = "Quantity is set to zero"):QuantityPriceException(message)
        class QuantityBelowZero(message:String = "Quantity is below zero"):QuantityPriceException(message)
        class PriceIsZero(message: String = "Price is set to zero"):QuantityPriceException(message)
        class PriceBelowZero(message: String = "Price is below zero"):QuantityPriceException(message)
    }
}

fun main(){
//    var customer1 = Customer("James")
//    var customer1Cart = Cart(customer1)
//    var CartFunction = CartFunction()
//    var item1 = CannedGoods("Spam Regular Luncheon Meat 340g",228.0)
//    var item2 = Poultry("Egg",8.0)
//    var item3 = Condiments("Pepper Ground 28g",56.0)
//    var item4 = Poultry("Overpriced Egg",1_000_000.0)
//
//    // cart checkout
//    CartFunction.checkCart("",100.0,1.0F)

}