package eu.tutorials.testapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.tutorials.testapp.data.preference.AppPreferences
import eu.tutorials.testapp.data.usecase.ValidateLoginUseCase
import eu.tutorials.testapp.utils.SingleLiveEvent
import javax.inject.Inject

abstract class MainViewModel : ViewModel() {

    abstract val onLoginSuccess: SingleLiveEvent<Unit>

    abstract val onLoginFailure: SingleLiveEvent<Unit>

    abstract fun validateCredentials(username: String, password: String)
}

class MainViewModelImpl  @Inject constructor(
    private val useCase: ValidateLoginUseCase,
    private val appSharePreferences: AppPreferences
) : MainViewModel() {
    private val _onLoginSuccess = SingleLiveEvent<Unit>()
    private val _onLoginFailure = SingleLiveEvent<Unit>()

    override val onLoginSuccess: SingleLiveEvent<Unit>
        get() = _onLoginSuccess
    override val onLoginFailure: SingleLiveEvent<Unit>
        get() = _onLoginFailure

    override fun validateCredentials(username: String, password: String) {
        val isValid = useCase.execute(username, password)
        if (isValid) {
            appSharePreferences.isLoggedIn = true
            onLoginSuccess.value = Unit
        } else {
            appSharePreferences.isLoggedIn = false
            onLoginFailure.value = Unit
        }
    }

}
