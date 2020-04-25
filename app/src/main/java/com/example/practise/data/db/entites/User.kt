package com.example.practise.data.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(
    var id: Int? = null,
    var name : String? = null,
    var email : String? = null,
    var password : String? = null,
    var eamil_verified_at: String? = null,
    var created_at: String? = null,
    var update_at:String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}