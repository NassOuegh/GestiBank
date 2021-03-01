package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callConversion(View view) {
        Intent i = new Intent(getApplicationContext(), Conversion.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }
}