package clases;

    /**
     * Esta clase representa un dueño de mascota.
     */
    public class Dueno extends Persona {
        int id;
        private String nombre;
        private int telefono;
        private Mascota[] mascotas;



        /**
         * Constructor de la clase Dueno.
         *
         * @param nombre            El nombre del dueño.
         * @param telefono          El número de teléfono del dueño.
         * @param mascotas          Las mascotas del dueño.
         */

        public Dueno(String nombre, String telefono, Mascota[] mascotas) {
            super(nombre, telefono);
            this.mascotas = mascotas;

        }

        public Dueno(int id, String nombre, String telefono, Mascota[] mascotas) {
            super(nombre, telefono);
            this.id = id;
            this.mascotas = mascotas;

        }

        public Dueno(int id, String nombre, String telefono) {
            super(nombre, telefono);
            this.id = id;

        }

        public Dueno(String nombre, String telefono) {
            super(nombre, telefono);

        }

        public Dueno() {
            super();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        /**
         * Obtiene el nombre del dueño.
         *
         * @return El nombre del dueño.
         */
        public String getNombre() {
            return nombre;

        }

        /**
         * Obtiene el número de teléfono del dueño.
         *
         * @return El número de teléfono del dueño.
         */

        public int getTelefono() {
            return telefono;

        }

        /**
         * Obtiene las mascotas del dueño.
         *
         * @return Las mascotas del dueño.
         */

        public Mascota[] getMascotas() {
            return mascotas;

        }

        /**
         * Establece el nombre del dueño.
         *
         * @param nombre El nombre del dueño.
         */

        public void setNombre(String nombre) {
            this.nombre = nombre;

        }

        /**
         * Establece el número de teléfono del dueño.
         *
         * @param telefono El número de teléfono del dueño.
         */

        public void setTelefono(int telefono) {
            this.telefono = telefono;

        }

        /**
         * Establece las mascotas del dueño.
         *
         * @param mascotas Las mascotas del dueño.
         */

        public void setMascotas(Mascota[] mascotas) {
            this.mascotas = mascotas;

        }

        @Override

        public String toString() {
            return "Dueno{" +
                    "nombre='" + nombre + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", mascotas=" + mascotas +
                    '}';
        }
    }
