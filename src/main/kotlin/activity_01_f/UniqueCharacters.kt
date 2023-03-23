package activity_01_f

fun main() {
    print("string 1: ")
    val string1 = readLine()!!.toString().lowercase()
    print("String 2: ")
    val string2 = readLine()!!.toString().lowercase()
    print("Unique: ")
    print(findUniqueChars(string1, string2))
}

fun findUniqueChars(string1: String, string2: String): List<Char>{
    val uniqueChars = mutableListOf<Char>()

    for (char in string1 + string2) {
        if (char !in uniqueChars) {
            uniqueChars.add(char)
        }
    }

    uniqueChars.sort()
    return uniqueChars
}