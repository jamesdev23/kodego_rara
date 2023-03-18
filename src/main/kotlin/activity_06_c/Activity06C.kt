package activity_06_c

class Checkout{
    fun checkCart(itemName: String, price: Double, quantity: Float) {
        when {
            itemName.isEmpty() -> throw CartException.EmptyException.ItemNameIsEmpty()
            price >= 1_000_000.0 -> throw CartException.QuantityPriceException.PriceExceedsMaxLimit()
            quantity >= 1_000 -> throw CartException.QuantityPriceException.QuantityExceedsMaxLimit()
            price == 0.0 -> throw CartException.QuantityPriceException.PriceIsZero()
            price < 0.0 -> throw CartException.QuantityPriceException.PriceBelowZero()
            quantity == 0.0F -> throw CartException.QuantityPriceException.QuantityIsZero()
            quantity < 0.0F -> throw CartException.QuantityPriceException.QuantityBelowZero()
        }
    }
}

sealed class CartException(message:String) : Exception(message){
    sealed class EmptyException(message: String) : CartException(message){
        class ItemNameIsEmpty(message:String = "Item name is empty") : EmptyException(message)
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
    val checkout = Checkout()
    checkout.checkCart("",100.0,1.0F)
    checkout.checkCart("Overpriced Item",1_000_000.0,1.0F)
    checkout.checkCart("1000+ items",100.0,1_000.0F)
    checkout.checkCart("Item w/ no price",0.0,10.0F)
    checkout.checkCart("Item w/ no quantity",100.0,0.0F)
    checkout.checkCart("negative price",-100.0,10.0F)
    checkout.checkCart("negative quantity",100.0,-10.0F)

}