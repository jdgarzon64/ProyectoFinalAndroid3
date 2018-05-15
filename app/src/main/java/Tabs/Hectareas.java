package Tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;

import Fragments.GestionHectareas;
import Model.Controller;
import Model.Hectarea;


public class Hectareas extends Fragment {

    View view;
    ListView listadoHectareas;
    public static Hectarea hectarea = null;


    Controller controlador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_listar_hectareas, container, false);
        listadoHectareas = view.findViewById(R.id.listadoHectareas);
        configurarListaHectareas();
        return view;
    }


    public void configurarListaHectareas() {
        Toast.makeText(getContext(), "mi tamaño " + LoginActivity.administrador.getListaHectareas().size(), Toast.LENGTH_LONG).show();
        String[] listadoNombres = new String[LoginActivity.administrador.getListaHectareas().size()];
        for (int i = 0; i < listadoNombres.length; i++) {
            listadoNombres[i] = LoginActivity.administrador.getListaHectareas().get(i).getNombre();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, listadoNombres);
        listadoHectareas.setAdapter(adapter);
        listadoHectareas.setClickable(true);
        listadoHectareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Hectarea "+ LoginActivity.administrador.getListaHectareas().get(i).getNombre() + " seleccionada", Toast.LENGTH_LONG).show();
                hectarea =LoginActivity.administrador.getListaHectareas().get(i);
                GestionHectareas.viewPager.setCurrentItem(1);
            }
        });

    }
}
