package com.example.gestibank.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gestibank.CreationCompte;
import com.example.gestibank.R;

public class EspaceAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_admin);
    }

    public void callListeDemandes(View view) {
        Intent i = new Intent(getApplicationContext(), ListeDemandes.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }

    public void callAjoutAgents(View view) {
        Intent i = new Intent(getApplicationContext(), AjoutAgents.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }

    public void callListeAgents(View view) {
        Intent i = new Intent(getApplicationContext(), ListeAgents.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }
}