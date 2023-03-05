package activity_01_h

// description: 2 ints. find higher value. outputs prime numbers between low -> high
// scope: string, loops
fun main(){
    var int1:Int? = null
    var int2:Int? = null
    var lowerNumber = 0
    var higherNumber = 0

    println("Enter first number: ")
    int1 = readLine()!!.toInt()
    println("Enter second number: ")
    int2 = readLine()!!.toInt()

    // determines lower and higher number
    if(int1 > int2) {
        lowerNumber = int2
        higherNumber = int1
    }else{
        lowerNumber = int1
        higherNumber = int2
    }

    // prints prime numbers
    if(lowerNumber <= 0 || higherNumber <= 0){
        println("Both inputs should be above 0")
    }else{
        print("Prime numbers: ")
        // actual loop for prime numbers
        while (lowerNumber <= higherNumber) {
            var isPrime = true
            for (index in 2..lowerNumber / 2) {
                if (lowerNumber % index == 0) {
                    isPrime = false
                    ++lowerNumber
                }
            }
            if(isPrime) {
                print("$lowerNumber \n")
                ++lowerNumber
            }
        }
    }
}