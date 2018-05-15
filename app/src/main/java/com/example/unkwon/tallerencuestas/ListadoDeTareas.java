package com.example.unkwon.tallerencuestas;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Controller;
import Model.Hectarea;
import Model.Riego;


public class ListadoDeTareas extends AppCompatActivity {
    ListView listadoDeTareas;
    ArrayList<Riego>listadoDeRiegos = null;
    Controller controlador;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listado_de_tareas);
        this.listadoDeTareas = (ListView) findViewById(R.id.listaDeTareas);
        controlador = new Controller(this);
        configurarListaTareas();
    }
    public void configurarListaTareas() {

        listadoDeRiegos = controlador.buscarTareas(LoginActivity.trabajador.getDocumento());
        Toast.makeText(this, "mi tamaño " + listadoDeRiegos.size(), Toast.LENGTH_LONG).show();

        String[] tareas = new String[listadoDeRiegos.size()];
        for (int i = 0; i < listadoDeRiegos.size(); i++) {
            Hectarea hectarea =controlador.buscarHectarea(listadoDeRiegos.get(i).getIdHectarea());
            if(hectarea!=null){
                tareas[i] = hectarea.getNombre();
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tareas);
        this.listadoDeTareas.setAdapter(adapter);
        this.listadoDeTareas.setClickable(true);
        this.listadoDeTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    // MainActivity.indexCiudadano = position;
                    //  FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    // fragmentManager.beginTransaction().replace(R.id.content_main, new RegistrarCiudadanosNav()).commit();
                   // Toast.makeText(getApplicationContext(), LoginActivity.administrador.getListaMateriales().get(position).getNombre() +
                    //        " " + LoginActivity.administrador.getListaMateriales().get(position).getCantidad(), Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
