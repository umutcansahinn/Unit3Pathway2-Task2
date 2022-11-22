package com.umutcansahin.unit3pathway2task2.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val name: Int,
    val availableCourses: Int,
    @DrawableRes
    val imageRes: Int

)
