package eu.tutorials.testapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment
import eu.tutorials.testapp.databinding.FragmentOneBinding
import eu.tutorials.testapp.databinding.FragmentTwoBinding

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
        val menu = arguments?.getParcelable<Menu>("key")

        binding.textMenu2.text = menu?.name
        binding.ivMenuImage.setImageResource(menu?.imageUrl ?: 0)

        return binding.root
    }

    companion object{
        fun newInstance(menu: Menu) = Fragment2().apply {
            arguments = Bundle().apply {
                putParcelable("key", menu)
                Log.d("KEY A2>", "onCreate: $menu")
            }
        }
    }
}