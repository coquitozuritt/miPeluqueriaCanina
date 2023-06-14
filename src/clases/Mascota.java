package clases;

public class Mascota {

    private String raza;
    private String tipoPelo;
    private HistoricoVisitas[] historicoVisitas;
    private Dueno dueno;

    // Constructor

    public Mascota(String raza, String tipoPelo, HistoricoVisitas[] historicoVisitas, Dueno dueno) {
        this.raza = raza;
        this.tipoPelo = tipoPelo;
        this.historicoVisitas = historicoVisitas;
        this.dueno = dueno;
    }

    // Getters y Setters

    public String getRaza() {
        return raza;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public HistoricoVisitas[] getHistoricoVisitas() {
        return historicoVisitas;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public void setHistoricoVisitas(HistoricoVisitas[] historicoVisitas) {
        this.historicoVisitas = historicoVisitas;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    // toString

    @Override

    public String toString() {
        return "Mascota{" + "raza=" + raza + ", tipoPelo=" + tipoPelo + ", historicoVisitas=" + historicoVisitas + ", dueno=" + dueno + '}';
    }



}
