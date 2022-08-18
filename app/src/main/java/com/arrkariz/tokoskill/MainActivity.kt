package com.arrkariz.tokoskill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.arrkariz.tokoskill.features.kerjaan.presentation.ui.KerjaanScreen
import com.arrkariz.tokoskill.ui.theme.TokoskillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TokoskillTheme {
                KerjaanScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TokoskillTheme {
        KerjaanScreen()
    }
}