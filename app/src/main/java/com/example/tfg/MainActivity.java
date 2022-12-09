package com.example.tfg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userNameAdmin = "Admin";
    String passwordAdmin = "Admin.123";
    EditText userNameField;
    EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameField = findViewById(R.id.userField);
        passwordField = findViewById(R.id.passField);

    }

    public void openRegister(View view){
        Intent intentReg = new Intent(this, RegisterWindow.class);
        startActivity(intentReg);
    }

    public void loginProcess(View view){
        Intent intentLog = new Intent(this, Profile.class);
        boolean userNameCorrect = String.valueOf(userNameField.getText()).equals(userNameAdmin);
        boolean passwordCorrect = String.valueOf(passwordField.getText()).equals(passwordAdmin);
        if (userNameCorrect && passwordCorrect){
            startActivity(intentLog);
            finishAfterTransition();
        }
        if ((!userNameCorrect) && (!passwordCorrect)){
            Toast.makeText(this, R.string.incorrectUserPass, Toast.LENGTH_SHORT).show();
        }else if (!userNameCorrect){
            Toast.makeText(this, R.string.incorrectUser, Toast.LENGTH_SHORT).show();
        }else if (!passwordCorrect){
            Toast.makeText(this, R.string.incorrectPass, Toast.LENGTH_SHORT).show();
        }
    }
    public void forgotPass(View view){
        Intent intentFPass = new Intent(this, loginv2.class);
        startActivity(intentFPass);
    }
}