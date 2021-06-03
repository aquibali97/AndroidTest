package com.example.androiddevelopmenttestt.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddevelopmenttestt.R;
import com.example.androiddevelopmenttestt.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cross  = findViewById(R.id.cross);
        TextView login = findViewById(R.id.txtLogin);
        TextView heading  = findViewById(R.id.heading);

        btnLogin = findViewById(R.id.loginButton);

        cross.setVisibility(View.GONE);
        login.setVisibility(View.GONE);

        heading.setText(R.string.login);

        onClickListner();

    }

    public void onClickListner(){

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}