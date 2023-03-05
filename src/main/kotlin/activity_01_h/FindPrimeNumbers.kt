package activity_01_h

// description: 2 ints. find higher value. outputs prime numbers between low -> high
// scope: string, loops
// updated: 3/5/23
fun main() {
    print("Enter the 1st number: ")
    val num1:Int = readLine()!!.toInt()

    print("Enter the 2nd number: ")
    val num2:Int = readLine()!!.toInt()

    val low = if (num1 < num2) num1 else num2
    val high = if (num1 > num2) num1 else num2

    if(num1 == num2){
        if(!isPrime(num1)){
            print("No prime numbers found")
        } else {
            print("Prime number: $num1")
        }
    } else {
        for (num in low..high) {
            if (isPrime(num)) {
                print("$num, ")
            }
        }
    }
}

fun isPrime(num: Int): Boolean {
    // quick if statement to return value when num is either below or equal to 1, 2 or 3
    if (num < 1) {
        return false
    } else if (num == 1 || num == 2 || num == 3) {
        return true
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