package Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;
import com.example.unkwon.tallerencuestas.maps.UbicacionHectarea;

import java.io.File;

import Model.Controller;
import Model.Hectarea;


public class RegistrarHectarea extends Fragment {
    View view;
    EditText nombreHectarea;
    ImageView fotoHectarea;
    Button agregarUbicacion;
    Button tomarFotoHectarea;
    Button registrarHectarea;
    String idFoto = "";
    Controller controlador;

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
        controlador = new Controller(getActivity());

        agregarUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarUbicacion(getView());
            }
        });
        tomarFotoHectarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto(getView());
                recuperarFoto(getView());
            }
        });
        registrarHectarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarHectarea();
            }
        });
        return view;
    }


    public void agregarUbicacion(View view) {
        Intent i = new Intent(getContext(), UbicacionHectarea.class);
        startActivity(i);
    }

    public void tomarFoto(View view) {

        if (nombreHectarea.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "debe llenar todos los campos", Toast.LENGTH_LONG).show();
        } else {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            idFoto = getActivity().getExternalFilesDir(null) + "/" + nombreHectarea.getText().toString() + ".jpg";

            File foto = new File(getActivity().getExternalFilesDir(null), nombreHectarea.getText().toString() + ".jpg");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivityForResult(intent, 1);
        }
    }

    public void recuperarFoto(View view) {

        Bitmap bitmap1 = BitmapFactory.decodeFile(idFoto);
        fotoHectarea.setImageBitmap(bitmap1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        recuperarFoto(getView());
    }

    public void registrarHectarea() {
        if (nombreHectarea.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "debe llenar el nombre de la hectarea", Toast.LENGTH_LONG).show();
        } else {
            if (UbicacionHectarea.latLngActual == null) {
                Toast.makeText(getActivity(), "debe seleccionar una ubicacion en el mapa", Toast.LENGTH_LONG).show();
            } else {
                if(idFoto.equals("")){
                    Toast.makeText(getActivity(), "debe tomar una foto de la hectarea", Toast.LENGTH_LONG).show();
                } else{
                    String nombre = nombreHectarea.getText().toString();
                    //String idFoto, int idAdministrador, String latitud, String longitud, String nombre
                   Hectarea hectarea = new Hectarea(idFoto, nombre,
                    String.valueOf(UbicacionHectarea.latLngActual.latitude),
                           String.valueOf(UbicacionHectarea.latLngActual.longitude),LoginActivity.administrador.getDocumento());

                   if(controlador.guardarHectarea(hectarea)){
                       Toast.makeText(getActivity(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                       nombreHectarea.setText("");
                       LoginActivity.administrador.getListaHectareas().add(hectarea);
                       UbicacionHectarea.latLngActual=null;
                   }
                }
            }
        }
    }
}
