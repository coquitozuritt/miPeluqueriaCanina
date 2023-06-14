package clases;

/**
 * Esta clase representa una persona.
 */
public class Persona {

    /**
     * El sexo de la persona.
     */
    private String sexo;

    public Persona(String sexo, String telefono) {
        this.sexo = sexo;
    }

    public Persona() {

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "sexo='" + sexo + '\'' +
                '}';
    }
}
