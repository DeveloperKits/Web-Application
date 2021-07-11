package com.samulit.srworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class secondSmsActivity extends AppCompatActivity {

    public void nextPage(View view){
        Intent goToThird = new Intent(secondSmsActivity.this, MainActivity2.class);
        startActivity(goToThird);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sms);

    }
}