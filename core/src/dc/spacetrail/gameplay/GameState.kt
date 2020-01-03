package dc.spacetrail.gameplay

class GameState(var situation: Situation, val locations: List<Location>) {
    val crew = Crew()
}