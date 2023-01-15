
package it.warpmobile.translator_kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import it.warpmobile.translator_kmm.android.core.theme.darkColors
import it.warpmobile.translator_kmm.android.core.theme.lightColors

import it.warpmobile.translator_kmm.android.core.presentation.Routes.TRANSLATE
import it.warpmobile.translator_kmm.android.translate.presentation.AndroidTranslateViewmodel
import it.warpmobile.translator_kmm.android.translate.presentation.TranslateScreen


@Composable
fun TranslatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
       darkColors
    } else {
        lightColors
    }
    val SfProText = FontFamily(
        Font(
            resId = R.font.sf_pro_text_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.sf_pro_text_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.sf_pro_text_bold,
            weight = FontWeight.Bold
        ),
    )
    val typography = Typography(
        h1 = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        h2 = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h3 = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        body1 = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TranslateRoot()
                }
            }
        }
    }
}


@Composable
fun TranslateRoot() {

    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = TRANSLATE){
       composable(route = TRANSLATE){

           val translateViewmodel = hiltViewModel<AndroidTranslateViewmodel>()
           val state by translateViewmodel.state.collectAsState()
           TranslateScreen(state = state, onEvent = translateViewmodel :: onEvent)
       }
    }
    
}