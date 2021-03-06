package com.example.unkwon.tallerencuestas;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
    ArrayList<Riego> listadoDeRiegos = null;
    Controller controlador;
    String tarea = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listado_de_tareas);
        this.listadoDeTareas = (ListView) findViewById(R.id.listaDeTareas);
        controlador = new Controller(this);
        FloatingActionButton atras = (FloatingActionButton) findViewById(R.id.btnAtrasTareas);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        configurarListaTareas();
    }

    public void configurarListaTareas() {

        listadoDeRiegos = controlador.buscarTareas(LoginActivity.trabajador.getDocumento());
       // Toast.makeText(this, "mi tamaño " + listadoDeRiegos.size(), Toast.LENGTH_LONG).show();

        String[] tareas = new String[listadoDeRiegos.size()];
        for (int i = 0; i < listadoDeRiegos.size(); i++) {
            Hectarea hectarea = controlador.buscarHectarea(listadoDeRiegos.get(i).getIdHectarea());
            if (hectarea != null) {
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
                    mostrarTarea(position);
                    crearDialog(position);
                }

            }
        });

    }

    public void crearDialog(final int position) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Tarea asignada");
        alertDialogBuilder.setMessage(tarea);


        AlertDialog.Builder aceptar = alertDialogBuilder.setPositiveButton("terminar tarea", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (controlador.cambiarEstado(listadoDeRiegos.get(position))) {
                    Toast.makeText(getApplicationContext(),"tarea terminada",Toast.LENGTH_LONG).show();
                    dialogInterface.dismiss();
                    configurarListaTareas();

                }
            }
        });
        AlertDialog.Builder cancelar = alertDialogBuilder.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void mostrarTarea(int pos) {
        tarea = listadoDeRiegos.get(pos).toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.listadoDeRiegos.clear();
        this.listadoDeTareas.setAdapter(null);
        configurarListaTareas();
    }
}
