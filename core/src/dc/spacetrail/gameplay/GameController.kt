package dc.spacetrail.gameplay

import dc.spacetrail.gameplay.situations.SupplyContainerSituation

class GameController(private val state: GameState) {
    fun advance() {
        state.position += 1
        state.situation = SupplyContainerSituation(state)
    }
}