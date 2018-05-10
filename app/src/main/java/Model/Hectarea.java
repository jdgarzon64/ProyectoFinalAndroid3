package Model;

public class Hectarea {

    public int idHectarea;
    public String idFoto;
    public int idAdministrador;
    public String latitud;
    public String longitud;
    public String nombre;

    public Hectarea(String idFoto,String nombre, String latitud,String longitud,int idAdministrador) {
        this.idFoto = idFoto;
        this.idAdministrador = idAdministrador;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }

    public int getIdHectarea() {
        return idHectarea;
    }

    public void setIdHectarea(int idHectarea) {
        this.idHectarea = idHectarea;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}