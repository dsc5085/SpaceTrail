package dc.spacetrail.gameplay.situations

import com.badlogic.gdx.math.MathUtils
import dc.spacetrail.gameplay.Crew
import dc.spacetrail.gameplay.Option
import dc.spacetrail.gameplay.Situation

class SupplyContainerSituation(private val crew: Crew) : Situation() {
    override val description = "We spotted a supply container floating around. Should we pick it up?"
    override val options = listOf(
            Option("Yes, it could contain valuable resources!", ::yesSolver),
            Option("No...it could be a trap.")
    )

    private fun yesSolver(): String {
        val SUCCESS_RATE = 0.75f
        val value = MathUtils.random()
        when {
            value >= SUCCESS_RATE -> {
                crew.food += MathUtils.random(1, 5)
                return "Found ${crew.food} food!"
            }
            else -> {
                crew.shipHealth -= MathUtils.random(5, 20)
                return "The container exploded and damaged the ship. It was a booby trap!"
            }
        }
    }
}