package eu.tutorials.testapp.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class PokemonResponse(
    val count: Int,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)


