package com.example.android_login.Dashboard

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
    val viewModel = hiltViewModel<DashboardViewModel>()
    Text(text = "This is a dashboard page ${viewModel.getUserDataList()}")
}
