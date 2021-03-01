package comlamti.pawpad_puppyadoption.di

import comlamti.pawpad_puppyadoption.data.PuppiesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providePuppiesRepo() = PuppiesRepo

}