package com.example.androiddevelopmenttestt.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddevelopmenttestt.R;
import com.example.androiddevelopmenttestt.ViewModel.SignupViewModel;
import com.example.androiddevelopmenttestt.room.Signup;

public class SignUpActivity extends AppCompatActivity {

    private Button signupButton;
    private TextView txtLogin,name,email,password;
    private SignupViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        signupButton = findViewById(R.id.signupButton);
        txtLogin = findViewById(R.id.txtLogin);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        onClickListner();
    }


    public void onClickListner(){

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if(Name.isEmpty() || Email.isEmpty() || Password.isEmpty()){

                    Toast.makeText(SignUpActivity.this,"Empty field ",Toast.LENGTH_SHORT).show();
                }else{

                    noteViewModel.insertNote(new Signup(Name,Email,Password));

                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}