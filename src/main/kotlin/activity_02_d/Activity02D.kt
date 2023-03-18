package activity_02_d

// update: 3/6/23
// same as activity 01-d, but w/out unit test

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