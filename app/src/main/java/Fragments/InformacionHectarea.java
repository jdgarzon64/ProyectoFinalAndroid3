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

public class InformacionHectarea extends Fragment {
    View view;
    ListView listadoHectareas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_informacion_hectarea, container, false);
        listadoHectareas = view.findViewById(R.id.listadoHectareas);
        configurarListaHectareas();
        return view;
    }


    public void configurarListaHectareas() {
        Toast.makeText(getContext(), "mi tamaño " + LoginActivity.administrador.getListaHectareas().size(), Toast.LENGTH_LONG).show();
        String[] listadoNombres = new String[LoginActivity.administrador.getListaHectareas().size()];
        for (int i = 0; i < listadoNombres.length; i++) {
            listadoNombres[i] = LoginActivity.administrador.getListaHectareas().get(i).getNombre();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listadoNombres);
        listadoHectareas.setAdapter(adapter);
        listadoHectareas.setClickable(true);
        listadoHectareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "!!!!!!!!!!!!!!1", Toast.LENGTH_LONG).show();
                /*
                if (position >= 0) {
                    Toast.makeText(getActivity(), LoginActivity.administrador.getListaHectareas().get(position).getNombre()
                            , Toast.LENGTH_LONG).show();
                }
*/
            }
        });
    }
}
