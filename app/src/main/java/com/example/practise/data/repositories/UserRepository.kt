package com.example.practise.data.repositories


import com.example.practise.data.db.AppDatabase
import com.example.practise.data.db.entites.User
import com.example.practise.data.network.MyApi
import com.example.practise.data.network.SafeApiRequest
import com.example.practise.data.network.repsonses.AuthResponse


class UserRepository(
    private val myApi: MyApi,
    private val db : AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email : String, password : String) : AuthResponse{
        return apiRequest {   myApi.userLogin(email,password) }
    }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ myApi.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}