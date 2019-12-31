package dc.spacetrail.gameplay

import com.badlogic.gdx.scenes.scene2d.ui.Table
import dclib.system.Advancer
import dclib.system.Screen
import dclib.system.Updater
import dclib.ui.FontSize
import dclib.ui.UiPack

class GameScreen(private val uiPack: UiPack) : Screen() {
    private val advancer: Advancer

    init {
        advancer = createAdvancer()
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

    fun createMainTable(): Table {
        val mainTable = uiPack.table()
        val mainLabel = uiPack.label("You are about to go on an adventure!", FontSize.SMALL)
        mainTable.setFillParent(true)
        mainTable.add(mainLabel).center().row()
        return mainTable
    }
}