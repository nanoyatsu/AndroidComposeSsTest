package com.example.nano.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import com.airbnb.android.showkase.models.Showkase
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * - `./gradlew tipstar-ui:recordRoborazziDebug`
 *   期待値となるスクリーンショットを保存
 * - `./gradlew tipstar-ui:compareRoborazziDebug`
 *   スクリーンショットを撮影して比較（差分があってもエラーなし、走り切る）
 * - `./gradlew tipstar-ui:verifyRoborazziDebug`
 *   スクリーンショットを撮影して比較してエラー検出（差分があったらその時に終了）
 */
@Config(sdk = [28])
@OptIn(ExperimentalTestApi::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class RoborazziTest {
    @Test
    fun test() = runComposeUiTest {
        Showkase.getMetadata().componentList.forEach { showkaseBrowserComponent ->
            val filePath = DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH + "/" +
                    showkaseBrowserComponent.componentKey + ".png"
            captureRoboImage(filePath) {
                showkaseBrowserComponent.component()
            }
        }
    }
}
