package com.example.android_login

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_login.Dashboard.DashboardView
import com.example.android_login.Dashboard.DashboardViewModel
import com.example.android_login.Dashboard.UserDetailView
import com.example.android_login.Login.LoginScreen
import com.example.android_login.Login.LoginViewModel
import com.example.android_login.ui.theme.Android_LoginTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
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
                    App()
//                    MyScreen()
//                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun App() {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("dashboard") {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            DashboardView(navController)
        }
        composable("userDetail/{id}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("id")!!
            UserDetailView(userId = userId, navController)
        }
    }
}

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
       println("=== My Application ===")
    }
}

