package eu.tutorials.testapp

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

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