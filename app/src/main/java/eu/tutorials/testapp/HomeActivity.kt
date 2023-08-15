package eu.tutorials.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import eu.tutorials.testapp.databinding.ActivityHomeBinding
import eu.tutorials.testapp.ui.login.MainViewModel
import eu.tutorials.testapp.utils.ActivityViewModelFactory
import javax.inject.Inject

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
        binding.recyclerView.apply {
            adapter = HomeAdapter().apply {
                listMenu = listOf("A","B","C","D")
            }
            layoutManager = LinearLayoutManager(context)
        }
    }
}