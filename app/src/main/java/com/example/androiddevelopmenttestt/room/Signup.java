package com.example.androiddevelopmenttestt.room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sign_up")
public class Signup {

    @PrimaryKey(autoGenerate = true)
    private int id;
   // @ColumnInfo(name = "note_title")
      private String name;
         private String email;
         private String password;


    public Signup(String title, String description, String priority) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
