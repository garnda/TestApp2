package eu.tutorials.testapp

import javax.inject.Inject

class ValidateLoginUseCase @Inject constructor(){

    fun execute(username: String, password: String): Boolean {
        return username == "gg" && password == "1234"
    }
}