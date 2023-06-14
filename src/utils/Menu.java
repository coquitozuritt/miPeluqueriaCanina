package utils;

import java.util.Scanner;

import static connexion.Conexionbd.*;

    /**
     * Clase que representa un menú con diferentes opciones y submenús.
     */
public class Menu {
    static Scanner sc = new Scanner(System.in);
    //menu que muestre en primer lugar la busqueda de dueños, mascotas y empleado, en segundo lugar que el empleado pueda ver una cita y elegir si cortgarle el pelo o bañarlo

    /**
     * Método que muestra el menú principal y permite al usuario seleccionar una opción.
     */
    public static void menuPrincipal() {
        int opcion;
        do {

            //busqueda de dueno, mascotas y empleados
            System.out.println("1. Buscar: ");
            //panel empleado
            System.out.println("2. Administrar usuarios: ");
            //administrar citas
            System.out.println("3. Administrar citas: ");
            //salir
            System.out.println("4. Añadir citas: ");
            System.out.println("5. Salir: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuBuscar();
                    break;
                case 2:
                    menuAdministrarUsuarios();
                    break;
                case 3:
                    adminCitas();
                    break;
                case 4:
                    anadirCita();
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion != 5);
        sc.close();
    }

    /**
     * Método que muestra el menú de búsqueda y permite al usuario seleccionar una opción.
     */
    public static void menuBuscar() {
        //darle funcionalidad con un switch
        int opcion2;
        do {
            System.out.println("1. Buscar empleado: ");
            System.out.println("2. Buscar dueño: ");
            System.out.println("3. Buscar mascota: ");
            System.out.println("4. Volver: ");
            opcion2 = sc.nextInt();
            switch (opcion2) {
                case 1:
                    buscarEmpleado();
                    break;
                case 2:
                    buscarDueno();
                    break;
                case 3:
                    buscarMascota();
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion2 != 4);
        sc.close();
    }

    /**
     * Método que muestra el menú de administración de citas y permite al usuario seleccionar una opción.
     */
    public static void menuPanelEmpleado() {
        int opcion3;
        do {
            System.out.println("1. Ver cita: ");
            System.out.println("2. Volver: ");
            opcion3 = sc.nextInt();

            switch (opcion3) {
                case 1:
                    verCitas();
                    break;
                case 2:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion3 != 2);
        sc.close();
    }


    /**
     * Método que muestra el menú de administración de usuarios y permite al usuario seleccionar una opción.
     */
    public static void menuAdministrarUsuarios() {
        int opcion4;
        do {
            System.out.println("1. Administrar empleados: ");
            System.out.println("2. Administrar dueños: ");
            System.out.println("3. Volver: ");
            opcion4 = sc.nextInt();

            switch (opcion4) {
                case 1:
                    menuAdministrarEmpleados();
                    break;
                case 2:
                    menuAdministrarDuenos();
                    break;
                case 3:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion4 != 3);
        sc.close();
    }

    /**
     * Método que muestra el menú de administración de empleados y permite al usuario seleccionar una opción.
     */
    public static void menuAdministrarEmpleados() {
        int opcion5;
        do {
            System.out.println("1. Añadir empleado: ");
            System.out.println("2. Borrar empleado: ");
            System.out.println("3. Modificar empleado: ");
            System.out.println("4. Volver: ");

        opcion5 = sc.nextInt();

            switch (opcion5) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    borrarEmpleado();
                    break;
                case 3:
                    editarEmpleado();
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion5 != 4);
        sc.close();
    }

        /**
         * Método que muestra el menú de administración de dueños y permite al usuario seleccionar una opción.
         */
        public static void menuAdministrarDuenos () {
            int opcion6;
            do {
                System.out.println("1. Añadir dueño: ");
                System.out.println("2. Borrar dueño: ");
                System.out.println("3. Modificar dueño: ");
                System.out.println("4. Volver: ");
                opcion6 = sc.nextInt();

                switch (opcion6) {
                    case 1:
                        crearDueno();
                        break;
                    case 2:
                        borrarDueno();
                        break;
                    case 3:
                        editarDueno();
                        break;
                    case 4:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } while (opcion6 != 4);
            sc.close();
        }

}