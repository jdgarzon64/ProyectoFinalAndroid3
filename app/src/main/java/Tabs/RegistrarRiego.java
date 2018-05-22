package Tabs;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;

import java.util.ArrayList;
import java.util.Calendar;

import Model.Controller;
import Model.Hectarea;
import Model.Material;
import Model.Riego;
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
        configView(view);
        return view;
    }

    public void configView(View view) {
        controlador = new Controller(getActivity());
        listaTrabajadores = view.findViewById(R.id.listaTrabajadores);
        listaMateriales = view.findViewById(R.id.listaMateriales);
        cantidadMaterial = view.findViewById(R.id.cantidadMaterial);
        cantidadMaterial.setEnabled(false);
        fechaRiego = view.findViewById(R.id.fechaRiego);
        fechaRiego = (EditText) view.findViewById(R.id.fechaRiego);
        fechaRiego.setOnTouchListener(new View.OnTouchListener() {

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
                                                          fechaRiego.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                                      }
                                                  }, cyear, cmonth, cday);
                                                  datePickerDialog.show();
                                              }

                                              return true;

                                          }
                                      }

        );


        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.btnGuardarRiego);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarRiego(view);
            }
        });
        cargarTrabajadores();
        cargarMateriales();
        listaMateriales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                Object item = parent.getItemAtPosition(pos);
                Toast.makeText(getContext(), item.toString() + " pos " + pos, Toast.LENGTH_LONG).show();
                cargarCantidad(pos);
                cantidadMaterial.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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

    public void cargarMateriales() {
        ArrayList<String> nombresMateriales = new ArrayList<>();

        if (LoginActivity.administrador.getListaMateriales() != null || LoginActivity.administrador.getListaMateriales().size() > 0) {

            for (Material mat : LoginActivity.administrador.getListaMateriales()) {
                nombresMateriales.add(mat.getNombre());
            }
        } else {
            nombresMateriales.clear();
            nombresMateriales.add("No hay Materiales Registrados");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, nombresMateriales);
        listaMateriales.setAdapter(adapter);
    }

    public void cargarCantidad(int idMat) {
        ArrayList<String> cantidadMateriales = new ArrayList<>();
        int cantidad = controlador.obtenerCantidadMaterial(idMat);
        for (int i = 0; i < cantidad; i++) {
            cantidadMateriales.add((i + 1) + "");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, cantidadMateriales);
        cantidadMaterial.setAdapter(adapter);
    }

    public void guardarRiego(View view) {
        if (listaMateriales.getCount() == 0
                || listaTrabajadores.getCount() == 0
                || cantidadMaterial.getCount() == 0
                ||fechaRiego.getText().toString().isEmpty()
                || Hectareas.hectarea==null) {
          Toast.makeText(getActivity(),"debe llenar todos lso campos",Toast.LENGTH_LONG).show();
        }
        else {
            int idMaterial = listaMateriales.getSelectedItemPosition()+1;
            Trabajador trabajador = LoginActivity.administrador.getListaTrabajadores().get(Long.valueOf(listaTrabajadores.getSelectedItemId()).intValue());
            String cantidadM = cantidadMaterial.getSelectedItem().toString();
            String fecha = fechaRiego.getText().toString();
            int idHectarea = Hectareas.hectarea.getIdHectarea();

            Material material=controlador.buscarMaterial(listaMateriales.getSelectedItem().toString());
            int cantidadAnterior= Integer.parseInt(material.getCantidad());
            int cantidadActual = cantidadAnterior-Integer.parseInt(cantidadM);
            material.setCantidad(String.valueOf(cantidadActual));
            material.setIdMaterial(idMaterial);

            Riego riego = new Riego(idHectarea,trabajador.getDocumento(),idMaterial,fecha,cantidadM,false);

            if(controlador.guardarRiego(riego,material)){
                Toast.makeText(getActivity(),"registro exitoso",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getActivity(),"error en el registro",Toast.LENGTH_LONG).show();
            }
        }
    }


}
