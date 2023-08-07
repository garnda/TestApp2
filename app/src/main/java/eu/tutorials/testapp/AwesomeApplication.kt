package eu.tutorials.testapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import eu.tutorials.testapp.di.AppComponent
import eu.tutorials.testapp.di.DaggerAppComponent

class AwesomeApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
        return appComponent
    }
}