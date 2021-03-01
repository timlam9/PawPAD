package comlamti.pawpad_puppyadoption.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import comlamti.pawpad_puppyadoption.data.PuppiesRepo
import comlamti.pawpad_puppyadoption.ui.model.Puppy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PuppiesViewModel @Inject constructor (private val repo: PuppiesRepo) : ViewModel() {

    var puppies: List<Puppy> by mutableStateOf(repo.getPuppies())
        private set

    fun getPuppy(puppyId: Int): Puppy {
        return puppies.first { it.id == puppyId }
    }

}
