package com.example.androiddevelopmenttestt.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface SignupDao {

    @Insert
    void insert(Signup note);

    @Update
    void update(Signup note);

    @Delete
    void delete(Signup note);

}
