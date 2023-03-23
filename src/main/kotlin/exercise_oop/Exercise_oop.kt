package exercise_oop

open class Product {
    var name:String = ""
    var price:Double = 0.0

    constructor(name:String,price:Double) {
        this.name = name
        this.price = price
    }
}
class Fruit(name:String, price:Double) : Product(name, price) {
    var quantity:Float = 0.0F
    var quantityUnits:String = "per Piece"
}
class Shakes(name:String, price: Double): Product(name,price){
    var size: Any = ""
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
}
class Juices(name:String,price:Double): Product(name,price){
    var ingredients: ArrayList<String> = ArrayList()
    var size: Any = ""
}
class Sandwiches(name:String,price:Double): Product(name,price){
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
    var breadType:Any = ""
}
class Salads(name:String,price:Double): Product(name,price){
    var ingredients: ArrayList<String> = ArrayList()
    var dressing:Any = ""
    var addons: ArrayList<Any> = ArrayList()
    var size:Any = ""
}

enum class OrderStatus{
    SENT_TO_THE_KITCHEN,
    BEING_PREPARED,
    FOR_PICKUP,
    FOR_DELIVERY,
    DELIVERED,
    CANCELLED,
    PAID,
    UNKNOWN
}

open class Cart(var customer: Customer){
    var uniqueID:String = ""
    var items:HashMap<Product,Float> = HashMap()
    var status: OrderStatus = OrderStatus.UNKNOWN
    fun updateOrder(status: OrderStatus){
        this.status = status
    }
    fun addItems(product: Product, quantity:Float){
        //items.put(product, quantity)
        items[product] = quantity
    }
    fun addFruit(product: Fruit, quantity: Float){
        items[product] = quantity
    }
    fun addShakes(product: Shakes, quantity: Float){
        items[product] = quantity
    }

    fun addJuices(product: Juices, quantity: Float){
        items[product] = quantity
    }

    fun addSandwiches(product: Sandwiches, quantity: Float){
        items[product] = quantity
    }
}

class SaladsOrder(customer: Customer) : Cart(customer){
    fun addItems(product: Salads, quantity: Float){
        items[product] = quantity
    }
}

data class Customer(var address:String,var mobilenumber:String,
                    var firstname:String,var lastname:String)


fun main(){
    var customer = Customer("","","","")
    var customerCart = Cart(customer)
    var fruits = arrayListOf("apple","banana","lemon","mango","strawberry")
    var shakes = arrayListOf("vanilla shake","strawberry shake","mixed berry","chocolate blend ","chocolate-banana")
    var juices = arrayListOf("apple juice","strawberry juice","orange juice","pineapple juice","carrot juice")
    var sandwiches = arrayListOf("egg sandwich","chicken sandwich","ham sandwich","grilled cheese sandwich","grilled chicken sandwich")
    var salads = arrayListOf("caesar salad","leafy green salad","greek salad","wedge salad","cobb salad")
    var order1 = Fruit("apple",20.0)
    var quantity = 2.0F

    customerCart.addFruit(order1, quantity)

    customerCart.items.forEach(){
        println(it)
    }

    println("${order1.name} Qty: ${quantity}")

}


