package comlamti.pawpad_puppyadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
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
fun PuppiesScreen(viewModel: PuppiesViewModel, clickAction: (Int) -> Unit) {
    PuppyList(puppies = viewModel.puppies, clickAction = clickAction)
}

@Composable
fun PuppyList(puppies: List<Puppy>, clickAction: (Int) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()

    LazyColumn(modifier = modifier, state = scrollState) {
        items(items = puppies) { puppy ->
            PuppyCard(puppy = puppy, onClick = clickAction)
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, onClick: (Int) -> Unit) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                onClick(puppy.id)
            }),
        elevation = 10.dp
    ) {
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
                        painter = painterResource(R.drawable.ic_error),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.Gray)
                    )
                },
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = puppy.type,
                modifier = Modifier
                    .padding(24.dp),
                style = MaterialTheme.typography.h4
            )
        }
    }
}