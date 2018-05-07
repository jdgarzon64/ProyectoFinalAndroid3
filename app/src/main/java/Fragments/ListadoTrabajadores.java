package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;
import com.example.unkwon.tallerencuestas.R;


public class ListadoTrabajadores extends Fragment {
    View view;
    ListView listadoTrabajadores;

    public ListadoTrabajadores() {
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
        view = inflater.inflate(R.layout.fragment_listado_trabajadores, container, false);
        listadoTrabajadores = view.findViewById(R.id.listadoTrabajadores);
        configurarListaTrabajadores();
        return view;
    }

    public void configurarListaTrabajadores() {
        Toast.makeText(getContext(), "mi tamaño " + LoginActivity.administrador.getListaTrabajadores().size(), Toast.LENGTH_LONG).show();
        String[] listadoNombres = new String[LoginActivity.administrador.getListaTrabajadores().size()];
        for (int i = 0; i < listadoNombres.length; i++) {
            listadoNombres[i] = LoginActivity.administrador.getListaTrabajadores().get(i).getNombre() + " "
                    + LoginActivity.administrador.getListaTrabajadores().get(i).getApellido();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listadoNombres);
        listadoTrabajadores.setAdapter(adapter);
        listadoTrabajadores.setClickable(true);
        listadoTrabajadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    // MainActivity.indexCiudadano = position;
                    //  FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    // fragmentManager.beginTransaction().replace(R.id.content_main, new RegistrarCiudadanosNav()).commit();
                    Toast.makeText(getContext(), LoginActivity.administrador.getListaTrabajadores().get(position).getNombre() +
                            " " + LoginActivity.administrador.getListaTrabajadores().get(position).getApellido(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
