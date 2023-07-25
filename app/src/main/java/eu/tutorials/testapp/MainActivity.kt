package eu.tutorials.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.util.Log
import androidx.appcompat.app.AlertDialog
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import dagger.Component
import dagger.Module
import dagger.Provides
import eu.tutorials.testapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            Log.d("onclick>", "Click BTN>>>>>>")

            val username = binding.etInputUsername.text.toString()
            val password = binding.etInputPassword.text.toString()
            Log.d(
                "LoginActivity",
                "Login button clicked - Username: $username, Password: $password"
            )

            if (validateCredentials(username, password)) {
                Log.d("condition>", "condition>>>>>>> $username, Password: $password")
//                navigateToProfile()
            } else {
                showLoginFailurePopup()
            }
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

    private fun showLoginFailurePopup() {
        AlertDialog.Builder(this)
            .setTitle("Login Failed")
            .setMessage("Invalid username or password. Please try again.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        Log.d("credentials>", "credentials>>>>>>> $username, Password: $password")
        return username == "gg" && password == "1234"
    }

    private fun isUsernameValid(username: String): Boolean {
        val pattern = Regex("^[a-zA-Z0-9]+$")
        return pattern.matches(username)
    }
}


