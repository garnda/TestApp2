package eu.tutorials.testapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class MainViewModel : ViewModel() {

    abstract val onLoginSuccess: MutableLiveData<Unit>

    abstract val onLoginFailure: MutableLiveData<Unit>

    abstract fun validateCredentials(username: String, password: String)
}

class MainViewModelImpl  @Inject constructor() : MainViewModel() {
    private val _onLoginSuccess = MutableLiveData(Unit)
    private val _onLoginFailure = MutableLiveData(Unit)

    override val onLoginSuccess: MutableLiveData<Unit>
        get() = _onLoginSuccess
    override val onLoginFailure: MutableLiveData<Unit>
        get() = _onLoginFailure

    override fun validateCredentials(username: String, password: String) {
        if (username == "gg" && password == "1234") {
            onLoginSuccess.value = Unit
        } else {
            onLoginFailure.value = Unit
        }
    }

}
