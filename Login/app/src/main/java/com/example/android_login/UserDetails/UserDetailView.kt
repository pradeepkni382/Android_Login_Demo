package com.example.android_login.UserDetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailView(userId: String, navigationController: NavController) {
    Column {
        TopAppBar(title = { Text(text = "User's preferences") })
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
        {
            Text(text = "UserDetailView \n $userId")
        }
    }

}