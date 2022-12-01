package activity_05_c

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


// grocery in OOP

open class Grocery{
    var name:String = ""
    var price:Double = 0.0

    constructor(name:String,price:Double) {
        this.name = name
        this.price = price
    }
}

// grocery items - 12 total
class Bread(name:String, price:Double): Grocery(name, price) {
    var weight:Int = 0
    var brand:String = ""
    var breadType:String = ""
    var sku:Int = 0
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}
class BreadSpread(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var breadSpreadtype:String = ""
    var sku:Int = 0
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}

class CannedGoods(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var cannedGoodsType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}
class Condiments(name:String, price: Double): Grocery(name,price){
    var brand:String = ""
    var condimentType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}

class FrozenProducts(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var frozenProductType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}

class Fruits(name:String, price:Double): Grocery(name, price) {
    var fruitType:String = ""
    var weight:String = ""
    var sku:String = ""
}

class PersonalCare(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var itemType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var expirationDate: Date = Date()
}

class PetCare(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var petCareItemType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}

class Poultry(name:String, price: Double): Grocery(name,price){
    var poultryType:String = ""
    var bestBeforeDate: Date = Date()
    var sku:String = ""
}

class SanitaryProducts(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var sanitaryProductType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
}

class Snacks(name:String, price:Double): Grocery(name, price) {
    var brand:String = ""
    var snackType:String = ""
    var sku:String = ""
    var manufactureDate: Date = Date()
    var bestBeforeDate: Date = Date()
}

class Vegetables(name:String, price:Double): Grocery(name, price) {
    var vegetableType:String = ""
    var weight:String = ""
    var sku:String = ""
}

// cart
class Cart(var customer:Customer){
    var uniqueID:Any? = ""
    var items:HashMap<Grocery,Float> = HashMap()

    fun addItems(grocery:Grocery,quantity:Float){
        items[grocery] = quantity
    }
}

// customer
data class Customer(var name:String)

// add,remove and checkout cart
class CartFunction {
    fun addItemToCart(cart: Cart, grocery: Grocery, quantity: Float) {
        // checks if item in cart. if it exists, updates quantity
        if(cart.items.containsKey(grocery)){
            val newQuantity = cart.items.getValue(grocery) + quantity
            cart.addItems(grocery, newQuantity)
        }else {
            cart.addItems(grocery, quantity)
        }
        println("Added ${grocery.name} (Qty: ${quantity.toInt()}) to cart.")
    }

    fun removeFromCart(cart: Cart, grocery: Grocery) {
        // removes said item and its duplicate
        if(cart.items.containsKey(grocery)) {
            cart.items.remove(grocery)
        }
        println("Removed ${grocery.name} to cart.")
    }

    fun checkoutCart(cart: Cart) {
        var itemCost:Double
        val totalCost:Double
        val itemCostList:ArrayList<Double> = ArrayList()
        val separator = CharArray(60) { '-' }

        if (cart.items.isEmpty()) {
            println("Cart is empty.")
        }

        // calculating total per item and total cost
        for(items in cart.items.entries){
            itemCost = items.key.price * items.value
            itemCostList.add(itemCost)
        }
        totalCost = itemCostList.sum()

        // print cart items
        println(separator)
        cart.items.forEach {
            println("${it.key.name} | Qty: ${it.value.toInt()} | ${priceFormat(it.key.price)} | Cost: ${priceFormat((it.key.price) * it.value)}")
        }
        println(separator)
        print("Total Cost: ${priceFormat(totalCost)} ")
    }

    fun priceFormat(number:Double): String{
        val decimalFormat = DecimalFormat("#,###.00")
        val formattedPrice = decimalFormat.format(number)

        return "₱ $formattedPrice"
    }

}

fun main(){
    var customer1 = Customer("James")
    var cart1 = Cart(customer1)
    var item1 = CannedGoods("Spam Regular Luncheon Meat 340g",228.00)
    var item2 = BreadSpread("Nutella Chocolate Hazelnut Spread 680g",441.0)
    var item3 = Condiments("Pepper Ground 28g",56.00)
    var item4 = Poultry("Overpriced Egg",1_000_000.0)
    var cartFunction = CartFunction()

    // add cart items
    cartFunction.addItemToCart(cart1,item1,100.0F)
    cartFunction.addItemToCart(cart1,item1,200.0F)
    cartFunction.addItemToCart(cart1,item2,3.0F)
    cartFunction.addItemToCart(cart1,item3,3.0F)
    cartFunction.addItemToCart(cart1,item3,3.0F)
    cartFunction.addItemToCart(cart1,item4,3.0F)


    // remove cart item
    cartFunction.removeFromCart(cart1,item4)

    // cart checkout
    cartFunction.checkoutCart(cart1)

}

