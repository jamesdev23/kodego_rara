package activity_01_f

//  description: find unique characters in both string
//  Union of Unique characters in both Strings
//  scope: string, loops
// updated: 3/20/23

fun main() {
    print("string 1: ")
    val string1:String = readLine()!!.toString()
    print("String 2: ")
    val string2:String = readLine()!!.toString()
    print("Unique: ")
    print(findUniqueChars(string1, string2))
}

fun findUniqueChars(string1: String, string2: String): String{
    val uniqueChars = mutableListOf<Char>()

    if (string1.length == string2.length && string1.toSet() == string2.toSet()) {
        return string2
    }

    for (char in string1 + string2) {
        if (char !in uniqueChars) {
            uniqueChars.add(char)
        }
    }

    return uniqueChars.joinToString("")
}