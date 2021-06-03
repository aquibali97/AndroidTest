package com.example.androiddevelopmenttestt.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Signup.class,version = 1,exportSchema = false)
//@Database(entities = {Note.class,User.class},version = 1)
public abstract class SignupDatabase extends RoomDatabase {

    private static SignupDatabase instance;
    public abstract SignupDao NoteDao();


    public static synchronized SignupDatabase getInstance(Context contex){
        if (instance==null) {
            instance = Room.databaseBuilder(contex.getApplicationContext(),
                    SignupDatabase.class,"sign_up"
                    ).fallbackToDestructiveMigration().build();
        }

        return  instance;
    }

}
