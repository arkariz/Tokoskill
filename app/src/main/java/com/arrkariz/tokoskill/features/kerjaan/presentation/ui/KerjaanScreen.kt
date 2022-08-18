package com.arrkariz.tokoskill.features.kerjaan.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.arrkariz.tokoskill.R
import com.arrkariz.tokoskill.features.kerjaan.presentation.ui.component.Body
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun KerjaanScreen() {
    val configuration = LocalConfiguration.current
    val itemList = ArrayList<Int>()
    itemList.add(R.drawable.image_1)
    itemList.add(R.drawable.image_2)
    itemList.add(R.drawable.image_3)

    Body(configuration = configuration, items = itemList)

}
