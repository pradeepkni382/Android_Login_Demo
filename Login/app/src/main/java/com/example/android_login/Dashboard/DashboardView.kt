package com.example.android_login.Dashboard

import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.android_login.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(navigationController: NavController) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val users = viewModel.getUserDataList().users




    Column {
        TopAppBar(title = { Text(text = "Welcome Back") })
        LazyColumn {
            itemsIndexed(users) { index, user ->
                UserListItem(user = user, navController = navigationController)
                // Add a divider after each item except the last one
                if (index < users.size - 1) {
                    Divider()
                }
            }
        }
    }
}
@Composable
fun UserListItem(user: User, navController: NavController) {
        Column(
            modifier = Modifier
                .clickable {
                    navController.navigate("userDetail/${user.id}")
                }
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = user.name)
            Text(text = "Favorite Food: ${user.favoriteFood}")
            Text(text = "Email: ${user.email}")
        }
//    }
}

@Composable
fun ListItem(user: User) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = user.name)
        Text(text = "Favorite Food: ${user.favoriteFood}")
        Text(text = "Email: ${user.email}")
    }
}
