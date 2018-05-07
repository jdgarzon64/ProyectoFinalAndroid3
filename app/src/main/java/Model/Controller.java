package Model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.unkwon.tallerencuestas.LoginActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Infraestructure.HojaDeCalculo;
import jxl.write.WriteException;

/**
 * Created by unkwon on 19/03/18.
 */

public class Controller {

    Connection pers;
    Activity activity;

    public Controller(Activity activity) {
        pers = new Connection(activity);
        this.activity = activity;
    }

    public Trabajador validarLoginTrabajador(String user, String password) {
        Trabajador trabajador = null;
        String consulta = "select documento, nombre, apellido, edad, usuario, password, idAdministrador" +
                " from trabajadores where usuario = '" + user + "' and password = '" + password + "'";
        Cursor temp = pers.ejecutarSearch(consulta);
        if (temp.getCount() > 0) {
            temp.moveToFirst();
            trabajador = new Trabajador(temp.getInt(0), temp.getString(1),
                    temp.getString(2), temp.getString(3), temp.getString(4), temp.getString(5), temp.getInt(0));
        }
        pers.cerrarConexion();
        return trabajador;
    }


    public Administrador validarLoginAdministrador(String user, String password) {
        Administrador admin = null;
        String consulta = "select documento, nombre, apellido, nombreFinca, usuario, password" +
                " from administradores where usuario = '" + user + "' and password = '" + password + "'";
        Cursor temp = pers.ejecutarSearch(consulta);
        if (temp.getCount() > 0) {
            temp.moveToFirst();
            admin = new Administrador(temp.getInt(0), temp.getString(1),
                    temp.getString(2), temp.getString(3), temp.getString(4), temp.getString(5));
        }
        pers.cerrarConexion();
        return admin;
    }

    public boolean guardarAdmin(Administrador admin, int caso) {
        ContentValues registro = new ContentValues();
        registro.put("documento", admin.getDocumento());
        registro.put("nombre", admin.getNombre());
        registro.put("apellido", admin.getApellido());
        registro.put("nombreFinca", admin.getNombreFinca());
        registro.put("usuario", admin.getUsuario());
        registro.put("password", admin.getPassword());
        switch (caso) {
            case 0:
                return pers.ejecutarInsert("administradores", registro);
            case 1:
                return pers.ejecutarUpdate("administradores", "administradores.documento = " + admin.getDocumento(), registro);
        }
        return false;
    }


    public boolean guardarTrabajador(Trabajador trabajador) {

        ContentValues registro = new ContentValues();

        registro.put("documento", trabajador.getDocumento());
        registro.put("nombre", trabajador.getNombre());
        registro.put("apellido", trabajador.getApellido());
        registro.put("edad", trabajador.getEdad());
        registro.put("usuario", trabajador.getUsuario());
        registro.put("password", trabajador.getPassword());
        registro.put("idAdministrador", trabajador.getIdAdministrador());

        if (buscarTrabajador(trabajador.getDocumento()) == null) {
            LoginActivity.administrador.getListaTrabajadores().add(trabajador);
            return pers.ejecutarInsert("trabajadores", registro);
        }
        return false;

    }
    public Trabajador buscarTrabajador(int documento){
        Trabajador trabajador = null;
        String consulta = "select documento, nombre, apellido, edad, usuario, password, idAdministrador" +
                " from trabajadores where documento = "+documento ;
        Cursor temp = pers.ejecutarSearch(consulta);
        if (temp.getCount() > 0) {
            temp.moveToFirst();
            trabajador = new Trabajador(temp.getInt(0), temp.getString(1),
                    temp.getString(2), temp.getString(3), temp.getString(4), temp.getString(5), temp.getInt(0));
        }
        pers.cerrarConexion();
        return trabajador;
    }
/*
    public boolean guardarCiudadanoInfoLaboral(int documento,
                                               String empresa, String direccionEmpresa,
                                               int cargo, String fotoPath, double salario) {
        ContentValues registro = new ContentValues();
        registro.put("documento", documento);
        registro.put("empresa", empresa);
        registro.put("direccionEmpresa", direccionEmpresa);
        registro.put("cargo", cargo);
        registro.put("fotoPath", fotoPath);
        registro.put("salario", salario);

        return pers.ejecutarUpdate("ciudadano", "ciudadano.documento = " + documento, registro);
    }


    public boolean agregarFamiliar(String nombre, String fechaNacimiento, int parentesco, int documento) {
        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("fechaNacimiento", fechaNacimiento);
        registro.put("parentesco", parentesco + "");
        registro.put("documento", documento + "");
        return pers.ejecutarInsert("familiar", registro);
    }

    public Usuario buscarUsuario() {

        Usuario usuario = null;

        String consulta = "select id, nombre, apellido, correo, proyecto, fotoPath from usuario where id = 0";

        Cursor temp = pers.ejecutarSearch(consulta);

        if (temp.getCount() > 0) {

            temp.moveToFirst();

            usuario = new Usuario(temp.getString(1), temp.getString(2),
                    temp.getString(3), temp.getString(4), temp.getString(5));

            usuario.setId(0);
        }

        pers.cerrarConexion();

        return usuario;
    }

    public ArrayList<Ciudadano> listarCiudadanos() {

        ArrayList<Ciudadano> listaCiudadanos = new ArrayList<>();

        String consultaCiudadanos = "select documento, nombre , apellido , " +
                " fechaNacimiento , tipoDocumento , telefono , genero , direccion , " +
                " empresa , direccionEmpresa, cargo, fotoPath, salario from ciudadano";

        Cursor temp = pers.ejecutarSearch(consultaCiudadanos);

        if (temp.moveToFirst()) {
            do {

                Ciudadano ciudadano = new Ciudadano(temp.getInt(0),
                        temp.getString(1), temp.getString(2), temp.getString(3),
                        temp.getInt(4), temp.getString(5), temp.getString(6),
                        temp.getString(7));

                ciudadano.setEmpresa(temp.getString(8));
                ciudadano.setDireccionEmpresa(temp.getString(9));
                ciudadano.setCargo(temp.getInt(10));
                ciudadano.setFotoPath(temp.getString(11));
                ciudadano.setSalario(temp.getDouble(12));

                ciudadano.setFamiliares(listarFamiliares(ciudadano.getDocumento()));

                listaCiudadanos.add(ciudadano);

            } while (temp.moveToNext());
        }

        return listaCiudadanos;
    }

    public ArrayList<Familiar> listarFamiliares(int documento) {

        ArrayList<Familiar> listaFamiliares = new ArrayList<>();

        String consultaFamiliares = "select id, nombre, fechaNacimiento, parentesco from familiar" +
                " where documento = " + documento;

        Cursor temp = pers.ejecutarSearch(consultaFamiliares);

        if (temp.moveToFirst()) {
            do {

                Familiar familiar = new Familiar(temp.getString(1), temp.getString(2), temp.getString(3));

                familiar.setId(temp.getInt(0));

                listaFamiliares.add(familiar);

            } while (temp.moveToNext());
        }

        return listaFamiliares;
    }

    // hay que mejorarlo
    public Ciudadano buscarCiudadano(int document) {

        String consulta = "select documento, nombre, apellido, " +
                " fechaNacimiento, tipoDocumento, telefono, genero, direccion, " +
                " empresa, direccionEmpresa, cargo, fotoPath, salario from ciudadano where documento = " + document;

        Cursor temp = pers.ejecutarSearch(consulta);

        if (temp.getCount() > 0) {

            temp.moveToFirst();

            Ciudadano ciudadano = new Ciudadano(temp.getInt(0),
                    temp.getString(1), temp.getString(2), temp.getString(3),
                    temp.getInt(4), temp.getString(5), temp.getString(6),
                    temp.getString(7));

            return ciudadano;

        }

        pers.cerrarConexion();

        return null;
    }

    public boolean eliminarFamiliar(int id) {
        String tabla = "familiar";
        String condicion = "familiar.id=" + id;
        return pers.ejecutarDelete(tabla, condicion);
    }

    public boolean eliminarCiudadano(int documento) {
        String tabla = "ciudadano";
        String condicion = "ciudadano.documento=" + documento;
        return pers.ejecutarDelete(tabla, condicion);
    }


    public String generarArchivo(View view) {
        try {


            File filelocation = new File(activity.getExternalFilesDir(null) + "/HojasDeCalculo/");
            File[] files = filelocation.listFiles();
            if(files!=null) {
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }


            ArrayList<Ciudadano> listadoCiudadanos = listarCiudadanos();

            String nombreArchivo = System.currentTimeMillis() + "";
            HojaDeCalculo hojaDeCalculo = new HojaDeCalculo(view.getContext());
            hojaDeCalculo.validarFolder(view.getContext());
            hojaDeCalculo.crearArchivo(nombreArchivo);

            hojaDeCalculo.agregarPestania("Ciudadanos", 0);
            hojaDeCalculo.agregarColumna(0, 0, "Nombre", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(1, 0, "Apellido", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(2, 0, "Documento", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(3, 0, "Tipo de Documento", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(4, 0, "Genero", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(5, 0, "Fecha de Nacimiento", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(6, 0, "Direccion", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(7, 0, "Empresa", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(8, 0, "Direccion Empresa", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(9, 0, "Cargo", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(10, 0, "Salario", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarPestania("Nucleo Familiar", 1);
            hojaDeCalculo.seleccionarPestania(1);
            hojaDeCalculo.agregarColumna(0, 0, "Nombre", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(1, 0, "Fecha de Nacimiento", hojaDeCalculo.getEstiloCabecera());
            hojaDeCalculo.agregarColumna(2, 0, "Parentesco", hojaDeCalculo.getEstiloCabecera());

            for (int i = 0; i < listadoCiudadanos.size(); i++) {
                Ciudadano ciudadano = listadoCiudadanos.get(i);
                ArrayList<Familiar>listaDeFamiliares=listarFamiliares(ciudadano.getDocumento());
                hojaDeCalculo.seleccionarPestania(0);
                hojaDeCalculo.agregarTexto(0, i + 1, ciudadano.getNombre(), null);
                hojaDeCalculo.agregarTexto(1, i + 1, ciudadano.getApellido(), null);
                hojaDeCalculo.agregarNumero(2, i + 1, ciudadano.getDocumento(), null);
                hojaDeCalculo.agregarTexto(3, i + 1, ciudadano.tipoDocumento(ciudadano.getTipoDocumento()), null);
                hojaDeCalculo.agregarTexto(4, i + 1, ciudadano.getGenero(), null);
                hojaDeCalculo.agregarTexto(5, i + 1, ciudadano.getFechaNacimiento(), null);
                hojaDeCalculo.agregarTexto(6, i + 1, ciudadano.getDireccion(), null);
                hojaDeCalculo.agregarTexto(7, i + 1, ciudadano.getEmpresa(), null);
                hojaDeCalculo.agregarTexto(8, i + 1, ciudadano.getDireccionEmpresa(), null);
                hojaDeCalculo.agregarTexto(9, i + 1, ciudadano.cargoCiudadano(ciudadano.getCargo()), null);
                hojaDeCalculo.agregarTexto(10, i + 1, String.valueOf(ciudadano.getSalario()), null);
                hojaDeCalculo.seleccionarPestania(1);
                for(int k=0;k<listaDeFamiliares.size();k++){
                    Familiar familiar=listaDeFamiliares.get(k);
                    hojaDeCalculo.agregarTexto(0, i + 1, familiar.getNombre(), null);
                    hojaDeCalculo.agregarTexto(1, i + 1, familiar.getFechaNacimiento(), null);
                    hojaDeCalculo.agregarTexto(2, i + 1, familiar.parentescoFamiliar(familiar.getParentesco()), null);
                }

            }
            hojaDeCalculo.cerrarArchivo();


        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (WriteException e) {
            return e.getMessage();
        }
        return "Archivo creado correctamente!";
    }

*/
}
