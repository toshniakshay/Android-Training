package com.example.androidtraining.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidtraining.Models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User... user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("Select * from user_table")
    List<User> getAllUsers();

    @Query("Select * from user_table where email_address LIKE :email LIMIT 1")
    List<User> findUserByEmail(String email);

}
