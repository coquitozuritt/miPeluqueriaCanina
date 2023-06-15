package connexion;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static log.Logs.LOGGER;

public class Conexionbd {

    /**
     * Scanner para leer datos de la consola.
     */
    static Scanner sc = new Scanner(System.in);

    // Logger para el registro de consultas
    private static final Logger LOGGER = Logger.getLogger(Conexionbd.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("consulta.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.severe("Error al inicializar el archivo de registro: " + e.getMessage());
        }
    }
    /**
     * Conexión con la base de datos.
     */
    static private Connection conexion;

    /**
     * Método principal.
     *
     */
    public static void conectar() {
        /**
        * Conexión con la base de datos.
        */
        try {
            String basedatos = "mipelu";
            String host = "localhost";
            String port = "3307";
            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
            String user = "root";
            String pwd = "root";

            conexion = DriverManager.getConnection(urlConnection, user, pwd);

            conexion.setAutoCommit(true);
            /**
             * Si no se ha producido ningún error, se muestra un mensaje indicando que la
             */

            // Registro de la consulta de conexión
            LOGGER.info("Conexión establecida con la base de datos");
        } catch (SQLException e) {
            /**
             * Se muestra un mensaje de error indicando que no se ha podido establecer la
             * conexión con la base de datos.
             */
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * Método que cierra la conexión con la base de datos.
     */
    public static void desconectar() {
        try {
            conexion.close();
        // Registro de la consulta de desconexión
        LOGGER.info("Conexión cerrada con la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al desconectar con la base de datos");
            e.printStackTrace();
        }
    }

    //buscar dueno  por telefono
    /**
     * Método que permite buscar un dueño por su teléfono.
     */
    public static void buscarDueno() {
        conectar();
        System.out.println("Introduce el telefono del dueño");
        int telefono = Integer.parseInt(sc.nextLine());
        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM dueño WHERE telefono='" + telefono + "'";
            ResultSet rs = st.executeQuery(sql);

            // Registro de la consulta de búsqueda
            LOGGER.info("Consulta de búsqueda de dueño por teléfono");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") + " Telefono: " + rs.getInt("telefono"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar dueño");
            e.printStackTrace();

            // Registro del error en la consulta de búsqueda de dueño
            LOGGER.log(Level.SEVERE, "Error al buscar dueño", e);
        }
    }


    //buscar empleado por telefono
    /**
     * Método que permite buscar un empleado por su teléfono.
     */
    public static void buscarEmpleado() {
        conectar();
        System.out.println("Introduce el telefono del empleado");
        int telefono = Integer.parseInt(sc.nextLine());
        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM empleado WHERE telefono='" + telefono + "'";
            ResultSet rs = st.executeQuery(sql);

            //registro de la consulta de búsqueda
            LOGGER.info("Consulta de búsqueda de empleado por teléfono");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") + " Telefono: " + rs.getInt("telefono"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar empleado");
            e.printStackTrace();

            //registro del error en la consulta de búsqueda de empleado
            LOGGER.log(Level.SEVERE, "Error al buscar empleado", e);

        }
    }

    //buscar mascota por nombre y por nombre del dueño
    /**
     * Método que permite buscar una mascota por su nombre y el nombre de su dueño.
     */
    public static void buscarMascota(){
        conectar();

        // buscar mascota por nombre y raza

        System.out.println("Introduce el nombre de la mascota");
        String nombre = sc.nextLine();

        System.out.println("Introduce la raza de la mascota");
        String raza = sc.nextLine();

        try{
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM mascota WHERE nombre='" + nombre + "' AND raza='" + raza + "'";
            ResultSet rs = st.executeQuery(sql);

            //registro de la consulta de búsqueda
            LOGGER.info("Consulta de búsqueda de mascota por nombre y raza");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") + " Raza: " + rs.getString("raza"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar su mascota");
            e.printStackTrace();

            //registro del error en la consulta de búsqueda de mascota
            LOGGER.log(Level.SEVERE, "Error al buscar su mascota", e);

        }
    }


    //ver citas por id, fecha, dueño_id, mascota_id, empleado_id
    /**
     * Método que permite ver las citas por su id, fecha, dueño_id, mascota_id y empleado_id.
     */
    public static void verCitas() {
        conectar();
        System.out.println("Introduce el id de la cita");
        int id = sc.nextInt();
        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM cita WHERE id='" + id + "'";
            ResultSet rs = st.executeQuery(sql);

            //registro de la consulta de búsqueda
            LOGGER.info("Consulta de búsqueda de cita por id");


            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + " Fecha: " + rs.getString("fecha") + " Dueño_id: " + rs.getInt("dueño_id") + " Mascota_id: " + rs.getInt("mascota_id") + " Empleado_id: " + rs.getInt("empleado_id"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar cita");
            e.printStackTrace();

            //registro del error en la consulta de búsqueda de cita
            LOGGER.log(Level.SEVERE, "Error al buscar cita", e);
        }
    }

    // crear dueno con id, nombre y telefono y el nombre de la mascota
    /**
     * Método que permite crear un dueño con su id, nombre, telefono y crear su propia mascota.
     */
    public static void crearDueno() {
        conectar();

        System.out.println("Introduce el nombre del dueño");
        String nombre = sc.nextLine();
        System.out.println("Introduce el telefono del dueño");
        int telefono = sc.nextInt();
        System.out.println("Introduce el nombre de la mascota");
        String mascota = sc.nextLine();
        System.out.println("Introduce la raza de la mascota");
        String raza = sc.nextLine();
        System.out.println("Introduce el tipo de pelo de la mascota");
        String tipopelo = sc.nextLine();

        try {

            Statement st = conexion.createStatement();

            String sql1 = "INSERT INTO dueño (nombre, telefono) VALUES ('" + nombre + "','" + telefono + "')";
            st.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            // Obtener el id del dueño recién creado
            int idDueno = 0;
            if (rs.next()) {
                idDueno = rs.getInt(1);
            }
            // Registro de la creación del dueño
            LOGGER.info("Dueño creado con id: " + idDueno);


            // Insertar datos de la mascota asociada al dueño
            String sql2 = "INSERT INTO mascota (nombre, raza, tipo_pelo, dueño_id) VALUES ('" + mascota + "', '" + raza + "','" + tipopelo + "'," + idDueno + ")";
            st.executeUpdate(sql2);

            // Registro de la creación de la mascota
            LOGGER.info("Mascota creada con nombre: " + mascota);

            System.out.println("Dueño y mascota creados exitosamente.");

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al crear dueño");
            e.printStackTrace();

            //registro del error en la consulta de creación de dueño
            LOGGER.log(Level.SEVERE, "Error al crear dueño", e);

        }
    }

    //crear empleado con nombre y telefono
    /**
     * Método que permite crear un empleado con su nombre y telefono.
     */
    public static void crearEmpleado() {
        conectar();

        System.out.println("Introduce el nombre del empleado");
        String nombre = sc.nextLine();
        System.out.println("Introduce el telefono del empleado");
        int telefono = Integer.parseInt(sc.nextLine());

        try {

            Statement st = conexion.createStatement();
            String sql = "INSERT INTO empleado (nombre, telefono) VALUES ('" + nombre + "','" + telefono + "')";
            st.executeUpdate(sql);

            //registro de la creación del empleado
            LOGGER.info("Empleado creado con nombre: " + nombre);

            System.out.println("Empleado creado exitosamente.");

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al crear empleado");
            e.printStackTrace();

            //registro del error en la consulta de creación de empleado
            LOGGER.log(Level.SEVERE, "Error al crear empleado", e);
        }
    }


    // editar dueño por telefono
    /**
     * Método que permite editar un dueño por su telefono.
     */
    public static void editarDueno() {
        conectar();

        System.out.println("Introduce el telefono del dueño");
        int telefono = Integer.parseInt(sc.nextLine());

        try {
            Statement st = conexion.createStatement();

            // Verificar si el dueño existe en la base de datos
            String sql1 = "SELECT * FROM dueño WHERE telefono = '" + telefono + "'";
            ResultSet rs = st.executeQuery(sql1);

            // Registro de la consulta de búsqueda del dueño
            LOGGER.info("Consulta de búsqueda de dueño por telefono");

            if (rs.next()) {
                System.out.println("Dueño encontrado.");
                System.out.println("Elige el campo a editar:");
                System.out.println("1. Nombre");
                System.out.println("2. Telefono");

                int opcion = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea después de leer el entero

                if (opcion == 1) {
                    System.out.println("Introduce el nuevo nombre del dueño");
                    String nuevoNombre = sc.nextLine();

                    // Actualizar el nombre del dueño
                    String sql2 = "UPDATE dueño SET nombre = '" + nuevoNombre + "' WHERE telefono = '" + telefono + "'";
                    st.executeUpdate(sql2);

                    // Registro de la actualización del nombre del dueño
                    LOGGER.info("Actualización del nombre del dueño");

                    System.out.println("Nombre del dueño editado exitosamente.");
                } else if (opcion == 2) {
                    System.out.println("Introduce el nuevo telefono del dueño");
                    int nuevoTelefono = Integer.parseInt(sc.nextLine());

                    // Actualizar el telefono del dueño
                    String sql3 = "UPDATE dueño SET telefono = '" + nuevoTelefono + "' WHERE telefono = '" + telefono + "'";
                    st.executeUpdate(sql3);

                    // Registro de la actualización del telefono del dueño
                    LOGGER.info("Actualización del telefono del dueño");

                    System.out.println("Telefono del dueño editado exitosamente.");
                } else {
                    System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("No se encontró un dueño con el telefono proporcionado.");
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al editar dueño");
            e.printStackTrace();

            // Registro del error en la consulta de edición del dueño
            LOGGER.log(Level.SEVERE, "Error al editar dueño", e);
        }
    }

    //editar empleado por telefono
    /**
     * Método que permite editar un empleado por su telefono.
     */
    public static void editarEmpleado(){
        conectar();

        System.out.println("Introduce el telefono del empleado");
        int telefono = Integer.parseInt(sc.nextLine());

        try{
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Verificar si el empleado existe en la base de datos
            String sql1 = "SELECT * FROM empleado WHERE telefono = '" + telefono + "'";
            ResultSet rs = st.executeQuery(sql1);

            // Registro de la consulta de búsqueda del empleado
            LOGGER.info("Consulta de búsqueda de empleado por telefono");

            if (rs.next()) {
                System.out.println("Empleado encontrado.");
                System.out.println("Elige el campo a editar:");
                System.out.println("1. Nombre");
                System.out.println("2. Telefono");

                int opcion = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea después de leer el entero

                if (opcion == 1) {
                    System.out.println("Introduce el nuevo nombre del empleado");
                    String nuevoNombre = sc.nextLine();

                    // Actualizar el nombre del empleado
                    String sql2 = "UPDATE empleado SET nombre = '" + nuevoNombre + "' WHERE telefono = '" + telefono + "'";
                    st.executeUpdate(sql2);

                    // Registro de la actualización del nombre del empleado
                    LOGGER.info("Actualización del nombre del empleado");

                    System.out.println("Nombre del empleado editado exitosamente.");
                } else if (opcion == 2) {
                    System.out.println("Introduce el nuevo telefono del empleado");
                    int nuevoTelefono = Integer.parseInt(sc.nextLine());

                    // Actualizar el telefono del empleado
                    String sql3 = "UPDATE empleado SET telefono = '" + nuevoTelefono + "' WHERE telefono = '" + telefono + "'";
                    st.executeUpdate(sql3);

                    // Registro de la actualización del telefono del empleado
                    LOGGER.info("Actualización del telefono del empleado");

                    System.out.println("Telefono del empleado editado exitosamente.");
                } else {
                    System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("No se encontró un empleado con el telefono proporcionado.");
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al editar empleado");
            e.printStackTrace();

            // Registro del error en la consulta de edición del empleado
            LOGGER.log(Level.SEVERE, "Error al editar empleado", e);
        }
    }

    //borrar un empleado pidiendole el telefono
    /**
     * Método que permite borrar un empleado pidiendole el telefono.
     */
    public static void borrarEmpleado() {
        conectar();

        try{

        System.out.println("Introduce el telefono del empleado");
        int telefono = Integer.parseInt(sc.nextLine());
        //borrar un empleado pidiendole el telefono
        Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String sql = "DELETE FROM empleado WHERE telefono = '" + telefono + "'";
        st.executeUpdate(sql);
        System.out.println("Empleado borrado exitosamente.");

        // Registro de la eliminación del empleado
        LOGGER.info("Eliminación del empleado");

        st.close();
    }catch (SQLException e) {
        System.out.println("Error al borrar empleado");
        e.printStackTrace();

        // Registro del error en la consulta de eliminación del empleado
        LOGGER.log(Level.SEVERE, "Error al borrar empleado", e);
    }
    }

    //borrar dueño pidiendole el telefono
    /**
     * Método que permite borrar un dueño pidiendole el telefono.
     */
    public static void borrarDueno(){
        conectar();

        try{
            System.out.println("Introduce el telefono del dueño");
            int telefono = Integer.parseInt(sc.nextLine());
            //borrar un dueño pidiendole el telefono
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "DELETE FROM dueño WHERE telefono = '" + telefono + "'";
            st.executeUpdate(sql);

            // Registro de la eliminación del dueño
            LOGGER.info("Eliminación del dueño");

            System.out.println("Dueño borrado exitosamente.");

            st.close();
        }catch (SQLException e) {
            System.out.println("Error al borrar dueño");
            e.printStackTrace();

            // Registro del error en la consulta de eliminación del dueño
            LOGGER.log(Level.SEVERE, "Error al borrar dueño", e);
        }
    }

    // consultar citas por el empleado , telefono del dueño y nombre de la mascota
    /**
     * Método que permite consultar citas por el empleado , telefono del dueño y nombre de la mascota.
     */
    public static void adminCitas() {
        conectar();

        System.out.println("Introduce la fecha (en formato 'yyyy-MM-dd'):");
        String fecha = sc.nextLine();

        try {
            //Statement st = conexion.createStatement();

            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Obtener las citas correspondientes a la fecha especificada
            String sql = "SELECT Cita.id, Dueño.nombre AS dueño, Empleado.nombre AS empleado, Mascota.nombre AS mascota FROM Cita " +
                    "INNER JOIN Dueño ON Cita.dueño_id = Dueño.id " +
                    "INNER JOIN Empleado ON Cita.empleado_id = Empleado.id " +
                    "INNER JOIN Mascota ON Cita.mascota_id = Mascota.id " +
                    "WHERE Cita.fecha = '" + fecha + "'";
            ResultSet rs = st.executeQuery(sql);

            // Registro de la consulta de citas
            LOGGER.info("Consulta de citas");


            System.out.println("Citas para la fecha " + fecha + ":");
            System.out.println("ID\tDueño\t\tEmpleado\tMascota");
            System.out.println("---------------------------------------------");
            int count = 0;
            while (rs.next()) {
                count++;
                int id = rs.getInt("id");
                String dueño = rs.getString("dueño");
                String empleado = rs.getString("empleado");
                String mascota = rs.getString("mascota");

                System.out.println(count + "\t" + dueño + "\t" + empleado + "\t" + mascota);
            }

            if (count == 0) {
                System.out.println("No se encontraron citas para la fecha especificada.");
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Elige la cita que deseas ver, modificar o borrar (1-" + count + "):");
                int opcion = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea después de leer el entero

                if (opcion >= 1 && opcion <= count) {
                    // Obtener la cita seleccionada
                    rs.absolute(opcion);
                    int idCita = rs.getInt("id");
                    String dueño = rs.getString("dueño");
                    String empleado = rs.getString("empleado");
                    String mascota = rs.getString("mascota");

                    System.out.println("Cita seleccionada:");
                    System.out.println("ID: " + idCita);
                    System.out.println("Dueño: " + dueño);
                    System.out.println("Empleado: " + empleado);
                    System.out.println("Mascota: " + mascota);

                    // Mostrar opciones para modificar, ver o borrar la cita
                    System.out.println("Elige una opción:");
                    System.out.println("1. Modificar cita");
                    System.out.println("2. Ver detalles de la cita");
                    System.out.println("3. Borrar cita");

                    int opcion2 = sc.nextInt();
                    sc.nextLine(); // Consumir la nueva línea después de leer el entero

                    switch (opcion2) {
                        case 1:
                            // Llamar al método para modificar la cita
                            modificarCita(idCita);
                            break;
                        case 2:
                            // Llamar al método para ver los detalles de la cita
                            verDetallesCita(idCita);
                            break;
                        case 3:
                            // Llamar al método para borrar la cita
                            borrarCita(idCita);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } else {
                    System.out.println("Opción inválida.");
                }
            }

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener las citas");
            e.printStackTrace();

            // Registro del error en la consulta de citas
        }

    }

    /**
     * Método que permite modificar una cita.
     * @param idCita ID de la cita a modificar
     */
    public static void modificarCita(int idCita) {
        conectar();

        // Implementa aquí la lógica para modificar la cita con el ID proporcionado
        // Puedes solicitar al usuario los nuevos datos y actualizar la cita en la base de datos

        try {
            Statement st = conexion.createStatement();

            // Ejemplo de actualización de la fecha de la cita
            System.out.println("Introduce la nueva fecha de la cita (en formato 'yyyy-MM-dd'):");
            String nuevaFecha = sc.nextLine();

            String sql = "UPDATE Cita SET fecha = '" + nuevaFecha + "' WHERE id = " + idCita;
            st.executeUpdate(sql);

            // Registro de la modificación de la cita
            LOGGER.info("Modificación de la cita");

            System.out.println("Cita modificada exitosamente.");

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar la cita");
            e.printStackTrace();

            // Registro del error en la modificación de la cita
            LOGGER.info("error al modificar la cita");
        }
    }

    /**
     * Método que permite ver los detalles de una cita.
     * @param idCita ID de la cita a mostrar
     */
    public static void verDetallesCita(int idCita) {
        conectar();

        try {
            Statement st = conexion.createStatement();

            String sql = "SELECT c.id, c.fecha, d.nombre AS dueno, m.nombre AS mascota, e.nombre AS empleado" +
                    " FROM Cita c" +
                    " INNER JOIN Dueño d ON c.dueño_id = d.id" +
                    " INNER JOIN Mascota m ON c.mascota_id = m.id" +
                    " INNER JOIN Empleado e ON c.empleado_id = e.id" +
                    " WHERE c.id = " + idCita;

            // Ejemplo de consulta de los detalles de la cita
            LOGGER.info("detalles de la cita");

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                String dueno = rs.getString("dueno");
                String mascota = rs.getString("mascota");
                String empleado = rs.getString("empleado");

                System.out.println("Detalles de la cita:");
                System.out.println("ID: " + id);
                System.out.println("Fecha: " + fecha);
                System.out.println("Dueño: " + dueno);
                System.out.println("Mascota: " + mascota);
                System.out.println("Empleado: " + empleado);
            } else {
                System.out.println("No se encontró la cita con el ID especificado.");
            }

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los detalles de la cita");
            e.printStackTrace();

            // Registro del error en la consulta de los detalles de la cita
            LOGGER.info("error al obtener los detalles de la cita");
        }
    }

    /**
     * Método que permite borrar una cita.
     * @param idCita ID de la cita a borrar
     */
    public static void borrarCita(int idCita) {
        conectar();

        try {
            Statement st = conexion.createStatement();

            // Borrar la cita con el ID proporcionado
            String sql = "DELETE FROM Cita WHERE id = " + idCita;
            st.executeUpdate(sql);

            // Registro del borrado de la cita
            LOGGER.info("borrado de la cita");

            System.out.println("Cita borrada exitosamente.");

            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar la cita");
            e.printStackTrace();

            // Registro del error en el borrado de la cita
            LOGGER.info("error al borrar la cita");
        }
    }

    // añadir cita
    /**
     * Método que permite añadir una cita.
     */
    public static void anadirCita() {
        conectar();

        try {
            // Buscar empleado por nombre
            System.out.println("Introduce el nombre del empleado:");
            String nombreEmpleado = sc.nextLine();

            String sqlEmpleado = "SELECT id FROM Empleado WHERE nombre = ?";
            PreparedStatement stmtEmpleado = conexion.prepareStatement(sqlEmpleado);
            stmtEmpleado.setString(1, nombreEmpleado);
            ResultSet rsEmpleado = stmtEmpleado.executeQuery();


            int idEmpleado;
            if (rsEmpleado.next()) {
                idEmpleado = rsEmpleado.getInt("id");
            } else {
                System.out.println("No se encontró ningún empleado con ese nombre.");
                stmtEmpleado.close();
                rsEmpleado.close();
                return;
            }

            stmtEmpleado.close();
            rsEmpleado.close();

            // Buscar dueño por teléfono
            System.out.println("Introduce el teléfono del dueño:");
            String telefonoDueño = sc.nextLine();

            String sqlDueño = "SELECT id FROM Dueño WHERE telefono = ?";
            PreparedStatement stmtDueño = conexion.prepareStatement(sqlDueño);
            stmtDueño.setString(1, telefonoDueño);
            ResultSet rsDueño = stmtDueño.executeQuery();

            int idDueño;
            if (rsDueño.next()) {
                idDueño = rsDueño.getInt("id");
            } else {
                System.out.println("No se encontró ningún dueño con ese teléfono.");
                stmtDueño.close();
                rsDueño.close();
                return;
            }

            stmtDueño.close();
            rsDueño.close();

            // Obtener los perros del dueño
            String sqlPerros = "SELECT id, nombre FROM Mascota WHERE dueño_id = ?";
            PreparedStatement stmtPerros = conexion.prepareStatement(sqlPerros);
            stmtPerros.setInt(1, idDueño);
            ResultSet rsPerros = stmtPerros.executeQuery();

            System.out.println("Selecciona un perro para la cita:");
            while (rsPerros.next()) {
                int idPerro = rsPerros.getInt("id");
                String nombrePerro = rsPerros.getString("nombre");
                System.out.println(idPerro + ". " + nombrePerro);
            }

            System.out.print("Ingresa el ID del perro seleccionado: ");
            int idPerroSeleccionado = sc.nextInt();

            rsPerros.close();
            stmtPerros.close();

            // Ingresar la fecha de la cita
            System.out.println("Ingresa la fecha de la cita (formato: yyyy-MM-dd):");
            sc.nextLine(); // Limpiar el buffer de entrada
            String fechaCita = sc.nextLine();

            // Insertar la cita en la base de datos
            String sqlInsertarCita = "INSERT INTO Cita (fecha, dueño_id, mascota_id, empleado_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtInsertarCita = conexion.prepareStatement(sqlInsertarCita);
            stmtInsertarCita.setString(1, fechaCita);
            stmtInsertarCita.setInt(2, idDueño);
            stmtInsertarCita.setInt(3, idPerroSeleccionado);
            stmtInsertarCita.setInt(4, idEmpleado);
            stmtInsertarCita.executeUpdate();

            System.out.println("Cita agregada exitosamente.");

            stmtInsertarCita.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar la cita");

}
    }

}