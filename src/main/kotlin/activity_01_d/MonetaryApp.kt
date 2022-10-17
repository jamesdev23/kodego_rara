//  updated 10-17-22
package activity_01_d

fun main() {
    var userInputList = Array<Int>(5){ 0 }
    var divideValueBy: Int? = null
    var answer: Int? = null
    var answerInFloat: Float? = null

    // using for loop for inputs. also, no error checking method is specified so I use this
    for(index in 0 until 5) {
        run loop@ {
            try {
                println("Enter the monetary amount ${index + 1}: ")
                userInputList[index] = readLine()!!.toInt()
            } catch (e: NumberFormatException) {
                println("Input is not a number.")
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