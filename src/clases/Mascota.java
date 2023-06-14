package clases;

    /**
     * Esta clase representa una mascota.
     */
    public class Mascota {

        private String raza;
        private String tipoPelo;
        private HistoricoVisitas[] historicoVisitas;
        private Dueno dueno;

        /**
         * Constructor de la clase Mascota.
         *
         * @param raza              La raza de la mascota.
         * @param tipoPelo          El tipo de pelo de la mascota.
         * @param historicoVisitas  El historico de visitas de la mascota.
         * @param dueno             El dueño de la mascota.
         *
         */
    public Mascota(String raza, String tipoPelo, HistoricoVisitas[] historicoVisitas, Dueno dueno) {
        this.raza = raza;
        this.tipoPelo = tipoPelo;
        this.historicoVisitas = historicoVisitas;
        this.dueno = dueno;
    }


    /**
     * Obtiene la raza de la mascota.
     *
     * @return La raza de la mascota.
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Obtiene el tipo de pelo de la mascota.
     *
     * @return El tipo de pelo de la mascota.
     */
    public String getTipoPelo() {
        return tipoPelo;
    }

    /**
     * Obtiene el historico de visitas de la mascota.
     *
     * @return El historico de visitas de la mascota.
     */
    public HistoricoVisitas[] getHistoricoVisitas() {
        return historicoVisitas;
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
     * Establece la raza de la mascota.
     *
     * @param raza La raza de la mascota.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Establece el tipo de pelo de la mascota.
     *
     * @param tipoPelo El tipo de pelo de la mascota.
     */
    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    /**
     * Establece el historico de visitas de la mascota.
     *
     * @param historicoVisitas El historico de visitas de la mascota.
     */
    public void setHistoricoVisitas(HistoricoVisitas[] historicoVisitas) {
        this.historicoVisitas = historicoVisitas;
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
     * Devuelve una cadena de caracteres con los datos de la mascota.
     *
     * @return Una cadena de caracteres con los datos de la mascota.
     */
    @Override

    public String toString() {
        return "Mascota{" + "raza=" + raza + ", tipoPelo=" + tipoPelo + ", historicoVisitas=" + historicoVisitas + ", dueno=" + dueno + '}';
    }


}
