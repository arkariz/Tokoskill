package com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.arrkariz.tokoskill.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomDrawer(isExpanded: Boolean, expanded: (Boolean) -> Unit) {
    Surface(
        onClick = {expanded(!isExpanded)},
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isExpanded) 480.dp else 150.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(Color.DarkGray.copy(alpha = 0.8f))
                .animateContentSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Drawer Pinch Icon
                Box(
                    Modifier
                        .background(Color.LightGray)
                        .width(24.dp)
                        .height(4.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                //Title
                Text(
                    text = "Bersihkan Rumah",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                HorizonralSaparator()

                MainInformation()

                HorizonralSaparator()

                DescriptionText()

                HorizonralSaparator()

                LocationDescription()

                HorizonralSaparator()

                ActionButton()
            }
        }
    }

}

@Composable
fun MainInformation(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Gaji
        BottomDrawerIcon(
            label = "Gaji",
            value = "Rp. 280.000",
            image = R.drawable.ic_gaji
        )

        VerticalSaparator()

        //Bos
        BottomDrawerIcon(
            label = "Bos",
            value = "Elona Holmes",
            image = R.drawable.ic_bos
        )

        VerticalSaparator()

        //Waktu
        BottomDrawerIcon(
            label = "Upload",
            value = "13 Menit Lalu",
            image = R.drawable.ic_time
        )
    }
}

@Composable
fun BottomDrawerIcon(label: String, value: String, image: Int) {
    Column() {
        Row() {
            Image(
                painter = rememberImagePainter(image),
                contentDescription = label,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(Modifier.width(4.dp))
            Text(text = label, color = Color.White, fontSize = 14.sp)
        }
        Text(text = value, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun DescriptionText() {
    Column() {
        Text(text = "Catatan", fontSize = 20.sp, color = Color.White)
        Spacer(Modifier.height(12.dp))
        Text(
            text = "Rumahnya dibersihkan sebaik mungkin ya soalnya sudah sangat " +
                    "berdebu terutama dibagian kamar tidur, dapur dan ruang tamu. " +
                    "Nanti saya sediakan alat-alatnya untuk membersihkan. Terima kasih.",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun LocationDescription() {
    Column() {
        Text(text = "Lokasi", fontSize = 20.sp, color = Color.White)
        Spacer(Modifier.height(12.dp))
        Text(
            text = "Jl. Kaliurang km 5, Gang ester 3, No.713, Belakang indomart, Yogyakarta, DIY",
            color = Color(0xFF55ADFF),
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun ActionButton() {
    Row() {
        Button(
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = Color(0xFFF83967)
                ),
            shape = RoundedCornerShape(12.dp),
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = rememberImagePainter(R.drawable.ic_chat),
                contentDescription = "Chat Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
            )

        }
        Spacer(Modifier.width(6.dp))
        Button(
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = Color(0xFF3580FF)
                ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Ambil Kerjaan", color = Color.White, fontSize = 16.sp)
        }
    }
}


@Composable
fun HorizonralSaparator() {
    Spacer(modifier = Modifier.height(12.dp))
    Box(
        Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(1.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun VerticalSaparator() {
    Spacer(Modifier.width(16.dp))
    Box(
        Modifier
            .background(Color.LightGray)
            .width(1.dp)
            .height(40.dp)
            .padding(horizontal = 12.dp)
    )
    Spacer(Modifier.width(16.dp))
}

