package com.example.tfg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRegister(View view){
        Intent intentReg = new Intent(this, RegisterWindow.class);
        startActivity(intentReg);
    }

    public void loginProcess(View view){
        Intent intentLog = new Intent(this, Profile.class);
        //if ()
        startActivity(intentLog);
        finishAfterTransition();
    }
    public void forgotPass(View view){
        Intent intentFPass = new Intent(this, loginv2.class);
        startActivity(intentFPass);
    }
}