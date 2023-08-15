package eu.tutorials.testapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.tutorials.testapp.data.preference.AppPreferences
import eu.tutorials.testapp.data.usecase.ValidateLoginUseCase
import javax.inject.Inject

abstract class MainViewModel : ViewModel() {

    abstract val onLoginSuccess: MutableLiveData<Unit?>

    abstract val onLoginFailure: MutableLiveData<Unit>

    abstract fun validateCredentials(username: String, password: String)
}

class MainViewModelImpl  @Inject constructor(
    private val useCase: ValidateLoginUseCase,
    private val appSharePreferences: AppPreferences
) : MainViewModel() {
    private val _onLoginSuccess = MutableLiveData(Unit)
    private val _onLoginFailure = MutableLiveData(Unit)

    override val onLoginSuccess: MutableLiveData<Unit?>
        get() = _onLoginSuccess
    override val onLoginFailure: MutableLiveData<Unit>
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
