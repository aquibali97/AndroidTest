package com.example.androiddevelopmenttestt.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.example.androiddevelopmenttestt.repositroy.SignupRepo;
import com.example.androiddevelopmenttestt.room.Signup;

public class SignupViewModel extends AndroidViewModel {

    private SignupRepo signupRepo;

    public SignupViewModel(@NonNull Application application) {
        super(application);

        signupRepo = new SignupRepo(application);
    }

    public void insertNote(Signup note){
        signupRepo.insertNote(note);
    }


}
