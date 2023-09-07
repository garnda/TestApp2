package eu.tutorials.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import eu.tutorials.testapp.databinding.ActivityDetailMenuBinding
import eu.tutorials.testapp.databinding.FragmentMenuDescriptionBinding
import eu.tutorials.testapp.utils.Pokemon
import java.util.Objects


class DetailMenuActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityDetailMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar = findViewById(R.id.toolbar)

    setSupportActionBar(toolbar)
    @Suppress("DEPRECATION") val clickedMenu = intent?.getParcelableExtra<Pokemon>("POKEMON")

    if (clickedMenu != null) {
        Log.d("clickedMenu >>", "onCreate: {$clickedMenu}")
        supportActionBar?.title = clickedMenu.name
//        val url = clickedMenu.url
//        val parts = url.split("/")
//        val pokemonNumber = parts.getOrNull(parts.size - 2)?.toIntOrNull()
//        val imageUrl =
//            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$pokemonNumber.png"
//        if (pokemonNumber != null) {
//            Glide.with(binding.ivDetailMenu.context)
//                .load(imageUrl)
//                .thumbnail(0.2f)
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.cake)
//                .into(binding.ivDetailMenu)
//        } else {
//            binding.ivDetailMenu.setImageResource(R.drawable.cake)
//        }

        replaceFragment(Fragment1.newInstance(clickedMenu))

    } else {
        // Handle case where clickedMenu null
    }

        binding.fragmentBtn1.setOnClickListener {
            if (clickedMenu != null) {
                replaceFragment(Fragment1.newInstance(clickedMenu))
            }
        }
        binding.fragmentBtn2.setOnClickListener {
            if (clickedMenu != null) {
                replaceFragment(Fragment2.newInstance(clickedMenu))
            }

        }

//        Log.d("MENU>>", "onCreate: ${clickedMenu}")
    }


    private fun  replaceFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainer.id, fragment)
        fragmentTransaction.commit()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
