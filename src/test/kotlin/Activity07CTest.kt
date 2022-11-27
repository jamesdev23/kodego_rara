import activity_07_c.CartException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import activity_07_c.CartFunction

internal class CartTest {
    val cartFunction: CartFunction = CartFunction()

    @Test
    fun checkCart() {

        assertThrows<CartException.EmptyException.ItemNameIsEmpty> {
            cartFunction.checkCart("",50.0,10.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityOrPriceExceedsMaxLimit> {
            cartFunction.checkCart("Sample Item",1_000_000.0,1000.0F)
        }

        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cartFunction.checkCart("Sample Item",0.0,10.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cartFunction.checkCart("Sample Item",50.0,0.0F)
        }

        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cartFunction.checkCart("Sample Item",-100.0,20.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cartFunction.checkCart("Sample Item",100.0,-20.0F)
        }
    }
}
