package Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.unkwon.tallerencuestas.R;


public class ListadoDeTareas extends AppCompatActivity {
    ListView listadoDeTareas;

    public ListadoDeTareas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listadoDeTareas = (ListView) findViewById(R.id.listadoDeTareas);
    }

}
