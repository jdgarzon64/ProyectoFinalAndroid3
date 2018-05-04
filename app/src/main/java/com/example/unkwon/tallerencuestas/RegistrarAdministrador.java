package com.example.unkwon.tallerencuestas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarAdministrador extends AppCompatActivity {
    EditText nombrePropietario;
    EditText apellidoAdministrador;
    EditText documentoAdministrador;
    EditText nombreFinca;
    Button registrarAdministrador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_administrador);
        nombrePropietario = (EditText)findViewById(R.id.nombrePropietario);
        apellidoAdministrador = (EditText) findViewById(R.id.apellidoAdministrador);
        documentoAdministrador = (EditText) findViewById(R.id.documentoAdministrador);
        nombreFinca = (EditText) findViewById(R.id.nombreFinca);
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
}
