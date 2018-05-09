package Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.unkwon.tallerencuestas.R;
import com.example.unkwon.tallerencuestas.maps.UbicacionHectarea;


public class RegistrarHectarea extends Fragment {
    View view;
    EditText nombreHectarea;
    ImageView fotoHectarea;
    Button agregarUbicacion;
    Button tomarFotoHectarea;
    Button registrarHectarea;
    public RegistrarHectarea() {
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
        view = inflater.inflate(R.layout.fragment_registrar_hectarea, container, false);
        nombreHectarea = view.findViewById(R.id.nombreHectarea);
        fotoHectarea = view.findViewById(R.id.fotoHectarea);
        agregarUbicacion = view.findViewById(R.id.agregarUbicacion);
        tomarFotoHectarea = view.findViewById(R.id.tomarFotoHectarea);
        registrarHectarea = view.findViewById(R.id.registrarHectarea);

        agregarUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarUbicacion(getView());
            }
        });

        return view;
    }


    public void agregarUbicacion(View view){
        Intent i = new Intent(getContext(), UbicacionHectarea.class);
        startActivity(i);
    }


}
