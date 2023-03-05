package activity_01_d
fun main() {
    val amountList = mutableListOf<Double>()

    // using for loop for monetary inputs
    for(index in 0 .. 4) {
        print("Enter a monetary amount: ")
        val amount = readLine()!!.toDouble()
        amountList.add(amount)
    }

    print("Divide the value by how many?: ")
    val divisor:Int = readLine()!!.toInt()

    calculateResult(amountList, divisor)
}

fun calculateResult(amountList: MutableList<Double>, divisor: Int): Double {
    val totalAmount = amountList.sum()
    return totalAmount / divisor
}