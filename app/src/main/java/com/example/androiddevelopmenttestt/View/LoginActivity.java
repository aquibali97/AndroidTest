package com.example.androiddevelopmenttestt.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddevelopmenttestt.Database.DBAdapter;
import com.example.androiddevelopmenttestt.R;
import com.example.androiddevelopmenttestt.utilities.SharedPreferenceHelper;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private DBAdapter dbAdapter;
    private TextView email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cross  = findViewById(R.id.cross);
        TextView login = findViewById(R.id.txtLogin);
        TextView heading  = findViewById(R.id.heading);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btnLogin = findViewById(R.id.loginButton);

        cross.setVisibility(View.GONE);
        login.setVisibility(View.GONE);

        heading.setText(R.string.login);

        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

        onClickListner();

    }

    public void onClickListner(){

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if(Email.isEmpty() || Password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Empty field ",Toast.LENGTH_SHORT).show();
                }else {

                    try {

                        if (dbAdapter.Login(Email,Password)) {
                            Toast.makeText(LoginActivity.this,
                                    "Successfully Logged In", Toast.LENGTH_LONG)
                                    .show();

                            SharedPreferenceHelper.setSharedPreferenceString(LoginActivity.this, "email", Email);
                            SharedPreferenceHelper.setSharedPreferenceString(LoginActivity.this, "password", Password);

                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            finishAffinity();
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this,
                                    "Invalid username or password",
                                    Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(LoginActivity.this, "Some problem occurred",
                                Toast.LENGTH_LONG).show();

                    }

                }



//                dbAdapter.Login("abc","abc");
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
            }
        });

    }
}