package com.example.android_login.Services

import android.content.Context
import com.example.android_login.Services.Database.Database
import com.example.android_login.Services.NetworkService.NetworkService

object AppContext {
    private lateinit var database: Database
    private lateinit var networkService: NetworkService

    fun initialize(context: Context) {
        database = Database()
        networkService = NetworkService()
    }

    fun getDatabase(): Database {
        return database
    }

    fun getNetworkService(): NetworkService {
        return networkService
    }
}
