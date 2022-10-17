//  updated 10-17-22
package activity_01_d

// import mu.KotlinLogging
// private val logger = KotlinLogging.logger{}

fun main() {
    var userInputList = Array<Int>(5){ 0 }
    var divideValueBy: Int? = null
    var answer: Int? = null
    var answerInFloat: Float? = null

    // using for loop for inputs. also, prefer try catch for error-checking
    for(index in 0 until 5) {
        run loop@ {
            try {
                println("Enter the monetary amount ${index + 1}: ")
                userInputList[index] = readLine()!!.toInt()
            } catch (e: NumberFormatException) {
                println("Error: Input is not a number or exceeds max value")
                return@loop
            }
        }
    }

    println("Divide the value by how many?: ")
    divideValueBy = readLine()!!.toInt()

    // using sum function on array to get sum of all 5 inputs
    answer = userInputList.sum() / divideValueBy
    answerInFloat = answer.toFloat()

    // prints answer
    println("Answer: $answerInFloat")

}