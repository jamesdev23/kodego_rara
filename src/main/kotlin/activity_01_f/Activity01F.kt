package activity_01_f

//  description: find unique characters
//  scope: string, loops

fun main(){
    var string1:String = ""
    var string2:String = ""
    var uniqueList = ""
    var usedChar = ""

    // input
    println("Enter first string: ")
    string1 = readLine().toString()
    println("Enter second string: ")
    string2 = readLine().toString()

    // comparing string1 to string2
    for (counter1 in 0 until string1.length) {
        var isCommon = false

        for (counter2 in 0 until string2.length) {
            if( string1[counter1] == string2[counter2] ){
                isCommon = true
                break
            }
        }
        if(!isCommon && !(usedChar.contains(string1[counter1])) ){
            uniqueList += string1[counter1]
            usedChar += string1[counter1]
        }
    }

    // comparing string2 to string1
    for (counter2 in 0 until string2.length) {
        var isCommon = false
        for (counter1 in 0 until string1.length) {
            if (string2[counter2] == string1[counter1] ){
                isCommon = true
                break
            }
        }
        if(!isCommon && !(usedChar.contains(string2[counter2])) ){
            uniqueList += string2[counter2]
            usedChar += string2[counter2]
        }
    }

    // output for unique characters
    if(uniqueList.length == null || uniqueList.length == 0){
        println("No unique characters")
    }else{
        print("Unique characters: ")
        for(index in 0 until uniqueList.length){
            print("${uniqueList[index]}")
            if(index < uniqueList.length - 1){
                print(",")
            }
        }
    }
}

