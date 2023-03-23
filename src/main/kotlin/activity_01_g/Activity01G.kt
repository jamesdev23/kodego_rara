package activity_01_g

fun main(){
    var reverse = ""
    println("Enter a word: ")
    val word = readLine().orEmpty().trim()

    val isPalindrome = word.equals(word.reversed(), ignoreCase = true)

    when {
        word.isEmpty() -> println("No input found.")
        isPalindrome -> println("$word - Palindrome")
        else -> println("$word - Not Palindrome")
    }
}