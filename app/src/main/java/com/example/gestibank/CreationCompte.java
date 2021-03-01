package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreationCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
    }

    public void callConnexion(View view) {
        Intent i = new Intent(getApplicationContext(), Connexion.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }
}