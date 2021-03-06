package com.example.gestibank.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AgentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeAgents extends AppCompatActivity {

    AgentService agentService;
    List<Agent> list = new ArrayList<>();
    List<Agent> agentList = new ArrayList<>();
    Context con = this;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_agents);
        agentService = APIUtils.getAgentService();
        getAgentList(listView);
        refresh();
// When the user clicks on the ListItem

    }

    public void getAgentList(View v){
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    agentList = list;
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Agent ag : list)
                    {
                        buffer.append("Nom: "+ag.getName()+"\n");
                        buffer.append("Mail: "+ag.getMail()+"\n");
                        buffer.append("Tel:"+ag.getTel()+"\n");
                        buffer.append("Mot de passe :"+ag.getPassword()+"\n");
                        buffer.append("Role:"+ag.getRole()+"\n");
                        buffer.append("Matricule: "+ag.getMatricule()+"\n\n");
                    }
                    //showMessage("Agents List", buffer.toString());
                    refresh();
                     //listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
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
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ListeAgentAdapter(con, agentList));
    }
}