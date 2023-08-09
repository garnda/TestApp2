package eu.tutorials.testapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.testapp.Menu
import eu.tutorials.testapp.MenuItem
import eu.tutorials.testapp.R

private lateinit var menuRecyclerView: RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        menuRecyclerView = findViewById(R.id.menuRecyclerView)
//        val items = generateMenuList()
//        val adapter = MenuAdapter(items)

    }

//    private fun generateMenuList(): List<Menu> {
//        val menuList = mutableListOf<Menu>()
//        for (menuItem in MenuItem.menuList) {
//            val menu = Menu(menuItem.id, menuItem.name, menuItem.imageUrl)
//            menuList.add(menu)
//        }
//        return menuList
//    }

}