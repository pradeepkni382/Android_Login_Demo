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
import com.example.android_login.UserDetails.UserDetailView
import com.example.android_login.Login.LoginScreen
import com.example.android_login.Login.LoginViewModel
import com.example.android_login.Services.AppContext
import com.example.android_login.ui.theme.Android_LoginTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var isUserLoggedIn: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Check if the activity is recreated and restore the state
        if (savedInstanceState != null) {
            isUserLoggedIn = savedInstanceState.getBoolean(KEY_USER_LOGGED_IN, false)
        }

        // Initialize the AppContext
        AppContext.initialize(applicationContext)
        setContent {
            Android_LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(isUserLoggedIn)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_USER_LOGGED_IN, isUserLoggedIn)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val KEY_USER_LOGGED_IN = "userLoggedIn"
    }
}

@Composable
fun App(isUserLoggedIn: Boolean) {

    val navController = rememberNavController()
    var startDestination = "login"
    if (isUserLoggedIn) {
        startDestination = "dashboard"
    }
    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") {
            LoginScreen(navController)
        }
        composable("dashboard") {
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

