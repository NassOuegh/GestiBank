package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Connexion extends AppCompatActivity {

    EditText logintextView;
    EditText pwdtextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


    }

    public void getForm(){
        logintextView = (EditText) findViewById(R.id.textView15);
        pwdtextView = (EditText) findViewById(R.id.pwdtextView);
    }
}