package activity_06_c
class CartFunction {
    fun checkCart(itemName: String, price: Double, quantity: Float) {
        if (itemName.isEmpty())
            throw CartException.EmptyException.ItemNameIsEmpty()
        if (quantity > 999 || price > 999_999.0)
            throw CartException.QuantityPriceException.QuantityOrPriceExceedsMaxLimit()
        if (price == 0.0)
            throw CartException.QuantityPriceException.PriceIsZero()
        if (price < 0.0)
            throw CartException.QuantityPriceException.PriceBelowZero()
        if (quantity == 0.0F)
            throw CartException.QuantityPriceException.QuantityIsZero()
        if (quantity < 0.0F)
            throw CartException.QuantityPriceException.QuantityBelowZero()
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
    val CartFunction = CartFunction()
    val result = CartFunction.checkCart("",1_000_000.0,1_000.0F)
    println(result)
}