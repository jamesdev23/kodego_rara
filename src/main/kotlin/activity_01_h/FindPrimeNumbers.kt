package activity_01_h

import java.lang.Integer.max
import java.lang.Integer.min

// description: 2 ints. find higher value. outputs prime numbers between low -> high
// scope: string, loops
// updated: 3/6/23

fun main() {
    var primeList: ArrayList<Int> = ArrayList()

    print("Enter the 1st number: ")
    val num1:Int = readLine()!!.toInt()

    print("Enter the 2nd number: ")
    val num2:Int = readLine()!!.toInt()

    primeList = findPrimes(num1,num2)

    print(primeList.joinToString(","))
}

fun findPrimes(num1: Int, num2: Int): ArrayList<Int> {
    var result: ArrayList<Int> = ArrayList()

    if (num1 < 0 || num2 < 0) {
        println("No prime numbers found")
    }
    val low = min(num1, num2)
    val high = max(num1, num2)

    if (low == high && !isPrime(low)) {
        println("No prime numbers found")
    }

    for (num in low..high){
        if(isPrime(num)) {
            result.add(num)
        }
    }

    return result
}

fun isPrime(num: Int): Boolean {
    // quick if statement to return value when num is either below or equal to 1, 2 or 3
    when {
        num < 1 -> return false
        num == 1 || num == 2 -> return true
    }

    // finding prime, with break if number is divisible
    for (i in 2 until num) {
        if (num % i == 0) {
            break
        }
        if (i == num - 1) {
            return true
        }
    }
    return false
}