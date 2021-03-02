package com.example.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.models.Client;
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
    List<Client> list = new ArrayList<>();

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
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Client user : list)
                    {
                        buffer.append("Password: "+user.getPassword()+"\n");
                        buffer.append("Name: "+user.getName()+"\n");
                        buffer.append("Tel:"+user.getTel()+"\n");
                        buffer.append("Status: "+user.getStatus()+"\n");
                        buffer.append("Mail: "+user.getMail()+"\n\n");

                    }
                    showMessage("clients List", buffer.toString());

                    // listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    public void addclient(View v){
        Client u = new Client(name.getText().toString(), mail.getText().toString(), tel.getText().toString());
        Call<Client> call = clientService.addClient(u);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CreationCompte.this, "client created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    
    
    /*public void getForm(View view) {
        name = (EditText) findViewById(R.id.nameView);
        tel = (EditText) findViewById(R.id.telView);
        mail = (EditText) findViewById(R.id.mailView);
        Toast.makeText(CreationCompte.this, name.getText() , Toast.LENGTH_SHORT).show();
    }*/

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