package comlamti.pawpad_puppyadoption.ui.navigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import comlamti.pawpad_puppyadoption.ui.components.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val puppiesViewModel: PuppiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PADApp {
                Navigation(puppiesViewModel)
            }
        }
    }

}