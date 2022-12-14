package com.example.tfg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userNameAdmin = "admin";
    String passwordAdmin = "admin";
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
        Intent intentFPass = new Intent(this, ForgotPw.class);
        startActivity(intentFPass);
    }

    public void registroPlatforms(View view){
        if (view.getId() == R.id.googlelogo){
            Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
            startActivity(googleIntent);
        }
        if (view.getId() == R.id.spotigyloo){
            Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/"));
            startActivity(spotifyIntent);
        }
        if (view.getId() == R.id.soundcloudlogo){
            Intent soundcloudIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://soundcloud.com/"));
            startActivity(soundcloudIntent);
        }
    }

    public boolean isValidMail(CharSequence mail){
        return (!TextUtils.isEmpty(mail) && (Patterns.EMAIL_ADDRESS.matcher(mail).matches()));
    }
}