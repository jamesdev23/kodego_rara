open class Product {
    var name:String = ""
        private set
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
class Shakes(name:String, price: Double):Product(name,price){
    var size: Any = ""
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
}
class Juices(name:String,price:Double):Product(name,price){
    var ingredients: ArrayList<String> = ArrayList()
    var size: Any = ""
}
class Sandwiches(name:String,price:Double):Product(name,price){
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
    var breadType:Any = ""
}
class Salads(name:String,price:Double):Product(name,price){
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

class Cart(var customer:Customer){
    var uniqueID:String = ""
    var items:HashMap<Product,Float> = HashMap()
    var status:OrderStatus = OrderStatus.UNKNOWN
    fun updateOrder(status:OrderStatus){
        this.status = status
    }
    fun addItems(product:Product,quantity:Float){
        //items.put(product, quantity)
        items[product] = quantity
    }
}

data class Customer(var address:String,var mobilenumber:String,
                    var firstname:String,var lastname:String)


fun main(){



}


