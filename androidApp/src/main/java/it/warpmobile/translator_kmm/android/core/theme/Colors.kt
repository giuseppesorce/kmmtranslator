package it.warpmobile.translator_kmm.android.core.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import it.warpmobile.translator_kmm.core.presentation.Colors

/**
 * @author Giuseppe Sorce
 */
val AcccentViolet = Color(Colors.AccentViolet)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGrey = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGrey = Color(Colors.DarkGrey)


val lightColors = lightColors(
    primary =  AcccentViolet,
    background =  LightBlueGrey,
    onPrimary =  Color.White,
    surface =  Color.White,
    onBackground = TextBlack,
    onSurface =  TextBlack
)

val darkColors = darkColors(
    primary =  AcccentViolet,
    background =  DarkGrey,
    onPrimary =  Color.White,
    surface =  DarkGrey,
    onBackground = Color.White,
    onSurface =  Color.White
)