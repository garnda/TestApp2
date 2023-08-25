package eu.tutorials.testapp
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment
import eu.tutorials.testapp.databinding.ActivityDetailMenuBinding
import eu.tutorials.testapp.databinding.FragmentOneBinding

class Fragment1: Fragment() {
//    private  lateinit var textMenu: TextView
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOneBinding.inflate(inflater, container, false)
        val menu = this.arguments?.getString("key")
        Log.d("MENU in fragment>>", "onCreate: $menu")
        binding.textMenu1.text = menu
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object{
    fun newInstance(a:String) = Fragment1().apply {
        arguments = Bundle().apply {
            putString("key",a)
            Log.d("KEY A>", "onCreate: ${a}")
            }
        }
    }


}