package com.sabekur2017.composeuipractice.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
