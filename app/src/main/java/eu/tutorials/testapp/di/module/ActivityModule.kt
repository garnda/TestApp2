package eu.tutorials.testapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import eu.tutorials.testapp.di.ActivityScope
import eu.tutorials.testapp.ui.login.MainActivity

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    fun mainActivity(): MainActivity

}