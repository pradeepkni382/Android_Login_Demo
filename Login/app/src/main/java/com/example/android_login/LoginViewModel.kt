package com.example.android_login

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {
    private val _emailId = MutableStateFlow("")
    val emailId: StateFlow<String> = _emailId.asStateFlow()

    fun onEmailIDChanged(newEmailID: String) {
        _emailId.value = newEmailID
    }
    private val _passWord = MutableStateFlow("")
    val passWord: StateFlow<String> = _passWord.asStateFlow()

    fun onPasswordChanged(newPassWord: String) {
        _passWord.value = newPassWord
    }



    fun authenticateUser() {
        if (emailId.toString().isNotEmpty() && passWord.toString().isNotEmpty()) {
            Log.d("authenticateUser","authenticateUser ${emailId.value} + with password ${passWord.value}")
        }
    }

}