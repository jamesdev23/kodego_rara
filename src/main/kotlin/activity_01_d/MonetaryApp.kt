//  updated 10-17-22
package activity_01_d

fun main() {
    var userInputList = Array<Int>(5){ 0 }
    var divideValueBy: Int? = null
    var answer: Int? = null

    // using for loop for inputs
    for(index in 0 until 5) {
        println("Enter the monetary amount ${index + 1}: ")
        userInputList[index] = readLine()!!.toInt()
    }

    println("Divide the value by how many?: ")
    divideValueBy = readLine()!!.toInt()

    // using sum function on array to get sum of all 5 inputs
    answer = userInputList.sum() / divideValueBy

    // prints answer
    println("Answer: $answer")

}