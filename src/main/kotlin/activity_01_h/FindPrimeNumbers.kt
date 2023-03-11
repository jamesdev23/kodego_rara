package activity_01_h

import java.lang.Integer.max
import java.lang.Integer.min

// description: 2 ints. find higher value. outputs prime numbers between low -> high
// scope: string, loops
// updated: 3/6/23

fun main() {
    print("Enter the 1st number: ")
    val num1:Int = readLine()!!.toInt()

    print("Enter the 2nd number: ")
    val num2:Int = readLine()!!.toInt()

    var primeList: ArrayList<Int> = ArrayList()
    primeList = findPrimes(num1,num2)

    primeList.forEach{
        print(it)
        print(",")
    }
}

fun findPrimes(num1: Int, num2: Int): ArrayList<Int> {
    var result = arrayListOf<Int>()
    if (num1 < 0 || num2 < 0) {
        println("No prime numbers found")
    }
    val low = min(num1, num2)
    val high = max(num1, num2)

    if (low == high && !isPrime(low)) {
        println("No prime numbers found")
    }

    for (num in low..high){
        if(!isPrime(num)){
            continue
        }else{
            result.add(num)
        }
    }

    return if (result.isEmpty()) { ArrayList() }else{ result }
}

fun isPrime(num: Int): Boolean {
    // quick if statement to return value when num is either below or equal to 1, 2 or 3
    when {
        num < 1 -> return false
        num == 1 || num == 2 || num == 3 -> return true
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