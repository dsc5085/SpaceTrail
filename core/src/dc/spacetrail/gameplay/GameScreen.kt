package dc.spacetrail.gameplay

import com.badlogic.gdx.scenes.scene2d.ui.Table
import dc.spacetrail.gameplay.situations.IntroSituation
import dc.spacetrail.gameplay.situations.SupplyContainerSituation
import dc.spacetrail.ui.UiUtils
import dclib.system.Advancer
import dclib.system.Screen
import dclib.system.Updater
import dclib.ui.FontSize
import dclib.ui.UiPack

class GameScreen(private val uiPack: UiPack) : Screen() {
    private val advancer = createAdvancer()
    private val state = createGameState()

    init {
        stage.addActor(createMainTable())
    }

    override fun update(delta: Float) {
        advancer.update(delta)
    }

    private fun createAdvancer(): Advancer {
        return Advancer(object : Updater {
            override fun update(delta: Float) {
            }
        })
    }

    private fun createGameState(): GameState {
        val state = GameState(IntroSituation(), listOf())
        state.situation = SupplyContainerSituation(state.crew)
        return state
    }

    private fun createMainTable(): Table {
        val mainTable = uiPack.table()
        mainTable.setFillParent(true)
        val mainLabel = uiPack.label(state.situation.description, FontSize.SMALL)
        mainTable.add(mainLabel).center().row()
        for (option in state.situation.options) {
            val optionLabel = uiPack.label(option.description, FontSize.SMALL)
            UiUtils.makeClickable(optionLabel, {
                val description = option.solve()
            })
            mainTable.add(optionLabel).center().row()
        }
        return mainTable
    }
}