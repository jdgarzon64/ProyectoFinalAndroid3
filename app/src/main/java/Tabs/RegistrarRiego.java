package Tabs;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;

import java.util.ArrayList;

import Model.Controller;
import Model.Trabajador;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrarRiego extends Fragment {

    Controller controlador;
    Spinner listaTrabajadores;
    Spinner listaMateriales;
    Spinner cantidadMaterial;
    EditText fechaRiego;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_registrar_riego, container, false);
        listaTrabajadores = view.findViewById(R.id.listaTrabajadores);
        listaMateriales = view.findViewById(R.id.listaMateriales);
        cantidadMaterial = view.findViewById(R.id.cantidadMaterial);
        fechaRiego = view.findViewById(R.id.fechaRiego);
        configView(view);
        return view;
    }

    public void configView(View view) {
/*
      //  controlador = new Controller(getActivity());
        fechaNacimientoCliente = (EditText) view.findViewById(R.id.fechaNacimientoCliente);
        fechaNacimientoCliente.setOnTouchListener(new View.OnTouchListener() {

                                                      @Override
                                                      public boolean onTouch(View v, MotionEvent event) {

                                                          if (event.getAction() == MotionEvent.ACTION_UP) {
                                                              Calendar c = Calendar.getInstance();
                                                              int cyear = c.get(Calendar.YEAR);
                                                              int cmonth = c.get(Calendar.MONTH);
                                                              int cday = c.get(Calendar.DAY_OF_MONTH);
                                                              DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                                                                  @Override
                                                                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                                                      fechaNacimientoCliente.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                                                  }
                                                              }, cyear, cmonth, cday);
                                                              datePickerDialog.show();
                                                          }

                                                          return true;

                                                      }
                                                  }

        );

*/
        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.btnGuardarRiego);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        cargarTrabajadores();
    }

    public void cargarTrabajadores() {
        ArrayList<String> nombresUsuarios = new ArrayList<>();

        if (LoginActivity.administrador.getListaTrabajadores() != null || LoginActivity.administrador.getListaTrabajadores().size() > 0) {

            for (Trabajador user : LoginActivity.administrador.getListaTrabajadores()) {
                nombresUsuarios.add(user.getNombre() + " " + user.getApellido());
            }
        } else {
            nombresUsuarios.clear();
            nombresUsuarios.add("No hay trabajadores registrados");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, nombresUsuarios);
        listaTrabajadores.setAdapter(adapter);
    }
}
