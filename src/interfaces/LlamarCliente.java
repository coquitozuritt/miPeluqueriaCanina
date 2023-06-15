package interfaces;

import java.sql.SQLException;

/**
 * La interfaz LlamarAlCliente define un método para llamar a un cliente.
 */
public interface LlamarCliente {

    public static void llamarCliente(int numeroCliente) {
        // Simulación de llamada
        System.out.println("Llamando al cliente " + numeroCliente);
        System.out.println("¡Ring, ring! ¡Ring, ring!");

        // Mostrar mensaje
        System.out.println("Estimado cliente, le informamos que ha habido un cambio en su cita.");
        System.out.println("Por favor, tenga en cuenta la nueva fecha y hora.");

        // Otras acciones o información adicional durante la llamada
        // ...

        // Finalizar la llamada
        System.out.println("¡Gracias por su atención! ¡Hasta luego!");
    }

}
