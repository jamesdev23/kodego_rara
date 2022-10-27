package activity_02_d
fun main() {
    var userInput = Array<Float>(5) { 0.0F }
    var divideValueBy:Int = 0
    var isANumber = true
    // using Float just in casea
    var total:Float

    // using for loop for monetary inputs
    for(index in 0 .. 5) {
        if(index < 5){
            println("Enter monetary amount ${index + 1}: ")
        }else{
            println("Divide the value by how many?: ")
        }
        var tempInput:String = readLine().toString()
        for(char in tempInput){
            isANumber = !(char < '0' || char > '9')
        }

        if(!isANumber || tempInput.isEmpty()) {
            println("Error: Input is not a number")
        }else if(index < 5){
            userInput[index] = tempInput.toFloat()
        }else{
            divideValueBy = tempInput.toInt()
        }
    }

    total = userInput.sum() / divideValueBy
    val totalRoundOff = String.format("%.2f", total)
    println("Total: $totalRoundOff")

}