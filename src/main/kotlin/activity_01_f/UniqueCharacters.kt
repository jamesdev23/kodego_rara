package activity_01_f

fun main() {
    print("string 1: ")
    val string1 = readLine()!!.toString()
    print("String 2: ")
    val string2 = readLine()!!.toString()
    print("Unique: ")
    print(findUniqueChars(string1, string2))
}

fun findUniqueChars(string1: String, string2: String): List<Char>{
    val uniqueChars = mutableListOf<Char>()
    val newString1 = string1.lowercase()
    val newString2 = string2.lowercase()

    for (character in newString1 + newString2) {
        if (character !in uniqueChars) {
            uniqueChars.add(character)
        }
    }

    uniqueChars.sort()
    return uniqueChars
}