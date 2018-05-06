package Model;

import java.util.ArrayList;

public class Administrador {

    public int documento;
    public String nombre;
    public String apellido;
    public String nombreFinca;
    public String usuario;
    public String password;
    ArrayList<Trabajador>listaTrabajadores;
    ArrayList<Trabajador>listaMateriales;
    ArrayList<Trabajador>listaHectareas;

    public Administrador(int documento, String nombre, String apellido, String nombreFinca,String usuario,String password) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreFinca = nombreFinca;
        this.usuario = usuario;
        this.password = password;
        this.listaHectareas= new ArrayList<>();
        this.listaMateriales= new ArrayList<>();
        this.listaTrabajadores= new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public ArrayList<Trabajador> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(ArrayList<Trabajador> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public ArrayList<Trabajador> getListaHectareas() {
        return listaHectareas;
    }

    public void setListaHectareas(ArrayList<Trabajador> listaHectareas) {
        this.listaHectareas = listaHectareas;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }
}
