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


class MainActivity : DaggerAppCompatActivity() {
//    @Inject
//    lateinit var dataManager: DataManager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(application))
//            .build()
//        appComponent.inject(this)
//
//        // Now you can use the injected dataManager
//        dataManager.doSomething()

}
//    @Inject
//    lateinit var alertDialogBuilder: AlertDialog.Builder
//
//    @Inject
//    lateinit var pattern: Regex

//    private lateinit var usernameEditText: EditText
//    private lateinit var passwordEditText: EditText

//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val appComponent = DaggerAppComponent.create()
//sinv
//        val dialog = alertDialogBuilder
//            .setTitle("Login Failed")
//            .setMessage("Invalid username or password. Please try again.")
//            .setPositiveButton("OK") { dialog, _ ->
//                dialog.dismiss()
//            }
//            .create()


//
//        usernameEditText = findViewById(R.id.InputUsername)
//        passwordEditText = findViewById(R.id.InputPassword)
//
//        val loginButton: Button = findViewById(R.id.LoginButton)
//
//        loginButton.setOnClickListener {
//            Log.d("onclick>", "Click BTN>>>>>>")
//
//            val username = usernameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            Log.d("LoginActivity", "Login button clicked - Username: $username, Password: $password")
//
//            if (validateCredentials(username, password)) {
//                Log.d("condition>", "condition>>>>>>> $username, Password: $password")
////                navigateToProfile()
//            } else {
//                showLoginFailurePopup()
//            }
//        }

//        usernameEditText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                val username = s.toString()
//                if (!isUsernameValid(username)) {
//                    usernameEditText.error = "Invalid username"
//                }
//            }
//        })
//    }
//    private fun showLoginFailurePopup() {
//        AlertDialog.Builder(this)
//            .setTitle("Login Failed")
//            .setMessage("Invalid username or password. Please try again.")
//            .setPositiveButton("OK") { dialog, _ ->
//                dialog.dismiss()
//            }
//            .show()
//    }

    private fun validateCredentials(username: String, password: String): Boolean {
        Log.d("credentials>", "credentials>>>>>>> $username, Password: $password")
        return username == "gg" && password == "1234"
    }

    private fun isUsernameValid(username: String): Boolean {
        val pattern = Regex("^[a-zA-Z0-9]+$")
        return pattern.matches(username)
    }


