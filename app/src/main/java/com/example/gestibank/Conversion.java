package com.example.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gestibank.models.Rate;
import com.example.gestibank.models.RateName;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.ConversionService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Conversion extends AppCompatActivity {

    ConversionService conversionService;
    Rate ratesList;
    String selectedRate="";
    double taux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        conversionService = APIUtils.getConversionService();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //json.get(GET https://api.exchangeratesapi.io/latest?base=USD HTTP/1.1)

    }

    public void getConversionList(View v){
        Call<Rate> call = conversionService.getConversion();
        call.enqueue(new Callback<Rate>() {
            @Override
            public void onResponse(Call<Rate> call, Response<Rate> response) {
                if(response.isSuccessful()){
                    ratesList = response.body();
                    selectedRate = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
                    //Log.i("Data: ", ratesList.getCurrencyList().get(20).getRate()+"");
                    for (RateName to : ratesList.getCurrencyList()){
                        Log.i("Data2: ", to.toString());
                        //Log.i("Data3: ", to.getName()+"");
                        if(selectedRate.equals(to.getName())){
                            taux=to.getRate();
                            double resultat = Double.parseDouble(((TextView) findViewById(R.id.montant_conversion)).getText().toString())*taux;
                            ((TextView) findViewById(R.id.resultat_conversion)).setText(resultat+"");

                            Log.i("Data", to.getRate() +""+ taux);
                        }
                    }

                    StringBuffer buffer=new StringBuffer();
                    /*for (Double taux : ratesList.getRates())
                    {
                        buffer.append("HKD: "+taux.toString()+"\n");
                        //buffer.append("CAD: "+taux.getDate().toString()+"\n");
                        //buffer.append("USD:"+taux.getBase()).toString()+"\n");
                    }
                    showMessage("Rates List", buffer.toString());*/

                    // listView.setAdapter(new clientAdapter(MainActivity.this, R.layout.list_client, list));
                }
            }

            @Override
            public void onFailure(Call<Rate> call, Throwable t) {
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