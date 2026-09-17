package pkg30_algoritmos_java_consola.ejercicios.utilidades;

import java.util.Scanner;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class EntradaUsuario {

    private static final Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número entero.");
            sc.next();
            System.out.print(mensaje);
        }
        return sc.nextInt();
    }

    public static double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Debe ingresar un número decimal.");
            sc.next();
            System.out.print(mensaje);
        }
        return sc.nextDouble();
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        sc.nextLine(); // Limpiar buffer
        return sc.nextLine();
    }

    public static void limpiarBuffer() {
        sc.nextLine();
    }

}
