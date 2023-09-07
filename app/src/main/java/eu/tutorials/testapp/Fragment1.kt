package eu.tutorials.testapp
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dagger.android.support.DaggerFragment
import eu.tutorials.testapp.databinding.ActivityDetailMenuBinding
import eu.tutorials.testapp.databinding.FragmentOneBinding
import eu.tutorials.testapp.utils.Pokemon
import java.io.Serializable
import java.util.Objects

class Fragment1: Fragment() {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOneBinding.inflate(inflater, container, false)
        val pokemon = arguments?.getParcelable<Pokemon>("key")
        Log.d("MENU in fragment>>", "onCreate: $pokemon")
        binding.textMenu1.text = pokemon?.name
        val url = pokemon?.url
        val parts = url?.split("/")
        val pokemonNumber = parts?.getOrNull(parts.size - 2)?.toIntOrNull()
        val imageUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonNumber.png"
        if (pokemonNumber != null) {
            Glide.with(binding.ivFragment1.context)
                .load(imageUrl)
                .placeholder(R.drawable.loading)
                .error(R.drawable.cake)
                .into(binding.ivFragment1)
        } else {
            binding.ivFragment1.setImageResource(R.drawable.cake)
        }
        return binding.root
    }

    companion object {
        fun newInstance(pokemon: Pokemon) = Fragment1().apply {
                arguments = Bundle().apply {
                    putParcelable("key", pokemon)
                    Log.d("KEY A2>", "onCreate: $pokemon")
            }
        }
    }
}