package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.unkwon.tallerencuestas.R;


public class RegistrarMateriales extends Fragment {

    View view;
    EditText nombreMaterial;
    EditText cantidadMaterial;
    EditText marcaMaterial;
    EditText descripcionMaterial;
    Button registrarMaterial;

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
        nombreMaterial = view.findViewById(R.id.nombreMaterial);
        cantidadMaterial = view.findViewById(R.id.cantidadMaterial);
        marcaMaterial = view.findViewById(R.id.marcaMaterial);
        descripcionMaterial = view.findViewById(R.id.descripcionMaterial);
        registrarMaterial = view.findViewById(R.id.registrarMaterial);
        return view;
    }
}
