package clases;

public class Dueno {

    int id;
    private String nombre;
    private String telefono;
    private Mascota[] mascotas;

    // Constructor

    public Dueno(String nombre, String telefono, Mascota[] mascotas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascotas = mascotas;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Mascota[] getMascotas() {
        return mascotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMascotas(Mascota[] mascotas) {
        this.mascotas = mascotas;
    }

    // toString

    @Override

    public String toString() {
        return "Dueno{" + "nombre=" + nombre + ", telefono=" + telefono + ", mascotas=" + mascotas + '}';
    }


}
