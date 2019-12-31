package dc.spacetrail

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Texture
import dc.spacetrail.gameplay.GameScreen
import dclib.graphics.Render
import dclib.graphics.RenderUtils
import dclib.graphics.TextureCache
import dclib.system.ScreenManager
import dclib.ui.UiPack

class SpaceTrailGame : ApplicationAdapter() {
    private val screenManager = ScreenManager()
    private val textureCache = TextureCache()
    private lateinit var render: Render
    private lateinit var uiPack: UiPack

    override fun create() {
        uiPack = UiPack("ui/test/uiskin.json", "ui/ocr/ocr_32.fnt", "ui/ocr/ocr_24.fnt")
        render = Render()
        screenManager.add(GameScreen(uiPack))
    }

    override fun render() {
        RenderUtils.clear()
        screenManager.render()
    }

    override fun resize(width: Int, height: Int) {
        screenManager.resize(width, height)
    }

    override fun dispose() {
        render.dispose()
        textureCache.dispose()
        uiPack.dispose()
    }

    private fun setupTextureCache() {
    }
}
