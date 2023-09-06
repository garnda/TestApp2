package eu.tutorials.testapp

import android.content.Intent
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
import eu.tutorials.testapp.utils.Pokemon

class HomeActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ActivityViewModelFactory

    private lateinit var vm:HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm.fetchPokemonList(20,0)
        initView()
        vm.onPokemonListLoaded.observe(this) { pokemonList ->
            // Handle the updated Pokemon list here...
            Log.d("Pokelist", "$pokemonList")
            binding.recyclerView.apply {
                adapter = HomeAdapter().apply {
                    Log.d("TAG", "initView: $pokemonList")
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

    private fun initView() {
        val menuList = listOf(
            Menu(1, "One", R.drawable.cake,"cake"),
            Menu(2, "Two" , R.drawable.cupcake,"cupcake"),
            Menu(3,"Three",R.drawable.pudding,"pudding"),
            Menu(4,"Four",R.drawable.cake,"cake"),
            Menu(5,"Five",R.drawable.cake,"cake")
        )
        val menuItem = listOf(
            "A","B","C","D"
        )

//        binding.recyclerView.apply {
//            adapter = HomeAdapter().apply {
//                listMenu = menuList
//                onItemClick = { clickedMenu ->
//                    val bundle = bundleOf("MENU" to clickedMenu)
//                    val intent = Intent(this@HomeActivity, DetailMenuActivity::class.java).apply {
//                        putExtra("MENU", clickedMenu)
//                    }
//                    startActivity(intent)
//
//                }
//
//            }
//            layoutManager = LinearLayoutManager(context)
//        }
                var data = vm.onPokemonListLoaded.value
                binding.recyclerView.apply {
                    adapter = HomeAdapter().apply {
                        Log.d("TAG", "initView: $data")
                        if (data != null) {
                            listPokemon = data
                        }
//                        onItemClick = { clickedMenu ->
//                            val bundle = bundleOf("MENU" to clickedMenu)
//                            val intent = Intent(this@HomeActivity, DetailMenuActivity::class.java).apply {
//                                putExtra("MENU", clickedMenu)
//                            }
//                            startActivity(intent)
//
//                        }

                    }
                    layoutManager = LinearLayoutManager(context)


            }
    }

}