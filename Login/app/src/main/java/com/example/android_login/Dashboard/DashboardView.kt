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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
//    val navController = rememberNavController()

    Column {
        Text(text = "Dashboard",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center

        )
        LazyColumn {
            items(users) { user ->
                UserListItem(user = user, navController = navigationController)
            }
        }
    }
}
@Composable
fun UserListItem(user: User, navController: NavController) {
//    Clickable(
//        onClick = {
//            navController.navigate("userDetail/${user.id}")
//        }
//    ) {
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


@HiltViewModel
class UserDetailViewModel @Inject constructor() : ViewModel() {
    fun setSelectedUser(user: User) {
        Log.d("UserDetailViewModel","setSelectedUser $user")
    }
}

@Composable
fun UserDetailView(userId: String, navigationController: NavController) {
    Text(text = "UserDetailView \n $userId")
}