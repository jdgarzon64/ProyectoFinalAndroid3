package com.example.unkwon.tallerencuestas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Administrador;
import Model.Controller;

public class RegistrarAdministrador extends AppCompatActivity {
    EditText nombrePropietario;
    EditText apellidoAdministrador;
    EditText documentoAdministrador;
    EditText nombreFinca;
    EditText usuarioAdministrador;
    EditText passwordAdministrador;
    Button registrarAdministrador;
    Controller controlador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_administrador);
        this.controlador = new Controller(this);
        nombrePropietario = (EditText)findViewById(R.id.nombrePropietario);
        apellidoAdministrador = (EditText) findViewById(R.id.apellidoAdministrador);
        documentoAdministrador = (EditText) findViewById(R.id.documentoAdministrador);
        nombreFinca = (EditText) findViewById(R.id.nombreFinca);
        usuarioAdministrador = (EditText) findViewById(R.id.usuarioAdministrador);
        passwordAdministrador = (EditText) findViewById(R.id.passwordAdministrador);
        registrarAdministrador =(Button) findViewById(R.id.registrarAdministrador);
        FloatingActionButton atras = (FloatingActionButton) findViewById(R.id.btnAtras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });

    }

    public void registrarAdmin (View view){
        if(nombrePropietario.getText().toString().isEmpty()
                || apellidoAdministrador.getText().toString().isEmpty()
                || documentoAdministrador.getText().toString().isEmpty()
                || nombreFinca.getText().toString().isEmpty()
                || usuarioAdministrador.getText().toString().isEmpty()
                || passwordAdministrador.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_LONG).show();
        }
        else {
            String nombre = nombrePropietario.getText().toString();
            String apellido = apellidoAdministrador.getText().toString();
            int documento = Integer.parseInt(documentoAdministrador.getText().toString());
            String nombreF = nombreFinca.getText().toString();
            String usuario = usuarioAdministrador.getText().toString();
            String password = passwordAdministrador.getText().toString();
            Administrador administrador= new Administrador(documento,nombre,apellido,nombreF,usuario,password);

            if(controlador.guardarAdmin(administrador,0)){
                Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_LONG).show();
                limpiarCampos();
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
            else  Toast.makeText(this,"Fallo el registro",Toast.LENGTH_LONG).show();
        }
    }

    public void limpiarCampos(){
        nombrePropietario.setText("");
        apellidoAdministrador.setText("");
        documentoAdministrador.setText("");
        nombreFinca.setText("");
        usuarioAdministrador.setText("");
        passwordAdministrador.setText("");
    }
}
