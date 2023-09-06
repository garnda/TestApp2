package eu.tutorials.testapp.di.module

import dagger.Module
import dagger.Provides
import eu.tutorials.testapp.utils.PokemonApiService
import eu.tutorials.testapp.utils.RetrofitInstance

@Module
class NetworkModule {
    @Provides
    fun providePokemonApiService(): PokemonApiService {
        return RetrofitInstance.api
    }
}
