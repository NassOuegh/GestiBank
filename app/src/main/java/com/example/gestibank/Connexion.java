package com.example.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.admin.EspaceAdmin;
import com.example.gestibank.client.EspaceClients;
import com.example.gestibank.models.Client;
import com.example.gestibank.models.User;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.UserService;
import com.example.gestibank.remote.clientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Connexion extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.gestibank.EXTRA_NAME";
    public static final String EXTRA_MAIL = "com.example.gestibank.EXTRA_MAIL";

    EditText logintextView;
    EditText pwdtextView;
    String login;
    String pwd;

    UserService userService;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        userService = APIUtils.getUserService();


    }

    public void getUsersLogin(View v){
        try {
            Call<User> call = userService.getUsersMail(login);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        user = response.body();
                        Log.i("Data: ", user.toString());
                        Log.i("pwd: ", pwd);
                        Log.i("Mot de passe: ", user.getPassword());
                        if (user.getPassword().equals(pwd)) {
                            switch (user.getRole()) {
                                case "ADMIN":
                                    callEspaceAdmin(v);
                                    break;
                                case "AGENT":
                                    //callEspaceAgent(v);
                                    break;
                                case "CLIENT":
                                    callEspaceClient(v);
                                    break;
                            }
                        } else {
                            showMessage("Identifiants Erronés", "Mauvais identifiant ou mot de passe.");
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });
        } catch (NullPointerException e) {
            showMessage("Identifiants Erronés", "Mauvais identifiant ou mot de passe.");
        }
    }

    public void callEspaceAdmin(View view) {
        Intent i = new Intent(getApplicationContext(), EspaceAdmin.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
    }

    public void callEspaceClient(View view) {
        String username = user.getName();
        String usermail = user.getMail();

        Intent i = new Intent(getApplicationContext(), EspaceClients.class);
        i.putExtra(EXTRA_NAME, username);
        i.putExtra(EXTRA_MAIL, usermail);
        startActivity(i);
    }

    public void getForm(View v){
        logintextView = (EditText) findViewById(R.id.logintextView);
        pwdtextView = (EditText) findViewById(R.id.pwdtextView);
        login = logintextView.getText().toString();
        pwd = pwdtextView.getText().toString();
        getUsersLogin(v);
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}