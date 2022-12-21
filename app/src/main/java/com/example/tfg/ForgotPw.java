package com.example.tfg;

import android.content.Intent;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPw extends MainActivity {

    CharSequence mail;
    EditText etMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpw);
        etMail = findViewById(R.id.userMailInput);
    }

    public void sendMailPassword(View view){
        mail = String.valueOf(etMail.getText());
        if(isValidMail(mail)){
            Toast.makeText(this, "Se ha enviado un correo a la dirección de correo " + mail, Toast.LENGTH_SHORT).show();
            Intent backLogin = new Intent(this, MainActivity.class);
            startActivity(backLogin);
            finishAfterTransition();
        }
        else Toast.makeText(this, "No se ha introducido un mail válido", Toast.LENGTH_SHORT).show();
    }

}