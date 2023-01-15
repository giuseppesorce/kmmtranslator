package it.warpmobile.translator_kmm.android.translate.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import it.warpmobile.translator_kmm.android.R

/**
 * @author Giuseppe Sorce
 */
@Composable
fun SwapLaguagesButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
) {
   Icon(imageVector = ImageVector.vectorResource(id = R.drawable.swap_languages),
   contentDescription = "", tint = MaterialTheme.colors.onPrimary)
}

}