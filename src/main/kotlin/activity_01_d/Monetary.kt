package activity_01_d

fun main() {
    var input1: Float? = null
    var input2: Float? = null
    var input3: Float? = null
    var input4: Float? = null
    var input5: Float? = null
    var dividedBy: Int? = 0
    var answer: Float? = null

    println("Enter the 1st amount: ")
    try {
        input1 = readLine()!!.toFloat()
    } catch (e: NumberFormatException) {
        println("Only numbers are allowed")
        return
    }
    println("Enter the 2nd amount: ")
    try {
        input2 = readLine()!!.toFloat()
    } catch (e: NumberFormatException) {
        println("Only numbers are allowed")
        return
    }
    println("Enter the 3rd amount: ")
    try {
        input3 = readLine()!!.toFloat()
    } catch (e: NumberFormatException) {
        println("Only numbers are allowed")
        return
    }
    println("Enter the 4th amount: ")
    try {
        input4 = readLine()!!.toFloat()
    } catch (e: NumberFormatException) {
        println("Only numbers are allowed")
        return
    }
    println("Enter the 5th amount: ")
    try {
        input5 = readLine()!!.toFloat()
    } catch (e: NumberFormatException) {
        println("Only numbers are allowed")
        return
    }
    println("Divide the value by how many?: ")
    try { dividedBy = readLine()!!.toInt()
    } catch (e: NumberFormatException) {
        println("Only accepts Integer as input")
        return
    }

    answer = (input1 + input2 + input3 + input4 + input5) / dividedBy
    var answerInFloat = answer.toFloat()

    println("Answer: $answerInFloat")

}