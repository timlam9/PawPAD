package comlamti.pawpad_puppyadoption.ui.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import comlamti.pawpad_puppyadoption.ui.navigation.Destinations.PUPPY_DETAILS

object Destinations {

    const val HOME = "home"
    const val PUPPY_DETAILS = "puppyDetails"

    object PuppyDetailArgs {

        const val PUPPY_ID = "puppyId"

    }

}

class Actions(navController: NavHostController) {

    val navigateToDetails: (Int) -> Unit = { puppyId ->
        navController.navigate("$PUPPY_DETAILS/$puppyId")
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }

}