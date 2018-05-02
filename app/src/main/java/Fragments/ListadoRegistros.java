package Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.MainActivity;
import com.example.unkwon.tallerencuestas.R;

import java.util.ArrayList;

import Model.Controller;


public class ListadoRegistros extends Fragment {

    ListView listaRegistros;

    Controller controlador;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listado_registros, container, false);
        configView(v);
        return v;
    }

    public void configView(View view){

      //  listaRegistros = (ListView) view.findViewById(R.id.listaRegistros);
      //  controlador = new Controller(getActivity());


    }



}
