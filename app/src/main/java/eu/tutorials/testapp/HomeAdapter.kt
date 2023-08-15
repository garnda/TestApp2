package eu.tutorials.testapp

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import eu.tutorials.testapp.databinding.RecycleCardsBinding
import kotlinx.android.extensions.LayoutContainer

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var listMenu = listOf<String>()
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

    internal fun bindUi(menuName: String) {
       binding.tvMenu.text = menuName
    }
    }
}