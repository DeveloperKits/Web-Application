package com.samulit.amrshopbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    public void nextPage(View view){
        Intent goToFinal = new Intent(MainActivity2.this, FinalActivity.class);
        startActivity(goToFinal);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}