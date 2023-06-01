package com.example.zwink.util

import androidx.annotation.DrawableRes
import com.example.zwink.R


sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: Int,
    val description: Int
) {
    object First : OnBoardingPage(
        image = R.drawable.onboardingbg,
        title = R.string.zwink_walkthrough_page_1_title,
        description = R.string.zwink_walkthrough_page_1_description
    )

    object Second : OnBoardingPage(
        image = R.drawable.onboardingbg,
        title = R.string.zwink_walkthrough_page_2_title,
        description = R.string.zwink_walkthrough_page_2_description
    )

    object Third : OnBoardingPage(
        image = R.drawable.onboardingbg,
        title = R.string.zwink_walkthrough_page_3_title,
        description = R.string.zwink_walkthrough_page_3_description
    )
}
