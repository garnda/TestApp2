package eu.tutorials.testapp.di.module
import android.content.Context
import dagger.*
import eu.tutorials.testapp.data.preference.AppPreferences
import eu.tutorials.testapp.data.preference.AppPreferencesImpl
import eu.tutorials.testapp.data.preference.AppPreferencesImpl.Companion.SHARED_PREFERENCES_NAME
import eu.tutorials.testapp.di.ApplicationScope

@Module
interface StorageModule {

    @Binds
    @ApplicationScope
    fun appPreferences(appPreferences: AppPreferencesImpl): AppPreferences

    companion object{
        @Provides
        @ApplicationScope
        fun sharedPreferences(context: Context) =
            context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}