package com.asthiseta.courseapp.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResId : Int,
    val availableCourses : Int,
    @DrawableRes val drawableResId : Int
)
