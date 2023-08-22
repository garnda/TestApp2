package eu.tutorials.testapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import eu.tutorials.testapp.databinding.ActivityHomeBinding
import eu.tutorials.testapp.ui.login.MainViewModel
import eu.tutorials.testapp.utils.ActivityViewModelFactory
import javax.inject.Inject
import androidx.core.os.bundleOf

class HomeActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ActivityViewModelFactory

    private lateinit var vm:HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val menuList = listOf(
            Menu(1, "One", R.drawable.cake,"cake"),
            Menu(2, "Two" , R.drawable.cupcake,"cake"),
            Menu(3,"Three",R.drawable.pudding,"cake"),
            Menu(4,"Four",R.drawable.cake,"cake"),
            Menu(5,"Five",R.drawable.cake,"cake")
        )
        val menuItem = listOf(
            "A","B","C","D"
        )

        binding.recyclerView.apply {
            adapter = HomeAdapter().apply {
                listMenu = menuList
                onItemClick = { clickedMenu ->
                    val bundle = bundleOf("MENU" to clickedMenu)
                    val intent = Intent(this@HomeActivity, DetailMenuActivity::class.java).apply {
                        putExtra("MENU", clickedMenu)
                    }
                    startActivity(intent)

//                  intent.
//                   val menu = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                        intent.getParcelableExtra("MENU",Menu::class.java)
//                    }else{
//                        intent.getParcelableExtra<Menu>("MENU")
//                    }

                    AlertDialog.Builder(this@HomeActivity)
                        .setTitle(clickedMenu.name)
                        .setMessage("ID: ${clickedMenu.id}\n Name: ${clickedMenu.name}")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }

            }
            layoutManager = LinearLayoutManager(context)
        }
    }

}