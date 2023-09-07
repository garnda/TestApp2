package eu.tutorials.testapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dagger.android.support.DaggerFragment
import eu.tutorials.testapp.databinding.FragmentOneBinding
import eu.tutorials.testapp.databinding.FragmentTwoBinding
import eu.tutorials.testapp.utils.Pokemon

//class Fragment2: Fragment(R.layout.fragment_two) {
//}

class Fragment2: Fragment() {
    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        val pokemon = arguments?.getParcelable<Pokemon>("key")

        binding.textMenu2.text = pokemon?.name
       val url = pokemon?.url
        val parts = url?.split("/")
        val pokemonNumber = parts?.getOrNull(parts.size - 2)?.toIntOrNull()
        val imageUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$pokemonNumber.png"
        if (pokemonNumber != null) {
            Glide.with(binding.ivFragment2.context)
                .load(imageUrl)
                .placeholder(R.drawable.loading)
                .error(R.drawable.cake)
                .into(binding.ivFragment2)
        } else {
            binding.ivFragment2.setImageResource(R.drawable.cake)
        }
        return binding.root
    }

    companion object{
        fun newInstance(pokemon: Pokemon) = Fragment2().apply {
            arguments = Bundle().apply {
                putParcelable("key", pokemon)
                Log.d("KEY A2>", "onCreate: $pokemon")
            }
        }
    }
}