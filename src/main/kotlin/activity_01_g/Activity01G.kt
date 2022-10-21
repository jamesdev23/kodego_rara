package activity_01_g

// description: check if string is palindrome or not
// scope: string, loops

fun main(){
    var word = ""
    var reverse = ""

    println("Enter a word: ")
    word = readLine().toString()

    // reversing the word
    for(index in word.length - 1 downTo  0){
        reverse += word[index]
    }

    // output
    if( word == null || word.length == 0 ){
        println("Error: input is null or empty")
    }
    else if(word.equals(reverse,ignoreCase = true) ){
        println("$word - Palindrome")
    }else{
        println("$word - Not Palindrome")
    }
}