import activity_07_c.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CartTest {
    val cartFunction: CartFunction = CartFunction()

    val customer1 = Customer("Sample Customer")
    val cart1 = Cart(customer1)
    val noName = Bread("",30.0)
    val bread = Bread("Bread Load",30.0)
    val price1000000000andUp = Bread("Bread Loaf",10_000_000.0)
    val noPrice = Bread("Bread Loaf", 0.0)
    val priceNegative = Bread("Bread Loaf",-1_000.0)

    @Test
    fun addItemToCart() {

        assertThrows<CartException.EmptyException.ItemNameIsEmpty> {
            cartFunction.addItemToCart(cart1,noName,1.0F)
        }

        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cartFunction.addItemToCart(cart1,price1000000000andUp,1.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityExceedsMaxLimit> {
            cartFunction.addItemToCart(cart1,bread,1_000.0F)
        }

        assertThrows<CartException.QuantityPriceException.PriceIsZero> {
            cartFunction.addItemToCart(cart1,noPrice,1.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityIsZero> {
            cartFunction.addItemToCart(cart1,bread,0.0F)
        }

        assertThrows<CartException.QuantityPriceException.PriceBelowZero> {
            cartFunction.addItemToCart(cart1,priceNegative,1.0F)
        }

        assertThrows<CartException.QuantityPriceException.QuantityBelowZero> {
            cartFunction.addItemToCart(cart1,bread,-10.0F)
        }
    }

    @Test
    fun checkoutCart() {

        assertThrows<CartException.EmptyException.ItemNameIsEmpty> {
            cart1.items.clear()
            cart1.items[noName] = 10.0F
            cartFunction.checkoutCart(cart1)
        }

        assertThrows<CartException.QuantityPriceException.PriceExceedsMaxLimit> {
            cart1.items.clear()
            cart1.items[price1000000000andUp] = 10.0F
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
