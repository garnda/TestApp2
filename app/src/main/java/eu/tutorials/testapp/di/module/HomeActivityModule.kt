package eu.tutorials.testapp.di.module

import android.app.Activity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eu.tutorials.testapp.*
import eu.tutorials.testapp.di.ActivityScope
import eu.tutorials.testapp.utils.ViewModelKey

@Module
@SuppressWarnings("UnnecessaryAbstractClass")
abstract class HomeActivityModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun mainViewModel(viewModel: HomeViewModelImpl): ViewModel

    @Binds
    @ActivityScope
    internal abstract fun activity(homeActivity: HomeActivity): Activity
}
