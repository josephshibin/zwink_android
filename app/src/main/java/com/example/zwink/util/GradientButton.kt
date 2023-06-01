package com.example.zwink.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zwink.ui.theme.ZwinkTypography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import org.w3c.dom.Text

data class TextAttributes(
    val style: TextStyle,
    val text: String
)

@ExperimentalPagerApi
@Composable
fun GradientButton(
    modifier: Modifier,
    textAttributes: TextAttributes,
    onClick: () -> Unit
) {
    val gradientColors = listOf(
        Color(138, 26, 255),
        Color(255, 82, 71)

    )
    Button(
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick =  onClick )
    {
        Box(
            modifier = modifier
                .background(
                    Brush.verticalGradient(
                        colors = gradientColors
                    )
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = textAttributes.text,
                style = textAttributes.style
            )
        }
    }
}


@ExperimentalPagerApi
@Preview
@Composable
fun ButtonPreview()
{
    val textAttributes = TextAttributes(
        style = ZwinkTypography.displaySmall.copy(
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        text = if (2 == 2) "GET STARTED" else "NEXT"
    )
  GradientButton(modifier = Modifier.size(342.dp, 48.dp), textAttributes) {

  }
}