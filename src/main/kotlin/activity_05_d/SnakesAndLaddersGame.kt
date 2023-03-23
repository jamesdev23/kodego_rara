package activity_05_d

interface SnakesAndLadders {
    fun play()
}

class SnakesAndLaddersGame(private val players: List<Player>): SnakesAndLadders {
    private var currentTurn: Int = 0
    private val board: Board = Board()
    private val dice: Dice = Dice()

    override fun play() {
        // loop
        while (!isGameOver()) {
            val player = players[currentTurn]
            val roll = player.rollDice(dice)
            board.movePlayer(player, roll)
            if (board.isPlayerOnLadder(player)) {
                board.climbLadder(player)
                println("${player.name}, on ${player.currentPosition}, rolled $roll and landed on a ladder. Climb up to ${player.position}")
            } else if (board.isPlayerOnSnake(player)) {
                board.slideDownSnake(player)
                println("${player.name}, on ${player.currentPosition}, rolled $roll and landed on a snake. Going down to ${player.position}")
            } else {
                println("${player.name}, on ${player.currentPosition}, rolled $roll and landed on number ${player.position}")
            }

            currentTurn = (currentTurn + 1) % players.size
        }
        println("Game Over!")
    }

    private fun isGameOver(): Boolean {
        val winner = players.firstOrNull { it.position == board.size }
        if (winner != null) {
            println("${winner.name} wins!")
            return true
        }
        return false
    }
}

class Board {
    val size: Int = 100

    private val ladders: Map<Int, Int> = mapOf(
        1 to 38, 4 to 14, 9 to 31, 21 to 42, 28 to 84, 51 to 67, 71 to 91, 80 to 100
    )
    private val snakes: Map<Int, Int> = mapOf(
        17 to 7, 64 to 19, 87 to 24, 54 to 34, 64 to 60, 93 to 73, 95 to 75, 98 to 79
    )

    fun movePlayer(player: Player, steps: Int) {
        player.currentPosition = player.position
        val newPosition = player.position + steps
        player.position = if (newPosition <= size) newPosition else player.position
    }

    fun isPlayerOnLadder(player: Player): Boolean {
        return ladders.containsKey(player.position)
    }

    fun isPlayerOnSnake(player: Player): Boolean {
        return snakes.containsKey(player.position)
    }

    fun climbLadder(player: Player) {
        val newPosition = ladders[player.position]
        if (newPosition != null) {
            player.position = newPosition
        }
    }

    fun slideDownSnake(player: Player) {
        val newPosition = snakes[player.position]
        if (newPosition != null) {
            player.position = newPosition
        }
    }

}

class Player(val name: String) {
    var position: Int = 0

    var currentPosition: Int = 0

    fun rollDice(dice: Dice): Int {
        return dice.roll()
    }
}

class Dice {
    fun roll(): Int {
        return (1..6).random()
    }
}

fun main() {
    val player1 = Player("Player 1")
    val player2 = Player("Player 2")
    val players: ArrayList<Player> = arrayListOf(player1,player2)

    val snakesAndLaddersGame = SnakesAndLaddersGame(players)
    snakesAndLaddersGame.play()
}