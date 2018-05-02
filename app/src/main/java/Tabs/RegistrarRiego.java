package Tabs;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unkwon.tallerencuestas.R;

import Model.Controller;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrarRiego extends Fragment {

    Controller controlador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registrar_riego, container, false);
        configView(v);
        return v;
    }

    public void configView(View view) {
/*
      //  controlador = new Controller(getActivity());
        fechaNacimientoCliente = (EditText) view.findViewById(R.id.fechaNacimientoCliente);
        fechaNacimientoCliente.setOnTouchListener(new View.OnTouchListener() {

                                                      @Override
                                                      public boolean onTouch(View v, MotionEvent event) {

                                                          if (event.getAction() == MotionEvent.ACTION_UP) {
                                                              Calendar c = Calendar.getInstance();
                                                              int cyear = c.get(Calendar.YEAR);
                                                              int cmonth = c.get(Calendar.MONTH);
                                                              int cday = c.get(Calendar.DAY_OF_MONTH);
                                                              DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                                                                  @Override
                                                                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                                                      fechaNacimientoCliente.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                                                  }
                                                              }, cyear, cmonth, cday);
                                                              datePickerDialog.show();
                                                          }

                                                          return true;

                                                      }
                                                  }

        );

*/
        FloatingActionButton update = (FloatingActionButton) view.findViewById(R.id.add);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


    }

}
