package com.example.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.models.client;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.clientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreationCompte extends AppCompatActivity {

    EditText name;
    EditText tel;
    EditText mail;

    clientService clientService;
    List<client> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
        clientService = APIUtils.getClientService();

        name = (EditText) findViewById(R.id.nameView);
        mail = (EditText) findViewById(R.id.mailView);
        tel = (EditText) findViewById(R.id.telView);

    }

    public void getclientsList(View v){
        Call<List<client>> call = clientService.getClients();
        call.enqueue(new Callback<List<client>>() {
            @Override
            public void onResponse(Call<List<client>> call, Response<List<client>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (client user : list)
                    {
                        buffer.append("Password: "+user.getPassword()+"\n");
                        buffer.append("Name: "+user.getName()+"\n\n");
                        buffer.append("Tel:"+user.getTel()+"\n");
                        buffer.append("Status: "+user.getStatus()+"\n\n");
                        buffer.append("Mail: "+user.getMail()+"\n\n");

                    }
                    showMessage("clients List", buffer.toString());

                    // listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<List<client>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    public void addclient(View v){
        client u = new client("Mohamed Amine", "m@gmail.com", "0651487532");
        Call<client> call = clientService.addClient(u);
        call.enqueue(new Callback<client>() {
            @Override
            public void onResponse(Call<client> call, Response<client> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CreationCompte.this, "client created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<client> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    
    
    public void getForm(View view) {
        name = (EditText) findViewById(R.id.nameView);
        tel = (EditText) findViewById(R.id.telView);
        mail = (EditText) findViewById(R.id.mailView);
        Toast.makeText(CreationCompte.this, name.getText() , Toast.LENGTH_SHORT).show();
    }

    public void callConnexion(View view) {
        Intent i = new Intent(getApplicationContext(), Connexion.class);
        //i.putExtra("Centre", "Global Knowledge");
        //i.putExtra("Cours", "Android");
        startActivity(i);
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