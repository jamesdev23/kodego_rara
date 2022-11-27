package activity_05_d

import kotlin.random.Random

// coverage: all oop concepts
// game: snakes and ladders

class Board {
    val board: IntArray = IntArray(100) { i -> i + 1 }
}

class Snakes {
    val location:Map<Int,Int> = mapOf()
    // each game versions has different snakes location, so I'll leave it blank for now
}

class Ladders {
    val location:Map<Int,Int> = mapOf()
    // each game versions has different ladders location, so I'll leave it blank for now
}

open class Player (var name:String){
    var defaultName:Array<String> = arrayOf("Player 1","Player 2","Player 3","Player 4")
    var count:Int = 2
    var maxPlayers = 4
}

class Dice{
    var playerName = ""
    val random = Random.nextInt(1,6)
}

class PlayerTurn{
    var currentSquare = 0
    var nextSquare:Int = 0
    fun checkSquare(position:Int){
        if(Snakes().location.containsKey(position)){
            println("You've landed on a Snake. Going down...")
        }
        if(Ladders().location.containsKey(position)){
            println("You've landed on a Ladder. Going up...")
        }

    }
    fun calculateNextSquare(position: Int,diceRoll: Int): Int{
        nextSquare = currentSquare + diceRoll
        return nextSquare
    }
}

class Rules{
    var sixRollsAgain = true
}

class Result{
    fun turnResult(player:Player){
        println("$player, on square${PlayerTurn().currentSquare}, rolls a ${Dice().random} and moves to square${PlayerTurn().nextSquare}.")
        if(PlayerTurn().nextSquare == 100){
            println("You win!")
        }
    }
}
fun main() {
    var player1 = Player("Player1")
    var diceResult = Dice().random

    println(diceResult)
}



