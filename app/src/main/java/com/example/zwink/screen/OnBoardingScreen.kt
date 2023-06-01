package com.example.zwink.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.onboardingcompose.navigation.Screen
import com.example.zwink.ui.theme.AppBackground
import com.example.zwink.ui.theme.ButtonText
import com.example.zwink.ui.theme.OnBoardDescription
import com.example.zwink.ui.theme.OnBoardingTitle
import com.example.zwink.ui.theme.ZwinkTypography
import com.example.zwink.util.GradientButton
import com.example.zwink.util.OnBoardingPage
import com.example.zwink.util.TextAttributes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    navController: NavHostController
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    // To handle the back button press on mobile
    BackHandler {
        if (pagerState.currentPage > 0) {
            scope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppBackground)
    ) {
        HorizontalPager(
           // modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(indicatorHeight = 10.dp,
            indicatorWidth = 10.dp,
            inactiveColor=  Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp, bottom = 24.dp),
               // .weight(1f),
            pagerState = pagerState
        )
        Button(
            modifier = Modifier,
            pagerState = pagerState
        ) {
            if (pagerState.currentPage == 2) {
                //welcomeViewModel.saveOnBoardingState(completed = true)
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            } else {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .background(color = AppBackground),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                modifier = Modifier.aspectRatio(464f/669f),
                // .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = null,
                // contentScale = ContentScale.Crop
            )
        Text( style = ZwinkTypography.titleMedium,
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = onBoardingPage.title) ,
            color = OnBoardingTitle,
            textAlign = TextAlign.Center
        )
        Text(style = ZwinkTypography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(start = 24.dp, end = 25.dp),
            text = stringResource(id = onBoardingPage.description),
            color = OnBoardDescription,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalPagerApi // for pagerState dependence
@Composable
fun Button(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    val textAttributes = TextAttributes(
        style = ZwinkTypography.displaySmall.copy(
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        text = if (pagerState.currentPage == 2) "GET STARTED" else "NEXT"
    )
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
      GradientButton(modifier = modifier.size(342.dp, 48.dp),textAttributes,onClick )

    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen1() {
    PagerScreen(onBoardingPage = OnBoardingPage.First)

}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen2() {
    PagerScreen(onBoardingPage = OnBoardingPage.Second)

}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen3() {
    PagerScreen(onBoardingPage = OnBoardingPage.Third)

}
@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun FinalPreview(){
    val navController = rememberNavController()
    OnBoardingScreen(navController = navController)
}
