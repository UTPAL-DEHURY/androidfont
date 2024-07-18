package com.example.androidfont

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AndroidFontTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    BigText()
                    Spacer(modifier = Modifier.height(16.dp))
                    TextColor()
                    Spacer(modifier = Modifier.height(20.dp))
                    BoldText()
                    Spacer(modifier = Modifier.height(24.dp))
                    TextShadow()
                    Spacer(modifier = Modifier.height(28.dp))
                    MultipleStylesInText()
                    Spacer(modifier = Modifier.height(32.dp))
                    GradientText()
                    Spacer(modifier = Modifier.height(36.dp))
                    TextSpan()
                    Spacer(modifier = Modifier.height(40.dp))
                    AddEmoji()
                    Spacer(modifier = Modifier.height(44.dp))
                    TextFont()
                }
            }
        }
    }
}

@Composable
fun AndroidFontTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
fun BigText() {
    Text(text = "This is Utpal", fontSize = 30.sp)
}

@Composable
fun TextColor() {
    Text(text = "Font color is changed to red", color = Color.Red)
}

@Composable
fun BoldText() {
    Text(text = "Font is changed to bold", fontWeight = FontWeight.Bold, color = Color.Green)
}

@Composable
fun TextShadow() {
    Text(
        text = "Shadow has been added",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = Offset(5.0f, 10.0f), blurRadius = 3f
            )
        )
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("U")
            }
            append("tpal")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("D")
            }
            append("ehury")
        }
    )
}

@Composable
fun GradientText() {
    val gradientColors = listOf(Color.Magenta, Color.Red, Color.Yellow)
    Text(
        text = "Failure is the pillar of success",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            ),
            fontSize = 18.sp
        )
    )
}

@Composable
fun TextSpan() {
    val rainbowColors = listOf(
        Color.Red,
        Color(0xFFFFA500),
        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color(0xFF4B0082),
        Color(0xFFEE82EE)
    )

    Text(
        text = buildAnnotatedString {
            append("Do not allow people to dim your shine\n")
            withStyle(
                style = SpanStyle(
                    brush = Brush.linearGradient(
                        colors = rainbowColors
                    )
                )
            ) {
                append("because they are blinded.")
            }
            append("\nTell them to put some sunglasses on.")
        },
        fontSize = 20.sp
    )
}

@Composable
fun AddEmoji() {
    val rainbowColors = listOf(
        Color.Red,
        Color(0xFFFFA500), // Orange
        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color(0xFF4B0082), // Indigo
        Color(0xFFEE82EE)  // Violet
    )

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    brush = Brush.linearGradient(
                        colors = rainbowColors
                    ),
                    alpha = 0.5f
                )
            ) {
                append(" I Am Loving  ")
            }
            withStyle(
                style = SpanStyle(
                    brush = Brush.linearGradient(
                        colors = rainbowColors
                    ),
                    alpha = 1f
                )
            ) {
                append(" Jetpack Compose ❤")
            }
        },
        fontSize = 20.sp
    )
}

@Composable
fun TextFont() {
    Text(
        text = "Text is changed to Italics",
        fontStyle = FontStyle.Italic,
        color = Color(0xFF800080),  // Hex value for purple
        fontSize = 20.sp
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidFontTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BigText()
            Spacer(modifier = Modifier.height(16.dp))
            TextColor()
            Spacer(modifier = Modifier.height(20.dp))
            BoldText()
            Spacer(modifier = Modifier.height(24.dp))
            TextShadow()
            Spacer(modifier = Modifier.height(28.dp))
            MultipleStylesInText()
            Spacer(modifier = Modifier.height(32.dp))
            GradientText()
            Spacer(modifier = Modifier.height(36.dp))
            TextSpan()
            Spacer(modifier = Modifier.height(40.dp))
            AddEmoji()
            Spacer(modifier = Modifier.height(44.dp))
            TextFont()
        }
    }
}