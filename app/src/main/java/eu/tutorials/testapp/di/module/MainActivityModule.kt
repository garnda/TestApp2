package eu.tutorials.testapp.di.module

import android.app.Activity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eu.tutorials.testapp.di.ActivityScope
import eu.tutorials.testapp.ui.login.MainActivity
import eu.tutorials.testapp.ui.login.MainViewModel
import eu.tutorials.testapp.ui.login.MainViewModelImpl
import eu.tutorials.testapp.utils.ViewModelKey

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
