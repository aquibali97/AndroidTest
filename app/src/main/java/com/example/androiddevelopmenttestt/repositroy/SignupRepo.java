package com.example.androiddevelopmenttestt.repositroy;

import android.app.Application;
import android.os.AsyncTask;

import com.example.androiddevelopmenttestt.room.Signup;
import com.example.androiddevelopmenttestt.room.SignupDao;
import com.example.androiddevelopmenttestt.room.SignupDatabase;

public class SignupRepo {

private SignupDao noteDao;

public SignupRepo(Application application){
    SignupDatabase database = SignupDatabase.getInstance(application);
    noteDao = database.NoteDao();

}

public void insertNote(Signup note){

    new InsertNote(noteDao).execute(note);

}

private static class InsertNote extends AsyncTask<Signup,Void,Void> {

private SignupDao noteDao;

 public InsertNote(SignupDao noteDao){
     this.noteDao = noteDao;
 }
    @Override
    protected Void doInBackground(Signup... notes) {
               noteDao.insert(notes[0]);

        return null;
    }
}


private static class UpdateNote extends  AsyncTask<Signup,Void,Void>{

    private SignupDao noteDao;

    public UpdateNote(SignupDao noteDao){
        this.noteDao = noteDao;
    }
    @Override
    protected Void doInBackground(Signup... notes) {
        noteDao.update(notes[0]);
        return null;
    }
}


private static class DeleteNote extends  AsyncTask<Signup,Void,Void>{

    private SignupDao noteDao;

    public DeleteNote(SignupDao noteDao){
        this.noteDao = noteDao;
    }
    @Override
    protected Void doInBackground(Signup... notes) {
        noteDao.delete(notes[0]);
        return null;
    }
}

}


