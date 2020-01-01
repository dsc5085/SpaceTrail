package dc.spacetrail.gameplay

import com.badlogic.gdx.scenes.scene2d.ui.Table
import dc.spacetrail.gameplay.situations.IntroSituation
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
        val situation = IntroSituation()
        return GameState(situation, listOf())
    }

    private fun createMainTable(): Table {
        val mainTable = uiPack.table()
        mainTable.setFillParent(true)
        val mainLabel = uiPack.label(state.situation.description, FontSize.SMALL)
        mainTable.add(mainLabel).center().row()
        return mainTable
    }
}