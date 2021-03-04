package com.example.gestibank.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;
import com.example.gestibank.models.Client;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AgentService;
import com.example.gestibank.remote.clientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeDemandes extends AppCompatActivity {

    clientService clientService;
    List<Client> list = new ArrayList<>();
    List<Client> clientList = new ArrayList<>();
    Context con = this;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_demandes);
        clientService = APIUtils.getClientService();
        getClientList(listView);
        refresh();
    }

    public void getClientList(View v){
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    clientList = list;
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Client cl : list)
                    {
                        if (cl.getStatus()=="EN ATTENTE") {
                            buffer.append("Nom: " + cl.getName() + "\n");
                            buffer.append("Mail: " + cl.getMail() + "\n");
                            buffer.append("Status: " + cl.getStatus() + "\n\n");
                        }
                    }
                    //showMessage("Agents List", buffer.toString());
                    refresh();
                    //listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void refresh() {
        listView = (ListView) findViewById(R.id.demandes_list_view);
        listView.setAdapter(new ListeDemandesAdapter(con, clientList));
    }
}