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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import Infraestructure.AsyncResponse;
import Infraestructure.ClsServiceGeneric;
import Model.clima.Clima;
import Model.clima.Converter;


public class ConsultarClima extends Fragment {
    TextView temperatura;
    TextView humedad;
    TextView velocidadViento;
    View view;
    ProgressBar carga;
    Gson gson;
    public ConsultarClima() {
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
        view = inflater.inflate(R.layout.fragment_consultar_clima, container, false);
        temperatura = view.findViewById(R.id.temperatura);
        humedad = view.findViewById(R.id.humedad);
        velocidadViento = view.findViewById(R.id.velocidadViento);
        carga = (ProgressBar) view.findViewById(R.id.progressBar2);
        carga.setVisibility(View.INVISIBLE);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        cargarValor();
        return view;
    }

    public void cargarValor() {
        ClsServiceGeneric asyncTask = new ClsServiceGeneric("http://api.meteoagro.co/v1?apikey=62BLYHT5VCIUVZ6Q9GN4&idstation=COLCAAR75", "", "", getActivity(), carga, new AsyncResponse() {
            @Override
            public void processFinish(Object o) {
                try {
                    Clima  clima = Converter.fromJsonString(o.toString());
                    temperatura.setText(String.valueOf(clima.getCurrentDataClimatic().getTempC()));
                    humedad.setText(String.valueOf(clima.getCurrentDataClimatic().getRelativeHumidity()+"%"));
                    velocidadViento.setText(String.valueOf(clima.getCurrentDataClimatic().getWindGustKmh()+" Km/h"));
                } catch (IOException e) {
                    Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        asyncTask.execute();
    }
}
