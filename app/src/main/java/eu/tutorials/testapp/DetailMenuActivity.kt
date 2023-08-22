package eu.tutorials.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import eu.tutorials.testapp.databinding.ActivityDetailMenuBinding


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
    val clickedMenu = intent?.getParcelableExtra<Menu>("MENU")

    if (clickedMenu != null) {
        supportActionBar?.title = clickedMenu.name
        binding.detailImageView.setImageResource(clickedMenu.imageUrl)

    } else {
        // Handle case where clickedMenu null
    }

        Log.d("MENU>>", "onCreate: ${clickedMenu}")
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Handle back navigation arrow click
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}