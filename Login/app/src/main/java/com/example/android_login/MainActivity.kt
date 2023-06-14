package com.example.android_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.android_login.ui.theme.Android_LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val topColorRed = 70
//    val topColorGreen = 128
//    val topColorBlue = 221
//    val bottomColorRed = 85
//    val bottomColorGreen = 80
//    val bottomColorBlue = 188
//    val colorTop = Color(red = topColorRed, green = topColorGreen, blue = topColorBlue)
//    val colorBottom = Color(red = bottomColorRed, green = bottomColorGreen, blue = bottomColorBlue)
//
//    Box(modifier = modifier) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.5f)
//                .background(
//                    brush = Brush.verticalGradient(
//                        colors = listOf(colorTop, colorBottom),
//                        startY = 0f, // Start at the top of the layout
//                        endY = Float.POSITIVE_INFINITY // Extend indefinitely towards the bottom
//                    )
//                )
//                .zIndex(1f)
//        )
//
//
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.White, shape = CircleShape) // White background with rounded shape
//                .align(Alignment.Center)
//        ) {
//            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.home),
//                contentDescription = "Reddit smol icon" )
//        }
//    }
//}
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val topColorRed = 70
    val topColorGreen = 128
    val topColorBlue = 221
    val bottomColorRed = 85
    val bottomColorGreen = 80
    val bottomColorBlue = 188
    val colorTop = Color(red = topColorRed, green = topColorGreen, blue = topColorBlue)
    val colorBottom = Color(red = bottomColorRed, green = bottomColorGreen, blue = bottomColorBlue)
    Box(modifier = modifier) {
        Box() {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                            colors = listOf(colorTop, colorBottom),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
                    .zIndex(1f)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, shape = CircleShape)
                    .align(Alignment.Center)
                    .zIndex(2f)
            ) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home Icon",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(16.dp),
                    tint = colorTop
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .zIndex(2f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,) {
                    Text(
                        text = "LOGIN",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    TextField(
                        value = "",
                        onValueChange = { /* Handle email value change */ },
                        label = { Text(text = "Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "",
                        onValueChange = { /* Handle password value change */ },
                        label = { Text(text = "Password") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .zIndex(3f)
                
            ) {
                Button(onClick = { /*TODO*/ }) {
                   Text(text = "Login") 
                } 
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_LoginTheme {
        Greeting("Android")
    }
}