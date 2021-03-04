package com.example.gestibank.admin;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;

import java.util.List;

public class ListeAgentAdapter extends BaseAdapter {

    private List<Agent> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListeAgentAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_agent_item, null);
            holder = new ViewHolder();
            holder.mailView = (TextView)
                    convertView.findViewById(R.id.agentItemMail);
            holder.nameView = (TextView)
                    convertView.findViewById(R.id.agentItemName);
            holder.telView = (TextView)
                    convertView.findViewById(R.id.agentItemTel);
            holder.matriculeView = (TextView)
                    convertView.findViewById(R.id.agentItemMatricule);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Agent Agent = this.listData.get(position);
        holder.nameView.setText("Nom: " + Agent.getName());
        holder.mailView.setText("Mail: " + Agent.getMail());
        holder.telView.setText("Tel: " + Agent.getTel());
        holder.matriculeView.setText("Matricule: " + Agent.getMatricule());
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        TextView mailView;
        TextView telView;
        TextView matriculeView;
    }
}

