package com.example.android_login.UserDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android_login.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserDetailViewModel @Inject constructor() : ViewModel() {
    fun setSelectedUser(user: User) {
        Log.d("UserDetailViewModel","setSelectedUser $user")
    }
}