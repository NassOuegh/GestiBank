package com.example.gestibank.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;
import com.example.gestibank.models.Client;

import java.util.List;

public class ListeDemandesAdapter extends BaseAdapter {
    private List<Client> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListeDemandesAdapter(Context aContext, List<Client> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public List<Client> getListData() {
        return listData;
    }

    public void setListData(List<Client> listData) {
        this.listData = listData;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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
        ListeDemandesAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.demande_item, null);
            holder = new ListeDemandesAdapter.ViewHolder();
            holder.mailView = (TextView)
                    convertView.findViewById(R.id.demandeItemMail);
            holder.nameView = (TextView)
                    convertView.findViewById(R.id.demandeItemName);;
        } else {
            holder = (ListeDemandesAdapter.ViewHolder) convertView.getTag();
        }
        Client client = this.listData.get(position);
        holder.nameView.setText("Nom: " + client.getName());
        holder.mailView.setText("Mail: " + client.getMail());
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        TextView mailView;
    }
}
