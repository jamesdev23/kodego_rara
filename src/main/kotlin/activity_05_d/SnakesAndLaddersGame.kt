package activity_05_d

// game name: snakes and ladders
// game rules: US rules
// rules url:
// https://gamerules.com/rules/snakes-and-ladders/#:~:text=GAME%20RULES&text=The%20players%20can%20never%20move,land%20on%20the%20number%20100.
// board used:
// https://gamerules.com/wp-content/uploads/Photo-1.1-1-750x750.jpg

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
                println("${player.name} rolled $roll and landed on a ladder. Climb up to ${player.position}")
            } else if (board.isPlayerOnSnake(player)) {
                board.slideDownSnake(player)
                println("${player.name} rolled $roll and landed on a snake. Going down to ${player.position}")
            } else {
                println("${player.name} rolled $roll and landed on number ${player.position}")
            }

            currentTurn = (currentTurn + 1) % players.size
        }
        println("Game Over!")
    }

    private fun isGameOver(): Boolean {
        return players.any { it.position == board.size }
    }
}

class Board {
    val size: Int = 100
    private val cells: Array<Cell> = Array(size) { Cell() }
    private val ladders: Map<Int, Int> = mapOf(
        1 to 38, 4 to 14, 9 to 31, 21 to 42, 28 to 84, 51 to 67, 71 to 91, 80 to 100
    )
    private val snakes: Map<Int, Int> = mapOf(
        17 to 7, 64 to 19, 87 to 24, 54 to 34, 64 to 60, 93 to 73, 95 to 75, 98 to 79
    )

    fun movePlayer(player: Player, steps: Int) {
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

    inner class Cell
}

class Player(val name: String) {
    var position: Int = 0

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
    val players: ArrayList<Player> = arrayListOf(Player("Player 1"), Player("Player 2"))
    val snakesAndLaddersGame = SnakesAndLaddersGame(players)
    snakesAndLaddersGame.play()
}