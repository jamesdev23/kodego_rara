package activity_07_c

import java.text.DecimalFormat
import java.util.*
import kotlin.collections.HashMap

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
data class Customer(var name:String)

class Cart(var customer:Customer){
    var uniqueID = ""
    var items:HashMap<Grocery,Float> = HashMap()

    fun addItems(grocery:Grocery,quantity:Float){
        items[grocery] = quantity
    }
}

class CartFunction {
    fun checkAddCart(itemName: String, price: Double, quantity: Float) {
        if (itemName.isEmpty())
            throw CartException.EmptyOrNotANumberException.ItemNameIsEmpty()
        if (price.isNaN())
            throw CartException.EmptyOrNotANumberException.PriceIsNotANumber()
        if (quantity.isNaN())
            throw CartException.EmptyOrNotANumberException.QuantityIsNotANumber()
    }

    fun checkCart(itemName: String, price: Double, quantity: Float) {
        if (price >= 1_000_000.0)
            throw CartException.QuantityPriceException.PriceExceedsMaxLimit()
        if (quantity >= 1_000)
            throw CartException.QuantityPriceException.QuantityExceedsMaxLimit()
        if (price == 0.0)
            throw CartException.QuantityPriceException.PriceIsZero()
        if (price < 0.0)
            throw CartException.QuantityPriceException.PriceBelowZero()
        if (quantity == 0.0F)
            throw CartException.QuantityPriceException.QuantityIsZero()
        if (quantity < 0.0F)
            throw CartException.QuantityPriceException.QuantityBelowZero()
    }

    fun addItemToCart(cart: Cart, grocery: Grocery, quantity: Float) {
        // checks cart
        checkAddCart(grocery.name,grocery.price,quantity)

        if(cart.items.containsKey(grocery)){
            var newQuantity = cart.items.getValue(grocery) + quantity
            cart.addItems(grocery, newQuantity)
        }else {
            cart.addItems(grocery, quantity)
        }
        println("Added ${grocery.name} (Qty: ${quantity.toInt()}) to cart.")
    }

    fun removeFromCart(cart: Cart, grocery: Grocery) {
        // removes said item and its duplicate
        if (cart.items.containsKey(grocery)) {
            cart.items.remove(grocery)
        }
        println("Removed ${grocery.name} to cart.")
    }

    fun checkoutCart(cart: Cart) {
        var itemCost:Double
        val totalCost:Double
        val itemCostList:ArrayList<Double> = ArrayList()
        val separator = CharArray(60) { '-' }

        // checks cart and calculate total cost
        for(items in cart.items.entries){
            checkCart(items.key.name,items.key.price,items.value)
            itemCost = items.key.price * items.value
            itemCostList.add(itemCost)
        }
        totalCost = itemCostList.sum()

        // print cart items
        println(separator)
        cart.items.forEach {
            println("${it.key.name} | Qty: ${it.value.toInt()} | ₱ ${priceFormat(it.key.price)} | Cost: ₱ ${priceFormat((it.key.price) * it.value)}")
        }
        println(separator)

        print("Total Cost: ₱ ${priceFormat(totalCost)} ")
    }

    fun priceFormat(number:Double): String{
        val decimalFormat = DecimalFormat("#,###.00")
        return decimalFormat.format(number)
    }
}

sealed class CartException(message:String) : Exception(message){
    sealed class EmptyOrNotANumberException(message: String) : CartException(message){
        class ItemNameIsEmpty(message:String = "Item name is empty") : EmptyOrNotANumberException(message)
        class PriceIsNotANumber(message:String = "Price is not a number") : EmptyOrNotANumberException(message)
        class QuantityIsNotANumber(message:String = "Quantity is not a number") : EmptyOrNotANumberException(message)
    }
    sealed class QuantityPriceException(message: String) : CartException(message){
        class PriceExceedsMaxLimit(message:String = "Price Exceeds Max Limit (1,000,000)"):CartException(message)
        class QuantityExceedsMaxLimit(message:String = "Quantity Exceeds Max Limit (1,000)"):CartException(message)
        class PriceIsZero(message: String = "Price is set to zero"):QuantityPriceException(message)
        class PriceBelowZero(message: String = "Price is below zero"):QuantityPriceException(message)
        class QuantityIsZero(message:String = "Quantity is set to zero"):QuantityPriceException(message)
        class QuantityBelowZero(message:String = "Quantity is below zero"):QuantityPriceException(message)
    }
}

fun main(){
    var customer1 = Customer("James")
    var cart1 = Cart(customer1)
    var cartFunction = CartFunction()
    var item1 = CannedGoods("Spam Regular Luncheon Meat 340g",228.0)
    var item2 = BreadSpread("Nutella Chocolate Hazelnut Spread 680g",441.0)
    var item3 = Condiments("Pepper Ground 28g",56.0)
    var item4 = Poultry("Overpriced Egg",1_000_000.0)

    cartFunction.addItemToCart(cart1,item1,1.0F)
//    cartFunction.addItemToCart(cart1,item2,10.0F)
//    cartFunction.addItemToCart(cart1,item3,5.0F)
//
//    cartFunction.removeFromCart(cart1,item3)
//
    cartFunction.checkoutCart(cart1)
}