package eu.tutorials.testapp.data.preference
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }

    var isLoggedIn: Boolean
        get() = preferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = preferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
}
