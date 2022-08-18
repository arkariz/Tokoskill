package com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberImagePainter
import com.arrkariz.tokoskill.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Body(configuration: Configuration, items: List<Int>) {
    val pagerState = rememberPagerState()
    var expanded by remember { mutableStateOf(false) }

    HorizontalPager(
        count = items.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxHeight()
            .width(configuration.screenWidthDp.dp)
            .background(Color.DarkGray),
    ) { page ->
        Box(
            //Animate ViewPager Swipe
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            //Main Content
            val painter = rememberImagePainter(items[page])
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(configuration.screenWidthDp.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
            )

            //Top shadow gradient
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

            //Play Button
            AnimatedVisibility(
                !expanded,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .size(66.dp)
                        .clip(CircleShape)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_play),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 12.dp, top = 6.dp)
                            .width(52.dp)
                            .height(52.dp)
                            .align(Alignment.Center),
                    )
                }
            }

            //Side Menu Button
            AnimatedVisibility(
                !expanded,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 15.dp, bottom = 200.dp)
            ) {
                SideMenuButton()

            }

            //Bottom Drawer
            Box(Modifier.align(Alignment.BottomCenter)) {
                BottomDrawer(expanded) {
                    expanded = it
                }
            }

        }
    }
}