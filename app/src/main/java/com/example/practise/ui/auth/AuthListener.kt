package com.example.practise.ui.auth

import com.example.practise.data.db.entites.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginRepository: User)
    fun onFailure(message: String)
}