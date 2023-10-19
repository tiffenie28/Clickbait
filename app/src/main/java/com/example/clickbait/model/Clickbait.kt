package com.example.clickbait.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Click(

    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val desc: Int,
    @StringRes val time: Int
)

