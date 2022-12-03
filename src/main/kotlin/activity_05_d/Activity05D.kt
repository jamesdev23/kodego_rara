package activity_05_d

import kotlin.random.Random

// game: snakes and ladders. coverage: all OOP concept

open class Board{
    val board:IntArray = IntArray(100) { i -> i + 1 }
}

class Snakes : Board(){
    val location:Map<Int,Int> = mapOf(
        17 to 7, 28 to 84, 54 to 34,62 to 19,64 to 60, 87 to 24, 93 to 73, 95 to 75, 99 to 78)
}

class Ladders : Board(){
    val location:Map<Int,Int> = mapOf(
        4 to 14, 9 to 31, 20 to 38, 28 to 84, 40 to 59, 51 to 67, 63 to 81, 71 to 91)
}

class Players(var number:Int){
    private var defaultPlayers:Int = 2
    private var defaultPlayerName = "Player "
    var twoPlayers:IntArray = intArrayOf(1, 1)
    var threePlayers:IntArray = intArrayOf(1, 1, 1)
    var fourPlayers:IntArray = intArrayOf(1, 1, 1, 1)
}

class Dice{
    val random = Random
}

abstract class PlayerMove{
    private var moveFromLeftToRight = true
    private var moveFromRightToLeft = true
    class PlayerInitialSquare{
        var square:Int = 1
    }
}

class Rules {
    val rerollIfSix = true
}

class Turn{

    // method to get if player lands on ladder. if false, lands on a normal square or snake
    fun checkIfLandedOnLadder(square:Int): Boolean{
        return (Ladders().location.equals(square))
    }

    fun checkIfLandedOnSnake(square:Int): Boolean{
        return (Snakes().location.equals(square))
    }
    fun playerTurn(player: Players, square: Int): Int {
        var square2 = square
        while (true) {
            val roll = 1 + Dice().random.nextInt(6)
            print("Player ${player.number}, on square $square2, rolls a $roll")
            if (square2 + roll > 100) {
                println(" but cannot move.")
            } else {
                square2 += roll
                println(" and moves to square $square2.")
                if (square2 == 100) return 100
                if (checkIfLandedOnLadder(square2)) {
                    val next = Ladders().location.getValue(square2)
                    println("Landed on a ladder. Climb up to $next.")
                    if (next == 100) return 100
                    square2 = next
                } else if (checkIfLandedOnSnake(square2)) {
                    val next2 = Snakes().location.getValue(square2)
                    println("Landed on a snake. Going down to $next2.")
                    square2 = next2
                }
            }
            if (roll < 6 || !Rules().rerollIfSix) return square2
            println("Rolled a 6 so roll again.")
        }
    }
}
fun main() {
    // four players starting on square 1
    var choice:Int = 1
    print("Player number (1/2/3/4): ")
    choice = readLine()!!.toInt()
    val player = choice
    val players = Players(player).fourPlayers
    while (true) {
        for ((index, square) in players.withIndex()) {
            val playerPlusIndex = Players(index + 1)
            val nextSquare = Turn().playerTurn(playerPlusIndex, square)
            if (nextSquare == 100) {
                println("Player ${index+1} wins!")
                return
            }
            players[index] = nextSquare
            println()
        }
    }
}



