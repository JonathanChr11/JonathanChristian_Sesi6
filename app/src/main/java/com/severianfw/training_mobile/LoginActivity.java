package com.severianfw.training_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.severianfw.training_mobile.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    Button login, toRegister;
    EditText loginUsername, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btn_login);
        toRegister = findViewById(R.id.btn_toRegister);
        loginUsername = findViewById(R.id.et_loginUsername);
        loginPassword = findViewById(R.id.et_loginPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(v -> {
            if(!loginUsername.getText().toString().equals(sharedPref.getString("account username", ""))) {
                Toast.makeText(LoginActivity.this, "Username invalid", Toast.LENGTH_SHORT).show();
            } else if(!loginPassword.getText().toString().equals(sharedPref.getString("account password", ""))) {
                Toast.makeText(LoginActivity.this, "Password invalid", Toast.LENGTH_SHORT).show();
            } else if(loginUsername.getText().toString().equals(sharedPref.getString("account username", "")) &&
                    loginPassword.getText().toString().equals(sharedPref.getString("account password", ""))) {
                Toast.makeText(LoginActivity.this, "Password invalid", Toast.LENGTH_SHORT).show();
            }


            Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
            loginIntent.putExtra("account username", sharedPref.getString("account username", ""));
            loginIntent.putExtra("account email", sharedPref.getString("account email", ""));
            startActivity(loginIntent);
        });

        toRegister.setOnClickListener(v -> {
            Intent toRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(toRegisterIntent);
        });

    }
}