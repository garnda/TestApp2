package eu.tutorials.testapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import eu.tutorials.testapp.databinding.RecycleCardsBinding
import kotlinx.android.extensions.LayoutContainer


class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var listMenu = listOf<Menu>()
    var onItemClick: ((Menu) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = RecycleCardsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       holder.bindUi(listMenu[position])
    }

    override fun getItemCount(): Int {
       return listMenu.size
    }


inner class HomeViewHolder(val binding: RecycleCardsBinding): ViewHolder(binding.root),
    LayoutContainer{

    override val containerView: View
        get() = itemView

    internal fun bindUi(menu: Menu) {
       binding.tvMenu.text = menu.name
        binding.ivMenuImage.setImageResource(menu.imageUrl)

        binding.cardMenu.setOnClickListener {
            onItemClick?.invoke(menu)
            Log.d("MENU", ">> ${menu} ")
        }

        }
    }
}