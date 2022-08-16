package com.arrkariz.tokoskill.features.kerjaan.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component.Body
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun KerjaanScreen() {

    val configuration = LocalConfiguration.current
    val itemList = ArrayList<String>()
    itemList.add("https://i.imgur.com/hUA1nni.jpeg")
    itemList.add("https://i.imgur.com/hUA1nni.jpeg")
    itemList.add("https://i.imgur.com/hUA1nni.jpeg")

    Column() {
        Body(configuration = configuration, items = itemList)
        Box() {
            Spacer(
                Modifier
                    .width(configuration.screenWidthDp.dp)
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent,
                            )
                        )
                    )

            )
        }
    }
}
