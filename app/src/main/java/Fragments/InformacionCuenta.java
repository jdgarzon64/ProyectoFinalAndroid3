package Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;

import Model.Controller;


public class InformacionCuenta extends Fragment {

    static final int CAMERA = 3;
    private Controller controlador;

    Button takeFoto;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_informacion_cuenta, container, false);
        configView(v);
        return v;
    }

    public void configView(View view) {


      //  controlador = new Controller(getActivity());


        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



}
