package Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;


public class RegistrarAdministrador extends Fragment {

View view;
EditText nombrePropietario;
EditText apellidoAdministrador;
EditText documentoAdministrador;
EditText nombreFinca;
Button registrarAdministrador;
    public RegistrarAdministrador() {
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
        view = inflater.inflate(R.layout.fragment_registrar_administrador, container, false);
        nombrePropietario = view.findViewById(R.id.nombrePropietario);
        apellidoAdministrador = view.findViewById(R.id.apellidoAdministrador);
        documentoAdministrador = view.findViewById(R.id.documentoAdministrador);
        nombreFinca = view.findViewById(R.id.nombreFinca);
        registrarAdministrador = view.findViewById(R.id.registrarAdministrador);
        FloatingActionButton atras = (FloatingActionButton) view.findViewById(R.id.btnAtras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return  view;
    }


}
