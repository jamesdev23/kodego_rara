package activity_05_d

import kotlin.random.Random

// coverage: all oop concepts
// game: snakes and ladders

class Board {
    val board: Array<IntRange> = arrayOf(1..100)
}

class Snakes {
    val location:Map<Int,Int> = mapOf()
    // each game versions has different snakes location, so I'll leave it blank for now
}

class Ladders {
    val location:Map<Int,Int> = mapOf()
    // each game versions has different ladders location, so I'll leave it blank for now
}

open class Players (var name:String){
    var defaultName:Array<String> = arrayOf("Player 1","Player 2","Player 3","Player 4")
    var count:Int = 2
    var maxPlayers = 4
}

class Dice{
    var playerName = ""
    val random = Random.nextInt(1,6)
}

class PlayerTurn{
    var currentSquare = 1
    var nextSquare = 2
    fun checkSquare(position:Int){
        if(Snakes().location.containsKey(position)){
            println("You've landed on a Snake. Going down...")
        }
        if(Ladders().location.containsKey(position)){
            println("You've landed on a Ladder. Going up..")
        }

    }
}

class Rules{
    var sixRollsAgain = true
}

class Result{
    fun turnResult(player:Players){
        println("$player, on square${PlayerTurn().currentSquare}, rolls a ${Dice().random} and moves to square${PlayerTurn().nextSquare}.")
    }
}
fun main() {
    var player1 = Players("")
    var diceResult = Dice().random

    println(diceResult)
}



