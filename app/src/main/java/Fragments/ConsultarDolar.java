package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.R;
import com.google.gson.Gson;

import Infraestructure.AsyncResponse;
import Infraestructure.ClsServiceGeneric;
import Model.Moneda;


public class ConsultarDolar extends Fragment {

    TextView precioDolar;
    View view;
    ProgressBar carga;

    public ConsultarDolar() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_consultar_dolar, container, false);
        precioDolar = view.findViewById(R.id.precioDolar);
        carga = (ProgressBar) view.findViewById(R.id.progressBar);
        carga.setVisibility(View.INVISIBLE);
        cargarValor();
        return view;
    }

    public void cargarValor() {
        ClsServiceGeneric asyncTask = new ClsServiceGeneric("http://apilayer.net/api/live?access_key=0f4a367588adfa114511127a54fa16c5&currencies=COP", "", "", getActivity(), carga, new AsyncResponse() {
            @Override
            public void processFinish(Object o) {
                Gson gson = new Gson();
                Moneda moneda = gson.fromJson(o.toString(),Moneda.class);
                precioDolar.setText(moneda.getQuotes().getUSDCOP()+" Pesos");
            }
        });
        asyncTask.execute();
    }

}