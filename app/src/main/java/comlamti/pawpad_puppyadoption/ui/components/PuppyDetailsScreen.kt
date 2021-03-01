package comlamti.pawpad_puppyadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import comlamti.pawpad_puppyadoption.R
import comlamti.pawpad_puppyadoption.ui.model.Puppy
import comlamti.pawpad_puppyadoption.ui.navigation.PuppiesViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyDetailsScreen(puppyId: Int, viewModel: PuppiesViewModel) {
    val puppy = viewModel.getPuppy(puppyId)

    PuppyDetailsLayout(puppy)
}

@Composable
fun PuppyDetailsLayout(puppy: Puppy) {
    Column {
        CoilImage(
            data = puppy.image,
            contentDescription = null,
            loading = {
                Image(
                    painter = painterResource(R.drawable.ic_downloading),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
            },
            error = {
                Image(
                    painter = painterResource(R.drawable.ic_paw),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
            },
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = puppy.type,
            modifier = Modifier
                .padding(24.dp),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )

        Text(
            text = puppy.description,
            modifier = Modifier
                .padding(24.dp),
            style = MaterialTheme.typography.body1
        )
    }
}