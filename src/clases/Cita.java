package clases;

import java.util.Date;

    /**
     * Cita
     *
     * Clase que representa una cita en la peluquería canina
     */
    public class Cita {

        private String fecha;
        private Dueno dueno;
        private Mascota mascota;
        private Empleado empleado;

    /**
     * Constructor de la clase Cita.
     *
     * @param fecha     La fecha de la cita.
     * @param dueno     El dueño de la mascota.
     * @param mascota   La mascota.
     * @param empleado  El empleado que atenderá la cita.
     */
    public Cita(String fecha, Dueno dueno, Mascota mascota, Empleado empleado) {

        this.fecha = fecha;
        this.dueno = dueno;
        this.mascota = mascota;
        this.empleado = empleado;
    }

    /**
     * Obtiene la fecha de la cita.
     *
     * @return La fecha de la cita.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita.
     *
     * @param fecha La fecha de la cita.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el dueño de la mascota.
     *
     * @return El dueño de la mascota.
     */
    public Dueno getDueno() {
        return dueno;
    }

    /**
     * Establece el dueño de la mascota.
     *
     * @param dueno El dueño de la mascota.
     */
    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    /**
     * Obtiene la mascota.
     *
     * @return La mascota.
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Establece la mascota.
     *
     * @param mascota La mascota.
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * Obtiene el empleado que atenderá la cita.
     *
     * @return El empleado que atenderá la cita.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado que atenderá la cita.
     *
     * @param empleado El empleado que atenderá la cita.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    /**
     * Obtiene el nombre del dueño de la mascota.
     *
     * @return El nombre del dueño de la mascota.
     */
    @Override
    public String toString() {
        return "Cita{" + "fecha=" + fecha + ", dueno=" + dueno + ", mascota=" + mascota + ", empleado=" + empleado + '}';
    }


}