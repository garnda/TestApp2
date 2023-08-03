package eu.tutorials.testapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import eu.tutorials.testapp.di.AppComponent

class AwesomeApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .factory()
            .create(this)
    }
}