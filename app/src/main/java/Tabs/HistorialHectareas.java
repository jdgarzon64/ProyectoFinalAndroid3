package Tabs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unkwon.tallerencuestas.R;

import Model.Controller;


public class HistorialHectareas extends Fragment {


    Controller controlador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mostrar_historial, container, false);
        configView(v);
        return v;
    }

    public void configView(View view) {


        //controlador = new Controller(getActivity());
        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.saveil);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

}
