package com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arrkariz.tokoskill.R

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