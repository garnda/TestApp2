package eu.tutorials.testapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import eu.tutorials.testapp.databinding.ActivityHomeBinding
import eu.tutorials.testapp.ui.login.MainViewModel
import eu.tutorials.testapp.utils.ActivityViewModelFactory
import javax.inject.Inject
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.testapp.utils.Pokemon

class HomeActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ActivityViewModelFactory

    private lateinit var vm:HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    private var isLoading = false
    private var limit: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.limit = 20
        vm.fetchPokemonList(limit,0)
        initView()

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                // Check if it's time to load more data
                if (!isLoading && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {


                    loadMoreData()
                    isLoading = true
                }
            }
        })

        vm.onPokemonListLoaded.observe(this) { pokemonList ->
            isLoading = false
        }

    }

    private fun initView() {

        vm.onPokemonListLoaded.observe(this) { pokemonList ->
            Log.d("Pokelist", "$pokemonList")

            binding.recyclerView.apply {
                adapter = HomeAdapter().apply {
                    Log.d("TAG:DATA", "initView: $pokemonList")
                    if (pokemonList != null) {
                        val menuList = pokemonList.mapIndexed { index, pokemon ->
                            Pokemon(pokemon.name, pokemon.url)
                        }
                        listPokemon = menuList
                    }

                }
                layoutManager = LinearLayoutManager(context)


            }
        }


    }

    private fun loadMoreData() {
        if (!isLoading) {
            isLoading = true
            Log.d("LOAD", "Loadmore DATA")
            val nextUrl = vm.urlLoading.value
                val uri = Uri.parse(nextUrl)
                val limit = uri.getQueryParameter("limit")?.toIntOrNull() ?: 20
                val offset = uri.getQueryParameter("offset")?.toIntOrNull() ?: 0
                vm.fetchPokemonList(limit, offset)
//                Log.d("TRICK OBSERVE", "LOAD DATA >>>>>>>>>")

        }

    }


}