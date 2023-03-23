import activity_07_c.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GroceryUnitTest {
    private val customer1 = Customer("John Smith")
    private val customer2 = Customer("Juan Dela Cruz")
    private val cart1 = Cart(customer1)
    private val cart2 = Cart(customer2)
    private val noItemName = Bread("",30.0)
    private val priceNaN = Bread("Bread Loaf With Glitched Price", Double.NaN)
    private val bread = Bread("Bread Loaf",30.0)
    private val price1000000andUp = Bread("Expensive Bread Loaf",10_000_000.0)
    private val noPrice = Bread("Free Bread Loaf", 0.0)
    private val priceNegative = Bread("More Than Free Bread Loaf",-1_000.0)

    @Test
    fun addItemToCart() {
        assertThrows<CartException.EmptyOrNotANumberException.ItemNameIsEmpty> {
            addItemToCart(cart1, noItemName, 1.0F)
            addItemToCart(cart2, noItemName, 10.0F)
        }

        assertThrows<CartException.EmptyOrNotANumberException.PriceIsNotANumber> {
            addItemToCart(cart1, priceNaN, 10.0F)
        }

        assertThrows<CartException.EmptyOrNotANumberException.QuantityIsNotANumber> {
            addItemToCart(cart1, bread, Float.NaN)
        }
    }

    @Test
    fun checkoutCart() {
        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cart1.items[price1000000andUp] = 10.0F
            checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityExceedsMaxLimit> {
            cart1.items[bread] = 1_001.0F
            checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cart1.items[noPrice] = 1.0F
            checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cart1.items[bread] = 0.0F
            checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cart1.items[priceNegative] = 10.0F
            checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cart1.items[bread] = -10.0F
            checkoutCart(cart1)
        }
    }
}
