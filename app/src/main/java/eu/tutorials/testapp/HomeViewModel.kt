package eu.tutorials.testapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.tutorials.testapp.data.preference.AppPreferences
import eu.tutorials.testapp.data.usecase.ValidateLoginUseCase
import eu.tutorials.testapp.utils.Pokemon
import eu.tutorials.testapp.utils.PokemonApiService
import eu.tutorials.testapp.utils.PokemonResponse
import eu.tutorials.testapp.utils.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

abstract class HomeViewModel : ViewModel() {
    abstract val onPokemonListLoaded: MutableLiveData<List<Pokemon>>

    abstract val onApiError: SingleLiveEvent<String>

    abstract val onNetworkError: SingleLiveEvent<Unit>

    abstract val isLoading: MutableLiveData<Boolean>

    abstract val urlLoading:MutableLiveData<String>

    abstract fun fetchPokemonList(limit: Int, offset: Int)

}

class HomeViewModelImpl  @Inject constructor(
    private val pokemonApiService: PokemonApiService
) : HomeViewModel() {

    private val _onPokemonListLoaded = MutableLiveData<List<Pokemon>>()
    private val _onApiError = SingleLiveEvent<String>()
    private val _onNetworkError = SingleLiveEvent<Unit>()
    private val _isLoading = MutableLiveData<Boolean>()
    private val _urlLoading = MutableLiveData<String>()

    override val onPokemonListLoaded: MutableLiveData<List<Pokemon>>
        get() = _onPokemonListLoaded

    override val onApiError: SingleLiveEvent<String>
        get() = _onApiError

    override val onNetworkError: SingleLiveEvent<Unit>
        get() = _onNetworkError

    override val isLoading: MutableLiveData<Boolean>
        get() = _isLoading

    override val urlLoading: MutableLiveData<String>
        get() = _urlLoading

    override fun fetchPokemonList(limit: Int, offset: Int) {
        Log.d("API Call", "Fetching data with limit: $limit, offset: $offset")
        pokemonApiService.getPokemonList(limit, offset).enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                Log.d("res>", "${response.body()}")
                Log.d("res isSuccessful>", "${response.isSuccessful}")
                if (response.isSuccessful) {
                  val newPokemonList = response.body()?.results ?: emptyList()

                    Log.d("API Call", "Received data: $_onPokemonListLoaded")
//                    _onPokemonListLoaded.value = newPokemonList
                    // Append the new data to your existing list
//                    val existingList = onPokemonListLoaded.value ?: emptyList()
//                    val updatedList = existingList.toMutableList()
//                    updatedList.addAll(newPokemonList)
//                    _onPokemonListLoaded.value = updatedList
//
//                    val newPokemonList = response.body()?.results ?: emptyList()
//                    // Update _onPokemonListLoaded here
                    _onPokemonListLoaded.postValue(newPokemonList)
                } else {
                    Log.d("API Call", "Error response: ${response.code()}")
                    _onApiError.value = "API Error"
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.e("API Call", "API call failed: ${t.message}", t)
                _isLoading.value = false // Hide loading indicator
                _onNetworkError.call()
            }
        })
    }
}
