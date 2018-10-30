package com.example.saravanan.tomtom.Adapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.saravanan.tomtom.MainActivity;
import com.example.saravanan.tomtom.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("firstRun", true);
        editor.apply();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        },2000);

    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);
        if (!firstRun) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Log.d("TAG1", "firstRun(false): " + Boolean.valueOf(firstRun).toString());
        } else {
            Log.d("TAG1", "firstRun(true): " + Boolean.valueOf(firstRun).toString());
        }
    }
}
