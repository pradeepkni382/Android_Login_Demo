package com.example.android_login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
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

//@HiltViewModel
//class MyViewModel @Inject constructor() : ViewModel() {
//    private val _textFieldValue = MutableStateFlow("")
//    val textFieldValue: StateFlow<String> = _textFieldValue.asStateFlow()
//
//    fun onButtonClick() {
//        // Perform any desired operations when the button is clicked
//        val value = _textFieldValue.value
//        Log.d("MyViewModel", "Text field value: $value")
//    }
//
//    fun updateTextFieldValue(newValue: String) {
//        _textFieldValue.value = newValue
//    }
//}
