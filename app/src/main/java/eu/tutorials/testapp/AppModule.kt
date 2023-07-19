package eu.tutorials.testapp

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application {
        return application
    }

    // Provide other dependencies here...
}
