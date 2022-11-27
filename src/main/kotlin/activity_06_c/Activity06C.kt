package activity_06_c

class CartFunction {
    fun checkCart(itemname: String, price: Double, quantity: Float) {
        if (itemname.isEmpty())
            throw activity_07_c.CartException.EmptyException.ItemNameIsEmpty()
        if (quantity > 999 || price > 999_999.0)
            throw activity_07_c.CartException.QuantityPriceException.QuantityOrPriceExceedsMaxLimit()
        if (price == 0.0)
            throw activity_07_c.CartException.QuantityPriceException.PriceIsZero()
        if (price < 0.0)
            throw activity_07_c.CartException.QuantityPriceException.PriceBelowZero()
        if (quantity == 0.0F)
            throw activity_07_c.CartException.QuantityPriceException.QuantityIsZero()
        if (quantity < 0.0F)
            throw activity_07_c.CartException.QuantityPriceException.QuantityBelowZero()
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
    var CartFunction = CartFunction()
    var result = CartFunction.checkCart("",1_000_000.0,1_000.0F)
    println(result)
}