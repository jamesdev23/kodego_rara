package activity_06_c

class Checkout {
    fun checkCart(itemName:String, quantity:Int, price: Double) {
        if(itemName.isEmpty())
            throw CartException.ItemNameException.ItemNameIsEmpty()

        if(quantity > 999 || price > 999_999.0)
            throw CartException.QuantityOrPriceExceedsMaxLimit()

        if(quantity == 0)
            throw CartException.QuantityException.QuantityIsZero()

        if(price == 0.0)
            throw CartException.PriceException.PriceIsZero()

        if(quantity < 0)
            throw CartException.QuantityException.QuantityBelowZero()

        if(price < 0.0)
            throw CartException.PriceException.PriceBelowZero()
    }
}

sealed class CartException(message:String) : Exception(message){
    sealed class ItemNameException(message: String) : CartException(message){
        class ItemNameIsEmpty(message:String = "Item name is empty") : ItemNameException(message)
    }
    class QuantityOrPriceExceedsMaxLimit(message:String = "Quantity or Price Exceeds Max Limit"):CartException(message)

    sealed class QuantityException(message: String) : CartException(message){
        class QuantityIsZero(message:String = "Quantity is set to zero"):QuantityException(message)
        class QuantityBelowZero(message:String = "Quantity is below zero"):QuantityException(message)
    }

    sealed class PriceException(message: String) : CartException(message){
        class PriceIsZero(message: String = "Price is set to zero"):PriceException(message)
        class PriceBelowZero(message: String = "Price is below zero"):PriceException(message)
    }
}

fun main(){
    var result = Checkout().checkCart("",1_000,1_000_000.0)
    println(result)
}