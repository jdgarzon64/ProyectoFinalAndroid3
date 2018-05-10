package Fragments;

import android.content.Context;
import android.net.Uri;
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
import Model.Trabajador;


public class RegistrarTrabajadores extends Fragment {

    View view;
    EditText nombreTrabajador;
    EditText apellidoTrabajador;
    EditText documentoTrabajador;
    EditText edadTrabajador;
    EditText usuarioTrabajador;
    EditText passwordTrabajador;
    Button registrarTrabajador;
    Controller controlador;

    public RegistrarTrabajadores() {
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
        view = inflater.inflate(R.layout.fragment_registrar_trabajadores, container, false);
        nombreTrabajador = view.findViewById(R.id.nombreTrabajador);
        apellidoTrabajador = view.findViewById(R.id.apellidoTrabajador);
        documentoTrabajador = view.findViewById(R.id.documentoTrabajador);
        edadTrabajador = view.findViewById(R.id.edadTrabajador);
        registrarTrabajador = view.findViewById(R.id.registrarTrabajador);
        usuarioTrabajador = view.findViewById(R.id.usuarioTrabajador);
        passwordTrabajador = view.findViewById(R.id.passwordTrabajador);
        controlador = new Controller(getActivity());
        registrarTrabajador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarTrabajador(getView());
            }
        });
        return view;
    }


    public void registrarTrabajador(View view) {
        if (nombreTrabajador.getText().toString().isEmpty()
                || apellidoTrabajador.getText().toString().isEmpty()
                || documentoTrabajador.getText().toString().isEmpty()
                || usuarioTrabajador.getText().toString().isEmpty()
                || passwordTrabajador.getText().toString().isEmpty()
                || edadTrabajador.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "debe llenar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            String nombre = nombreTrabajador.getText().toString();
            String apellido = apellidoTrabajador.getText().toString();
            String documento = documentoTrabajador.getText().toString();
            String edad = edadTrabajador.getText().toString();
            String usuario = usuarioTrabajador.getText().toString();
            String password = passwordTrabajador.getText().toString();

            Trabajador trabajador = new Trabajador(Integer.parseInt(documento), nombre, apellido, edad,
                    usuario, password, LoginActivity.administrador.documento);

            if (controlador.guardarTrabajador(trabajador)) {
                Toast.makeText(getContext(), "registro exitoso", Toast.LENGTH_LONG).show();
                limpiarCampos();
            }else {
                Toast.makeText(getContext(), "el usuario ya esta registrado", Toast.LENGTH_LONG).show();
            }

        }
    }

    public void limpiarCampos() {
        nombreTrabajador.setText("");
        apellidoTrabajador.setText("");
        edadTrabajador.setText("");
        documentoTrabajador.setText("");
        usuarioTrabajador.setText("");
        passwordTrabajador.setText("");
    }

}
