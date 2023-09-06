package eu.tutorials.testapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.tutorials.testapp.data.preference.AppPreferences
import eu.tutorials.testapp.data.usecase.ValidateLoginUseCase
import eu.tutorials.testapp.utils.SingleLiveEvent
import javax.inject.Inject

abstract class HomeViewModel : ViewModel() {

}

class HomeViewModelImpl  @Inject constructor() : HomeViewModel() {

}
