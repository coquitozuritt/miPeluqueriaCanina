package clases;

    /**
     * Esta clase representa un empleado de una clínica veterinaria.
     */
public class Empleado extends Persona {

    private String nombre;
    private int telefono;
    private Mascota[] historicoMascotas;

    /**
     * Constructor de la clase Empleado.
     *
     * @param nombre            El nombre del empleado.
     * @param telefono          El número de teléfono del empleado.
     * @param historicoMascotas El histórico de mascotas atendidas por el empleado.
     */
    public Empleado(String nombre, int telefono, Mascota[] historicoMascotas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.historicoMascotas = historicoMascotas;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de teléfono del empleado.
     *
     * @return El número de teléfono del empleado.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el histórico de mascotas atendidas por el empleado.
     *
     * @return El histórico de mascotas atendidas por el empleado.
     */
    public Mascota[] getHistoricoMascotas() {
        return historicoMascotas;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el número de teléfono del empleado.
     *
     * @param telefono El número de teléfono del empleado.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece el histórico de mascotas atendidas por el empleado.
     *
     * @param historicoMascotas El histórico de mascotas atendidas por el empleado.
     */
    public void setHistoricoMascotas(Mascota[] historicoMascotas) {
        this.historicoMascotas = historicoMascotas;
    }


    /**
     * Devuelve una cadena de caracteres con los datos del empleado.
     *
     * @return Una cadena de caracteres con los datos del empleado.
     */
    @Override

    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", telefono=" + telefono + ", historicoMascotas=" + historicoMascotas + '}';
    }

}
