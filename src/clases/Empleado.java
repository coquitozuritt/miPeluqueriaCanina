package clases;

public class Empleado {

    private String nombre;
    private String telefono;
    private Mascota[] historicoMascotas;

    // Constructor

    public Empleado(String nombre, String telefono, Mascota[] historicoMascotas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.historicoMascotas = historicoMascotas;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Mascota[] getHistoricoMascotas() {
        return historicoMascotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setHistoricoMascotas(Mascota[] historicoMascotas) {
        this.historicoMascotas = historicoMascotas;
    }

    // toString

    @Override

    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", telefono=" + telefono + ", historicoMascotas=" + historicoMascotas + '}';
    }


}
