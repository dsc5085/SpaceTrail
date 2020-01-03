package dc.spacetrail.gameplay

import dc.spacetrail.gameplay.situations.SupplyContainerSituation

class GameController(private val state: GameState) {
    fun advance() {
        state.crew.position += 1
        state.situation = SupplyContainerSituation(state.crew)
    }
}