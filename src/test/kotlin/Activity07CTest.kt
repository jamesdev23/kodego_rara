import activity_07_c.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CartTest {
    val cartFunction: CartFunction = CartFunction()

    val customer1 = Customer("Sample Customer")
    val cart1 = Cart(customer1)
    val noName = Bread("",30.0)
    val priceNaN = Bread("Bread Loaf", Double.NaN)
    val bread = Bread("Bread Load",30.0)
    val price1000000andUp = Bread("Bread Loaf",10_000_000.0)
    val noPrice = Bread("Bread Loaf", 0.0)
    val priceNegative = Bread("Bread Loaf",-1_000.0)

    @Test
    fun addItemToCart() {

        assertThrows<CartException.EmptyOrNotANumberException.ItemNameIsEmpty> {
            cartFunction.addItemToCart(cart1,noName,1.0F)
        }

        assertThrows<CartException.EmptyOrNotANumberException.PriceIsNotANumber> {
            cartFunction.addItemToCart(cart1,priceNaN,10.0F)
        }

        assertThrows<CartException.EmptyOrNotANumberException.QuantityIsNotANumber> {
            cartFunction.addItemToCart(cart1,bread, Float.NaN)
        }
    }

    @Test
    fun checkoutCart() {

        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cart1.items.clear()
            cart1.items[price1000000andUp] = 10.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityExceedsMaxLimit> {
            cart1.items.clear()
            cart1.items[bread] = 1_000.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cart1.items.clear()
            cart1.items[noPrice] = 1.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cart1.items.clear()
            cart1.items[bread] = 0.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cart1.items.clear()
            cart1.items[priceNegative] = 10.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cart1.items.clear()
            cart1.items[bread] = -10.0F
            cartFunction.checkoutCart(cart1)
        }
    }
}
