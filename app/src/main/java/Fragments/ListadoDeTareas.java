package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.unkwon.tallerencuestas.R;


public class ListadoDeTareas extends Fragment {
ListView listadoDeTareas;
View view;

    public ListadoDeTareas() {
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
        view= inflater.inflate(R.layout.fragment_listado_de_tareas, container, false);
        listadoDeTareas = view.findViewById(R.id.listadoDeTareas);
        return view;
    }
}
