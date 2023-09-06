package eu.tutorials.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import eu.tutorials.testapp.databinding.ActivityDetailMenuBinding
import eu.tutorials.testapp.databinding.FragmentMenuDescriptionBinding
import java.util.Objects


class DetailMenuActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityDetailMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_menu)
        binding = ActivityDetailMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar = findViewById(R.id.toolbar)

    setSupportActionBar(toolbar)
    @Suppress("DEPRECATION") val clickedMenu = intent?.getParcelableExtra<Menu>("MENU")

    if (clickedMenu != null) {
        supportActionBar?.title = clickedMenu.name
        replaceFragment(Fragment1.newInstance(clickedMenu.description))

    } else {
        // Handle case where clickedMenu null
    }

        binding.fragmentBtn1.setOnClickListener {
            if (clickedMenu != null) {
                replaceFragment(Fragment1.newInstance(clickedMenu.description))
            }
        }
        binding.fragmentBtn2.setOnClickListener {
//            replaceFragment(Fragment2())
            if (clickedMenu != null) {
                replaceFragment(Fragment2.newInstance(clickedMenu))
            }

        }

//        Log.d("MENU>>", "onCreate: ${clickedMenu}")
    }


    private fun  replaceFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
////        val menuDescriptionFragment = MenuDescriptionFragment()
////        fragmentTransaction.replace(R.id.fragment_container, menuDescriptionFragment)
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
