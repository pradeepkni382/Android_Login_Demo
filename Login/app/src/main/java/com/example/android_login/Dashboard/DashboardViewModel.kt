package com.example.android_login.Dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android_login.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.InputStream
import javax.inject.Inject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    private val gson = Gson()
    private val userDataList: UserData

    init {
        val jsonFileName = "user_data.json"
        val inputStream: InputStream = javaClass.classLoader.getResourceAsStream(jsonFileName)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val listType = object : TypeToken<UserData>() {}.type
        userDataList = gson.fromJson(jsonString, listType)
        Log.d("DashboardViewModel","DashboardViewModel - json string is $userDataList")
    }

    fun getUserDataList(): UserData {
        return userDataList
    }
}