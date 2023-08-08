package eu.tutorials.testapp.di.module

import android.app.Application
import android.content.Context
import dagger.*
import eu.tutorials.testapp.di.ApplicationScope

@Module
@SuppressWarnings("UnnecessaryAbstractClass")
abstract class AppModule {

    @Binds
    @ApplicationScope
    internal abstract fun applicationContext(application: Application): Context
}