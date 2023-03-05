package activity_01_f

//  description: find unique characters in both string
//  Union of Unique characters in both Strings
//  scope: string, loops
// updated: 3/5/23

fun main() {
    print("Enter the first string: ")
    val string1 = readLine()!!.lowercase()
    print("Enter the second string: ")
    val string2 = readLine()!!.lowercase()
    println("Unique characters in both strings: ")
    print(findUniqueChars(string1, string2))
}

fun findUniqueChars(string1: String, string2: String): String{
    val uniqueChars = mutableListOf<Char>()

    return if (string1.length == string2.length && string1.toSet() == string2.toSet()) {
        string2
    } else {
        for (char in string1 + string2) {
            if (char !in uniqueChars) {
                uniqueChars.add(char)
            }
        }

        uniqueChars.joinToString("")
    }
}