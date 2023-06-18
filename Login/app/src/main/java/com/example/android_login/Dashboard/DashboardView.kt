package com.example.android_login.Dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_login.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val users = viewModel.getUserDataList().users
    Column {
        Text(text = "Dashboard",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center

        )
        LazyColumn {
            items(users) { user ->
                ListItem(user = user)
            }
        }
    }
}
@Composable
fun ListItem(user: User) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = user.name)
        Text(text = "Favorite Food: ${user.favoriteFood}")
        Text(text = "Email: ${user.email}")
    }
}
