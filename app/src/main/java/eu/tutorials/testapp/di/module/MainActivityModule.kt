package eu.tutorials.testapp

import android.app.Activity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@SuppressWarnings("UnnecessaryAbstractClass")
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModelImpl): ViewModel

    @Binds
    @ActivityScope
    internal abstract fun activity(appOrOsUpdateActivity: MainActivity): Activity
}
