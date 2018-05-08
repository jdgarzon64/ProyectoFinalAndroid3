package Infraestructure;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Juan David on 19/09/2017.
 */

public class ClsServiceGeneric extends AsyncTask<String, String, String> {

    private StringBuffer buffer = null;
    private String accion;
    //private final String ruta = "http://192.168.1.55/WebServicesAndroid/ConexionOracle.php";
    private String ruta;
    Activity activity;
    ProgressBar carga;
    private String json;
    public AsyncResponse delegate = null;


    public ClsServiceGeneric(String ruta, String json, String accion, Activity activity,
                             ProgressBar carga, AsyncResponse asyncResponse) {

        this.accion = accion;
        this.activity = activity;
        this.carga = carga;
        this.ruta = ruta;
        this.json = json;
        this.delegate = asyncResponse;
    }


    @Override
    protected void onPreExecute() {
        carga.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Toast.makeText(activity, values[0],
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params) {

        HttpURLConnection conn = null;
        BufferedReader reader = null;

        try {

            URL url = new URL(ruta);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            Uri.Builder builder = new Uri.Builder();
                   // .appendQueryParameter("miJson", json)
                   // .appendQueryParameter("accion", accion);
            String query = builder.build().getEncodedQuery();
            /*
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            */
            publishProgress("Conectando al Servidor");
            conn.connect();
            //Thread.sleep(3000);
            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (MalformedURLException e) {
            publishProgress("Error mal estructura URL " + e.getMessage());
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            publishProgress("Error IO " + e.getMessage());
            e.printStackTrace();
            return "";
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                publishProgress("Error al final " + e.getMessage());
                e.printStackTrace();
                return "";
            }
        }
        return "callback!!!";
    }


    @Override
    protected void onPostExecute(String result) {
        try{
            Toast.makeText(activity,result.toString(),Toast.LENGTH_LONG).show();
        delegate.processFinish(buffer.toString());
        carga.setVisibility(View.INVISIBLE);
        /*
        try {
            if (result != "") {
                delegate.processFinish(buffer.toString());
                carga.setVisibility(View.INVISIBLE);

            } else {
                Toast.makeText(activity, "Error en la operacion",
                        Toast.LENGTH_SHORT).show();
            }

            */
        } catch (Exception e) {
            Toast.makeText(activity, "Error en los Datos Ingresados ",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        // carga.setVisibility(View.INVISIBLE);

    }
}
