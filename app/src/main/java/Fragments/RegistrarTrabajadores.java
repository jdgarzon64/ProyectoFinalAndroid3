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

import com.example.unkwon.tallerencuestas.R;


public class RegistrarTrabajadores extends Fragment {

    View view;
    EditText nombreTrabajador;
    EditText apellidoTrabajador;
    EditText documentoTrabajador;
    EditText edadTrabajador;
    Button registrarTrabajador;
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
        return view;
    }
}
