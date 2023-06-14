package clases;

import java.util.Date;

public class Cita {

    private String fecha;
    private Dueno dueno;
    private Mascota mascota;
    private Empleado empleado;

    // Constructor

    public Cita(String fecha, Dueno dueno, Mascota mascota, Empleado empleado) {
        this.fecha = fecha;
        this.dueno = dueno;
        this.mascota = mascota;
        this.empleado = empleado;
    }

    // Getters y Setters

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // toString

    @Override
    public String toString() {
        return "Cita{" + "fecha=" + fecha + ", dueno=" + dueno + ", mascota=" + mascota + ", empleado=" + empleado + '}';
    }






}