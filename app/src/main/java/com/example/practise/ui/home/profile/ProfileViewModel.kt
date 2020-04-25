package com.example.practise.ui.home.profile

import androidx.lifecycle.ViewModel
import com.example.practise.data.repositories.UserRepository

class ProfileViewModel (
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}