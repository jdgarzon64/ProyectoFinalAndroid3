package Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.MainActivity;
import com.example.unkwon.tallerencuestas.R;

import Model.Administrador;
import Model.Controller;


public class InformacionCuenta extends Fragment {

    static final int CAMERA = 3;
    private Controller controlador;
    View view;
    EditText nombreInformacion;
    EditText apellidoInformacion;
    EditText documentoInformacion;
    EditText nombreFincaInformacion;
    EditText usuarioInformacion;
    EditText passwordInformacion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_informacion_cuenta, container, false);
        nombreInformacion = view.findViewById(R.id.nombreInformacion);
        apellidoInformacion = view.findViewById(R.id.apellidoInformacion);
        documentoInformacion = view.findViewById(R.id.documentoInformacion);
        nombreFincaInformacion = view.findViewById(R.id.nombreFincaInformacion);
        usuarioInformacion = view.findViewById(R.id.usuarioInformacion);
        passwordInformacion = view.findViewById(R.id.passwordInformacion);
        controlador= new Controller(getActivity());

        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.updateInformacion);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarDatos();
                Toast.makeText(getContext(), "Datos Actualizados", Toast.LENGTH_LONG).show();
            }
        });
        cargarDatos();
        return view;
    }

    public void cargarDatos() {
        nombreInformacion.setText(LoginActivity.administrador.getNombre());
        apellidoInformacion.setText(LoginActivity.administrador.getApellido());
        documentoInformacion.setText(LoginActivity.administrador.getDocumento() + "");
        nombreFincaInformacion.setText(LoginActivity.administrador.getNombreFinca());
        usuarioInformacion.setText(LoginActivity.administrador.getUsuario());
        passwordInformacion.setText(LoginActivity.administrador.getPassword());
    }

    public void actualizarDatos() {
        if (nombreInformacion.getText().toString().isEmpty()
                || apellidoInformacion.getText().toString().isEmpty()
                || documentoInformacion.getText().toString().isEmpty()
                || nombreFincaInformacion.getText().toString().isEmpty()
                || usuarioInformacion.getText().toString().isEmpty()
                || passwordInformacion.getText().toString().isEmpty()
                ) {
            Toast.makeText(getContext(), "Debe Llenar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            String nombre = nombreInformacion.getText().toString();
            String apellido = apellidoInformacion.getText().toString();
            int documento = Integer.parseInt(documentoInformacion.getText().toString());
            String nombreFinca = nombreFincaInformacion.getText().toString();
            String usuario = usuarioInformacion.getText().toString();
            String password = passwordInformacion.getText().toString();
            Administrador administrador = new Administrador(documento,nombre,apellido,nombreFinca,usuario,password);
            if(controlador.guardarAdmin(administrador,1)){
                Toast.makeText(getContext(), "se ha actualizado correctamente", Toast.LENGTH_LONG).show();
                MainActivity.profileName.setText(nombre);
                MainActivity.profileApellido.setText(apellido);
            }
        }
    }
}
