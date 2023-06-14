package clases;

public class HistoricoVisitas {
    private Mascota mascota;
    private String fecha;
    private String servicio;
    private String empleado;

    public HistoricoVisitas(Mascota mascota, String fecha, String servicio, String empleado) {
        this.mascota = mascota;
        this.fecha = fecha;
        this.servicio = servicio;
        this.empleado = empleado;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getFecha() {
        return fecha;
    }

    public String getServicio() {
        return servicio;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    @Override

    public String toString() {
        return "HistoricoVisitas{" + "mascota=" + mascota + ", fecha=" + fecha + ", servicio=" + servicio + ", empleado=" + empleado + '}';
    }


}
