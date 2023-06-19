package com.example.android_login.UserDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun UserDetailView(userId: String, navigationController: NavController) {
    Text(text = "UserDetailView \n $userId")
}