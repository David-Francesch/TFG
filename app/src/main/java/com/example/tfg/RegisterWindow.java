package com.example.tfg;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class RegisterWindow extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView fechaText;
    int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_window);
        fechaText = findViewById(R.id.editTextDOB);
    }

    public void chooseDate(View view){
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), String.valueOf(R.string.dob));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String dob = DateFormat.getDateInstance().format(c.getTime());
        fechaText.setText(dob);
    }

    public void accept(View view){
        Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show();
    }

    public void cancel(View view){
        Intent cancelIntent = new Intent(this, MainActivity.class);
        startActivity(cancelIntent);
        finishAfterTransition();
    }
}