package com.example.practise.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.practise.data.db.entites.CURRENT_USER_ID
import com.example.practise.data.db.entites.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user : User) : Long

    @Query(value = "SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser(): LiveData<User>
}