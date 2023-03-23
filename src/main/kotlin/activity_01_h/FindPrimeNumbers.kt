package activity_01_h

import java.lang.Integer.max
import java.lang.Integer.min

fun main() {
    val primesList: List<Int>

    print("Enter the 1st number: ")
    val num1:Int = readLine()!!.toInt()
    print("Enter the 2nd number: ")
    val num2:Int = readLine()!!.toInt()

    primesList = findPrimes(num1,num2)
    print(primesList.joinToString(", "))
}

fun findPrimes(num1: Int, num2: Int): List<Int> {
    val low = min(num1, num2)
    val high = max(num1, num2)
    val primeNumbers = (low..high).filter { isPrime(it) }
    if (primeNumbers.isEmpty()) {
        println("No prime numbers found")
    }
    return primeNumbers
}

fun isPrime(number: Int): Boolean {
    var result = true
    if (number < 1) result = false

    for (index in 2 until number) {
        if (number % index == 0) {
            result = false
        }
        if (index * index > number) {
            break
        }
    }
    return result
}