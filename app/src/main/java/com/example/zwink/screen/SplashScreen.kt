package com.example.zwink.screen

import android.graphics.Paint.Style
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.excludeFromSystemGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.example.onboardingcompose.navigation.Screen

import com.example.zwink.R
import com.example.zwink.ui.theme.AppBackground
import com.example.zwink.ui.theme.AppBrading


import com.example.zwink.ui.theme.ZwinkTheme
import com.example.zwink.ui.theme.ZwinkTypography
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(4000)

        navController.popBackStack()
        // Todo Implement a functionality to check  whether the on_boarding is
        //  completed if completed then skip the on_boarding
        if (false) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }

    }
    Splash()
}

@Composable
fun Splash() {

    Box(
        modifier = Modifier
            .background(color = AppBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.zwink_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)// TODO change the size
            )
            Text(
                text = stringResource(id = R.string.zwink_splash_app_description),
                color = AppBrading,
                style = ZwinkTypography.displaySmall.copy(
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                ),
                modifier = Modifier.padding(top = 4.15.dp)
            )
        }

        Text(
            text = stringResource(id = R.string.zwink_splash_powered_by),
            color = AppBrading,
            style = ZwinkTypography.displaySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 35.dp)

        )
    }
}



@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}