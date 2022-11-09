package activity_01_f
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

//  description: find unique characters in both string
//  Union of Unique characters in both Strings
//  scope: string, loops

fun main(){
    var string1:String = ""
    var string2:String = ""
    var uniqueChars1 = mutableSetOf<Char>()
    var uniqueChars2 = mutableSetOf<Char>()
    var shortString = ""
    var longString = ""

    // input
    println("String 1: ")
    string1 = readLine().toString()
    println("String 2: ")
    string2 = readLine().toString()

    if(string1.length < string2.length){
        shortString = string1
        longString = string2
    }else{
        shortString = string2
        longString = string1
    }

    // compare long and short string
    for(index1 in longString.indices){
        var common = false
        for(index2 in shortString.indices){
            if(longString[index1] == shortString[index2]){
                common = true
            }
        }
        if(!common){
            uniqueChars1.add(longString[index1])
        }
    }

    // compare short and uniqueChars
    for(index1 in shortString.indices){
        var common = false
        for(index2 in uniqueChars1.indices){
            if(shortString[index1] == uniqueChars1.elementAt(index2)){
                common = true
            }
        }
        if(!common){
            uniqueChars2.add(shortString[index1])
        }
    }

    uniqueChars1.addAll(uniqueChars2)

    print("Unique: ")
    uniqueChars1.forEach(){
        print(it)
    }


}

