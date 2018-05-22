package Model;

public class Riego {
    public int idRiego;
    public int idHectarea;
    public int idTrabajador;
    public int idMaterial;
    public String fechaRiego;
    public String cantidadMaterial;
    public boolean estado;

    public Riego(int idHectarea, int idTrabajador, int idMaterial, String fechaRiego, String cantidadMaterial,boolean estado) {
        this.idHectarea = idHectarea;
        this.idTrabajador = idTrabajador;
        this.idMaterial = idMaterial;
        this.fechaRiego = fechaRiego;
        this.cantidadMaterial = cantidadMaterial;
        this.estado= estado;
    }

    @Override
    public String toString() {
        /*
        return "Riego{" +
                "fechaRiego='" + fechaRiego + '\'' +
                ", cantidadMaterial='" + cantidadMaterial + '\'' +
                '}';
                */
        return "Fecha de Riego: "+fechaRiego+"\n"+ "Cantidad de Material: "+cantidadMaterial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdRiego() {
        return idRiego;
    }

    public void setIdRiego(int idRiego) {
        this.idRiego = idRiego;
    }

    public int getIdHectarea() {
        return idHectarea;
    }

    public void setIdHectarea(int idHectarea) {
        this.idHectarea = idHectarea;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getFechaRiego() {
        return fechaRiego;
    }

    public void setFechaRiego(String fechaRiego) {
        this.fechaRiego = fechaRiego;
    }

    public String getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(String cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

}
