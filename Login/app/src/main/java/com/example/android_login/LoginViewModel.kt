package com.example.android_login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _emailId = MutableStateFlow("")
    val emailId: StateFlow<String> = _emailId.asStateFlow()

    private val _isValidationSuccessful = MutableStateFlow(false)
    val isValidationSuccessful: StateFlow<Boolean> = _isValidationSuccessful

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
            _isValidationSuccessful.value = true
        }
    }
    private fun validateCredentials(): Boolean {
        // Perform validation checks for username and password
        // Return true if validation is successful, otherwise false
        return true
    }

}

