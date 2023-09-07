package eu.tutorials.testapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import eu.tutorials.testapp.databinding.RecycleCardsBinding
import eu.tutorials.testapp.utils.Pokemon
import kotlinx.android.extensions.LayoutContainer


class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var listMenu = listOf<Menu>()
    var onItemClick: ((Pokemon) -> Unit)? = null
    var listPokemon = listOf<Pokemon>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = RecycleCardsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       holder.bindUi(listPokemon[position])
    }

    override fun getItemCount(): Int {
       return listPokemon.size
    }


inner class HomeViewHolder(val binding: RecycleCardsBinding): ViewHolder(binding.root),
    LayoutContainer{

    override val containerView: View
        get() = itemView

    internal fun bindUi(pokemon: Pokemon) {
       binding.tvMenu.text = pokemon.name

        val url = pokemon.url
        val parts = url.split("/")
        Log.d("pokemonNumber", ">> ${parts}")
        val pokemonNumber = parts.getOrNull(parts.size - 2)?.toIntOrNull()
        val imageUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonNumber.png"
        if (pokemonNumber != null) {
            Glide.with(binding.ivMenuImage.context)
                .load(imageUrl) // Replace 'menu.imageUrl' with the actual image URL
                .into(binding.ivMenuImage)
            Glide.with(binding.ivMenuImage.context)
        }else{
            binding.ivMenuImage.setImageResource(R.drawable.cake)
        }


        binding.cardMenu.setOnClickListener {
            onItemClick?.invoke(pokemon)
            Log.d("POKEMON'S", ">> ${pokemon} ")
        }



        }
    }
}