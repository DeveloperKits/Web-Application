package com.example.amrshopbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Animation top_Anim, bottom_Anim;
    View logo;
    TextView text;
    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        top_Anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_Anim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logo = (View) findViewById(R.id.logo);
        text = (TextView) findViewById(R.id.text);

        logo.setAnimation(top_Anim);
        text.setAnimation(bottom_Anim);


        // fOR USE FIRST time
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        firstTime = preferences.getBoolean("firstTime", true);

        // new Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstTime) {
                    Intent goToSecond = new Intent(MainActivity.this, secondSmsActivity.class);
                    startActivity(goToSecond);
                    finish();

                    // For fistTime use an Activity
                    SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.apply();
                }else {
                    Intent goToFinal = new Intent(MainActivity.this, FinalActivity.class);
                    startActivity(goToFinal);
                    finish();
                }
            }
        }, 3000);
    }
}