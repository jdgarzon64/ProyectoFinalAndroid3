package com.example.unkwon.tallerencuestas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import Fragments.InformacionCuenta;
import Fragments.GestionHectareas;
import Model.Controller;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Controller controlador;
    TextView profileName;
    TextView profileCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // controlador = new Controller(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.MasterPage, new InformacionCuenta()).commit();
        //imageView = (ImageView) findViewById(R.id.imageView);

        askForPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, 1);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        profileName = (TextView) findViewById(R.id.txt1);
        profileCorreo = (TextView) findViewById(R.id.txt2);
       // cargarUserData();
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exportar_datos) {

            return true;
        } else if (id == R.id.enviar_datos) {
            SendFile(this.getCurrentFocus());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void SendFile(View view) {

        File filelocation = new File(getExternalFilesDir(null) + "/HojasDeCalculo/");
        File[] files = filelocation.listFiles();
        ArrayList<Uri> uriList = new ArrayList<Uri>();
        for (int i = 0; i < files.length; i++) {
            Uri path = Uri.fromFile(files[i]);
            uriList.add(path);
        }

        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        emailIntent.setType("vnd.android.cursor.dir/email");
        String to[] = {"jdgarzon64@misena.edu.co"};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_STREAM, uriList);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "body goes here");
        startActivity(Intent.createChooser(emailIntent, "Send email ..."));


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.fragment_gestion_hectareas) {
            fragmentManager.beginTransaction().replace(R.id.MasterPage, new GestionHectareas()).commit();
        } else if (id == R.id.fragment_configuracion) {
            fragmentManager.beginTransaction().replace(R.id.MasterPage, new InformacionCuenta()).commit();
        } else if (id == R.id.fragment_salir) {

            System.exit(0);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int askForPermission(String permit, int requestCode) {

        int res = ContextCompat.checkSelfPermission(MainActivity.this, permit);

        if (res != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permit)) {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permit}, requestCode);

            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permit}, requestCode);
            }
        }

        return res;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    askForPermission(Manifest.permission.CAMERA, 2);

                } else {

                    askForPermission(Manifest.permission.CAMERA, 2);

                }
                return;
            }

            case 2: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            case 3: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    //     askForPermission(Manifest.permission.CAMERA, 3);
                }
                return;
            }

            case 4: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                }
                return;
            }

        }
    }


}
