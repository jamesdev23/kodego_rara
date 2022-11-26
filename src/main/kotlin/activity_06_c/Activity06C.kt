package activity_06_c

class Checkout {

    fun computeCart(quantity:Int, price: Double): Double? {
        var result = 0.0

        // scenarios (5 total)
        if(quantity > 1_000 || price > 1_000_000.0)
            throw CartException.QuantityOrPriceExceedsMaximumValue()

        if(quantity == 0)
            throw CartException.QuantityException.QuantityIsZero()

        if(quantity < 0)
            throw CartException.QuantityException.QuantityBelowZero()

        if(price == 0.0)
            throw CartException.PriceException.PriceIsZero()

        if(price < 0.0)
            throw CartException.PriceException.PriceBelowZero()

        result = quantity * price

        return result
    }
}

sealed class CartException(message:String) : Exception(message){

    class QuantityOrPriceExceedsMaximumValue(message:String = "Quantity or Price Exceeds Maximum Cart Limit"):CartException(message)

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
    var result = Checkout().computeCart(10,0.0)
    println(result)
}