package Tabs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.unkwon.tallerencuestas.R;

import java.util.ArrayList;

import Fragments.GestionHectareas;
import Model.Controller;
import Model.Hectarea;
import Model.Riego;


public class HistorialHectareas extends Fragment {


    Controller controlador;
    EditText historialCultivo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mostrar_historial, container, false);
        controlador = new Controller(getActivity());
        historialCultivo = v.findViewById(R.id.historialCultivo);
        historialCultivo.setEnabled(false);
        cargarHistorial();
        return v;
    }

    public void cargarHistorial() {
        if (Hectareas.hectarea != null) {
            String historial = "";
            ArrayList<Riego> listaDeHectareas = controlador.historialDeRiegos(Hectareas.hectarea.getIdHectarea());
            for (int i = 0; i < listaDeHectareas.size(); i++) {
                historial += "Fecha: "+listaDeHectareas.get(i).getFechaRiego() + " Cant. Material: " + listaDeHectareas.get(i).getCantidadMaterial()+"\n";
            }
            historialCultivo.setText(historial);
        } else {
            historialCultivo.setText("Debe seleccionar una hectarea");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarHistorial();
    }
}
