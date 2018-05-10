package Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.unkwon.tallerencuestas.R;

import Tabs.Hectareas;
import Tabs.HistorialHectareas;
import Tabs.RegistrarRiego;


public class GestionHectareas extends Fragment {

    private AppBarLayout appBar;

    private TabLayout tabs;

    private ViewPager viewPager;
    ListView listaCultivos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gestion_hectareas, container, false);

        View contenedor = (View) container.getParent();

        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);
        listaCultivos = view.findViewById(R.id.listaCultivos);

        configView(view);

        return view;
    }


    public void configView(View view) {

        tabs = new TabLayout(getActivity());

        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));

        appBar.addView(tabs);

        viewPager = (ViewPager) view.findViewById(R.id.pager);

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        tabs.setupWithViewPager(viewPager);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        String[] tituloTabs = {"Hectareas", "Riego", "Historial"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Hectareas();
                case 1:
                    return new RegistrarRiego();
                case 2:
                    return new HistorialHectareas();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position];
        }
    }


}
