package com.example.android_login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.android_login.ui.theme.Android_LoginTheme

class MainActivity : ComponentActivity() {
    var viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val emailId by viewModel.emailId.collectAsState()
    val password by viewModel.passWord.collectAsState()
    val topColorRed = 70
    val topColorGreen = 128
    val topColorBlue = 221
    val bottomColorRed = 85
    val bottomColorGreen = 80
    val bottomColorBlue = 188
    val colorTop = Color(red = topColorRed, green = topColorGreen, blue = topColorBlue)
    val colorBottom = Color(red = bottomColorRed, green = bottomColorGreen, blue = bottomColorBlue)
    Box() {
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
                        value = emailId,
                        onValueChange = { viewModel::onEmailIDChanged },
                        label = { Text(text = "Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = password,
                        onValueChange = { viewModel::onPasswordChanged},
                        label = { Text(text = "Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 25.dp)
                    .fillMaxWidth(0.8f)
                    .align(Alignment.Center)
//                        .padding(top = 20.dp)
                    .zIndex(3f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        viewModel.authenticateUser()
                        Log.d("main_activity:-", "button clicked!")

                    },
                    modifier = Modifier
                        .height(50.dp)
                    ) {
                        Text(
                            text = "LOGIN",
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

}

