import activity_07_c.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CartTest {
    val customer1 = Customer("John Smith")
    val customer2 = Customer("Juan Dela Cruz")
    val cart1 = Cart(customer1)
    val cart2 = Cart(customer2)
    val noItemName = Bread("",30.0)
    val withItemName = Bread("Buns", 20.0)
    val priceNaN = Bread("Bread Loaf", Double.NaN)
    val bread = Bread("Bread Load",30.0)
    val price1000000andUp = Bread("Bread Loaf",10_000_000.0)
    val noPrice = Bread("Bread Loaf", 0.0)
    val priceNegative = Bread("Bread Loaf",-1_000.0)

    @Test
    fun addItemToCart() {
        // success
        assertThrows<CartException.EmptyOrNotANumberException.ItemNameIsEmpty> {
            addItemToCart(cart1, noItemName, 1.0F)
            addItemToCart(cart2, noItemName, 10.0F)
        }

        // fail
        assertThrows<CartException.EmptyOrNotANumberException.ItemNameIsEmpty> {
            addItemToCart(cart1,withItemName, 1.0F)
        }

        // success
        assertThrows<CartException.EmptyOrNotANumberException.PriceIsNotANumber> {
            addItemToCart(cart1, priceNaN, 10.0F)
        }

        // fail
        assertThrows<CartException.EmptyOrNotANumberException.PriceIsNotANumber> {
            addItemToCart(cart1,bread, 10.0F)
        }

        // success
        assertThrows<CartException.EmptyOrNotANumberException.QuantityIsNotANumber> {
            addItemToCart(cart1, bread, Float.NaN)
        }
        
        // fail
        assertThrows<CartException.EmptyOrNotANumberException.QuantityIsNotANumber> {
            addItemToCart(cart1,bread,100.0F)
        }
    }

    @Test
    fun checkoutCart() {
        // success
        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cart1.items[price1000000andUp] = 10.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cart2.items[bread] = 1_001.0F
            checkoutCart(cart2)
        }

        // success
        assertThrows<CartException.QuantityPriceException.QuantityExceedsMaxLimit> {
            cart1.items[bread] = 1_001.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.QuantityExceedsMaxLimit> {
            cart2.items[price1000000andUp] = 10.0F
            checkoutCart(cart2)
        }

        // success
        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cart1.items[noPrice] = 1.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cart2.items[bread] = 1_001.0F
            checkoutCart(cart2)
        }

        // success
        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cart1.items[bread] = 0.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cart2.items[bread] = 1_001.0F
            checkoutCart(cart2)
        }

        // success
        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cart1.items[priceNegative] = 10.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cart2.items[bread] = 1_001.0F
            checkoutCart(cart2)
        }

        // success
        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cart1.items[bread] = -10.0F
            checkoutCart(cart1)
        }

        // fail
        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cart2.items[bread] = 1_001.0F
            checkoutCart(cart2)
        }
    }
}
