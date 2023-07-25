package eu.tutorials.testapp

data class User(val username: String, val password: String)

object UserData {
    val userList = listOf(
        User("john", "password123"),
        User("GG", "1234")
    )
}