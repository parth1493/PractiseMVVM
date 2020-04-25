package com.example.practise.data.network.repsonses

import com.example.practise.data.db.entites.User

data class AuthResponse(
    var isSuccessful: Boolean?,
    var message : String?,
    var user: User?
)