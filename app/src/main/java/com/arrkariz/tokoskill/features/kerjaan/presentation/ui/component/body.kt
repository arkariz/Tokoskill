package com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component

import android.app.Activity
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.arrkariz.tokoskill.R

@Composable
fun Body(configuration: Configuration, image: String) {
    Box(
        Modifier.height(((configuration.screenHeightDp).dp))
    ) {
        val painter = rememberImagePainter(R.drawable.imgee)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .width(configuration.screenWidthDp.dp)
                .height((configuration.screenHeightDp).dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(
            Modifier
                .width(configuration.screenWidthDp.dp)
                .height(50.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Transparent,
                        )
                    )
                )
                .align(Alignment.TopCenter)
        )

        Spacer(
            Modifier
                .width(configuration.screenWidthDp.dp)
                .height(70.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )
    }
}