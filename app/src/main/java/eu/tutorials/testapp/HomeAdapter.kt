package eu.tutorials.testapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import eu.tutorials.testapp.databinding.RecycleCardsBinding
import eu.tutorials.testapp.utils.Pokemon
import kotlinx.android.extensions.LayoutContainer


class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var listMenu = listOf<Menu>()
    var onItemClick: ((Menu) -> Unit)? = null
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
//        binding.ivMenuImage.setImageResource(menu.imageUrl)

//        binding.cardMenu.setOnClickListener {
//            onItemClick?.invoke(menu)
//            Log.d("MENU", ">> ${menu} ")
//        }

        }
    }
}