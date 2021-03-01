package comlamti.pawpad_puppyadoption.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import comlamti.pawpad_puppyadoption.ui.navigation.Actions
import comlamti.pawpad_puppyadoption.ui.navigation.Destinations
import comlamti.pawpad_puppyadoption.ui.navigation.PuppiesViewModel
import comlamti.pawpad_puppyadoption.ui.theme.PawPADPuppyAdoptionTheme

@Composable
fun PADApp(content: @Composable () -> Unit) {
    PawPADPuppyAdoptionTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Navigation(puppiesViewModel: PuppiesViewModel) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController = navController, startDestination = Destinations.HOME) {

        composable(Destinations.HOME) {
            PuppiesScreen(puppiesViewModel, actions.navigateToDetails)
        }

        composable(
            "${Destinations.PUPPY_DETAILS}/{${Destinations.PuppyDetailArgs.PUPPY_ID}}",
            arguments = listOf(navArgument(Destinations.PuppyDetailArgs.PUPPY_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            PuppyDetailsScreen(
                puppyId = backStackEntry.arguments?.getInt(Destinations.PuppyDetailArgs.PUPPY_ID) ?: 0,
                puppiesViewModel
            )
        }

    }
}