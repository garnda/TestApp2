package eu.tutorials.testapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    val id: Int,
    val name: String,
    val imageUrl: Int,
    val description: String
):Parcelable