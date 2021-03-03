package com.example.gestibank.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.CreationCompte;
import com.example.gestibank.R;
import com.example.gestibank.models.Agent;
import com.example.gestibank.models.Client;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AgentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjoutAgents extends AppCompatActivity {

    EditText name;
    EditText matricule;
    EditText tel;
    EditText mail;

    AgentService agentService;
    List<Agent> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_agents);
        agentService = APIUtils.getAgentService();

        name = (EditText) findViewById(R.id.EditNom);
        tel = (EditText) findViewById(R.id.EditTel);
        matricule = (EditText) findViewById(R.id.EditMatricule);
        mail = (EditText) findViewById(R.id.EditMail);
    }

    public void getAgentList(View v){
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();
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
                    showMessage("Agents List", buffer.toString());

                    // listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void addAgent(View v){
        Agent u = new Agent(name.getText().toString(), mail.getText().toString(), tel.getText().toString(), matricule.getText().toString());
        Call<Agent> call = agentService.addAgents(u);
        call.enqueue(new Callback<Agent>() {
            @Override
            public void onResponse(Call<Agent> call, Response<Agent> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AjoutAgents.this, "client created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Agent> call, Throwable t) {
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
}