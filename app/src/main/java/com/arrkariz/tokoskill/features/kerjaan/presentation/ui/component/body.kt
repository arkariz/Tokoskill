package com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberImagePainter
import com.arrkariz.tokoskill.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Body(configuration: Configuration, items: List<String>) {
    val pagerState = rememberPagerState()

    HorizontalPager(count = items.size, state = pagerState) { page ->
        Box(
            Modifier
                .height(((configuration.screenHeightDp).dp))
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
            val painter = rememberImagePainter(R.drawable.imgee)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(configuration.screenWidthDp.dp)
                    .height((configuration.screenHeightDp).dp),
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

            //Bottom shadow gradient
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

            //Side Menu Button
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 15.dp, bottom = 100.dp)
            ) {
                SideMenuButton()
            }
        }
    }
}

@Composable
fun SideMenuButton() {
    Column() {
        //Video Icon
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.DarkGray.copy(alpha = 0.8f))
        ) {
            val painter = painterResource(R.drawable.ic_video)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .align(Alignment.Center),
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        //Notif Icon
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.DarkGray.copy(alpha = 0.8f))
        ) {
            val painter = painterResource(R.drawable.ic_notif)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .align(Alignment.Center),
            )
            Box(
                Modifier.padding(start = 30.dp, top = 6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                ) {
                    Text(
                        text = "2",
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))

        //Profile Icon
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.DarkGray.copy(alpha = 0.8f))
        ) {
            val painter = painterResource(R.drawable.ic_profile)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .align(Alignment.Center),
            )
        }
    }
}