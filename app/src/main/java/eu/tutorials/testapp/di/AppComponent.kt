package eu.tutorials.testapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import eu.tutorials.testapp.AwesomeApplication
import eu.tutorials.testapp.di.module.ActivityModule
import eu.tutorials.testapp.di.module.StorageModule

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        StorageModule::class
    ]
)
interface AppComponent : AndroidInjector<AwesomeApplication> {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            storageModule: StorageModule
        ): AppComponent
    }
}
