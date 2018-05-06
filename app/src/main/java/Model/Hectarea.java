package Model;

public class Hectarea {

    public int idHectarea;
    public int idFoto;
    public int idAdministrador;

    public Hectarea(int idHectarea, int idFoto, int idAdministrador) {
        this.idHectarea = idHectarea;
        this.idFoto = idFoto;
        this.idAdministrador = idAdministrador;
    }

    public int getIdHectarea() {
        return idHectarea;
    }

    public void setIdHectarea(int idHectarea) {
        this.idHectarea = idHectarea;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
