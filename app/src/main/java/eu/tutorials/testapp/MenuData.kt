package eu.tutorials.testapp

data class Menu (
     val id: Int,
     val name: String,
     val imageUrl: String
)

object MenuItem {
     val menuList = listOf(
          Menu(1, "One", "https://unsplash.com/photos/rDEOVtE7vOs"),
          Menu(2, "Two" , "https://unsplash.com/photos/JN0SUcTOig0")
     )
}