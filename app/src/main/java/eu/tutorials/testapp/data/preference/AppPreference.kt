package eu.tutorials.testapp

import android.content.Context
import android.content.SharedPreferences
import dagger.Provides
import javax.inject.Singleton
import android.preference.PreferenceManager
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    @Provides
    @Singleton
    fun sharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    companion object {
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }

    var isLoggedIn: Boolean
        get() = preferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = preferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
}
