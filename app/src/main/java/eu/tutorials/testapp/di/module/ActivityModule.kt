package eu.tutorials.testapp

import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

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