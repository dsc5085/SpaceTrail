package dc.spacetrail.gameplay

class GameState(var situation: Situation, val locations: List<Location>) {
    val WIN_POSITION = 1000f

    var position = 0f
    var money = 0
    var food = 10f
    var shipHealth = 100f
    val party = listOf<Person>()
}