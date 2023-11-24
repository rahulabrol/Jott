package com.rahul.jott

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rahul.jott.app.navigation.AppNavigation
import com.rahul.jott.dsm.theme.AppTheme
import com.rahul.jott.dsm.theme.JottTheme
import com.rahul.jott.navigation.rememberAppAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Main activity of this app
 *
 * @constructor Create empty Main activity
 */
@InternalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class JottActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            JottTheme {
                Surface(color = AppTheme.colors.background) {
                    AppNavigation(
                        navController = rememberAppAnimatedNavController(),
                        launchDeeplinkUri = { },
                        deeplinkUrl = null
                    )
                }
            }
        }
    }
}