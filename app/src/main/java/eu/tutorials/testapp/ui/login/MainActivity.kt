package eu.tutorials.testapp.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import eu.tutorials.testapp.databinding.ActivityMainBinding
import eu.tutorials.testapp.utils.ActivityViewModelFactory
import eu.tutorials.testapp.data.preference.AppPreferences
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ActivityViewModelFactory

    private lateinit var vm: MainViewModel

    private lateinit var appPreferences: AppPreferences

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

        binding.btnLogin.setOnClickListener {
            Log.d("onclick>", "Click BTN>>>>>>")

            val username = binding.etInputUsername.text.toString()
            val password = binding.etInputPassword.text.toString()
            Log.d(
                "LoginActivity",
                "Login button clicked - Username: $username, Password: $password"
            )
            vm.validateCredentials(username, password)
        }

        binding.etInputUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val username = s.toString()
                if (!isUsernameValid(username)) {
                    binding.etInputUsername.error = "Invalid username"
                }
            }
        })
    }

    private fun initViewModel() {
        vm.onLoginSuccess.observe(this){
          Log.d("minemine","onLoginSuccess")
        }

        vm.onLoginFailure.observe(this){
            Log.d("minemine","onLoginFailure")
        }
    }

    private fun showLoginFailurePopup() {
        AlertDialog.Builder(this)
            .setTitle("Login Failed")
            .setMessage("Invalid username or password. Please try again.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    private fun isUsernameValid(username: String): Boolean {
        val pattern = Regex("^[a-zA-Z0-9]+$")
        return pattern.matches(username)
    }
}


