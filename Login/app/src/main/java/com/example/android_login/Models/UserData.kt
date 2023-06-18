package com.example.android_login

data class UserData (
    val users: List<User>
)

data class User (
    val id: Long,
    val name: String,
    val email: String,
    val favoriteFood: String,
    val wishlist: List<String>
)
