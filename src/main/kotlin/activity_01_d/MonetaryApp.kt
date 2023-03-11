package activity_01_d
fun main() {
    val amountList = mutableListOf<Double>()

    // using for loop for monetary inputs
    for(index in 1 .. 5) {
        print("Enter monetary amount #$index: ")
        val amount = readLine()!!.toDouble()
        amountList.add(amount)
    }

    print("Divide the value by how many?: ")
    val divisor:Int = readLine()!!.toInt()

    val result = calculateResult(amountList, divisor)

    println("Result: $result")
}

fun calculateResult(amountList: MutableList<Double>, divisor: Int): Double {
    val totalAmount = amountList.sum()
    return totalAmount / divisor
}