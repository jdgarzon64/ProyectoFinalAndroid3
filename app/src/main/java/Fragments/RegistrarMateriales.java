package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;

import Model.Controller;
import Model.Material;


public class RegistrarMateriales extends Fragment {

    View view;
    EditText nombreMaterial;
    EditText cantidadMaterial;
    EditText marcaMaterial;
    EditText descripcionMaterial;
    Button registrarMaterial;
    Controller controlador;

    public RegistrarMateriales() {
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
        view = inflater.inflate(R.layout.fragment_registrar_materiales, container, false);
        controlador = new Controller(getActivity());
        nombreMaterial = view.findViewById(R.id.nombreMaterial);
        cantidadMaterial = view.findViewById(R.id.cantidadMaterial);
        marcaMaterial = view.findViewById(R.id.marcaMaterial);
        descripcionMaterial = view.findViewById(R.id.descripcionMaterial);
        registrarMaterial = view.findViewById(R.id.registrarMaterial);
        registrarMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarMaterial(getView());
            }
        });
        return view;
    }

    public void registrarMaterial(View view) {
        if (nombreMaterial.getText().toString().isEmpty()
                || cantidadMaterial.getText().toString().isEmpty()
                || marcaMaterial.getText().toString().isEmpty()
                || descripcionMaterial.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "debe llenar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            String nombre = nombreMaterial.getText().toString();
            String cantidad = cantidadMaterial.getText().toString();
            String marca = marcaMaterial.getText().toString();
            String descripcion = descripcionMaterial.getText().toString();

            Material material = new Material(nombre, cantidad, marca, descripcion, LoginActivity.administrador.getDocumento());

            if (controlador.guardarMaterial(material)) {
                Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_LONG).show();

                limpiarCampos();
            } else {
                Toast.makeText(getContext(), "Error en el registro", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void limpiarCampos(){
        nombreMaterial.setText("");
        cantidadMaterial.setText("");
        marcaMaterial.setText("");
        descripcionMaterial.setText("");
    }
}
