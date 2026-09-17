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
        int valor = sc.nextInt();
        sc.nextLine(); // Consume el salto de línea pendiente tras nextInt()
        return valor;
    }

    public static double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Debe ingresar un número decimal.");
            sc.next();
            System.out.print(mensaje);
        }
        double valor = sc.nextDouble();
        sc.nextLine(); // Consume el salto de línea pendiente tras nextDouble()
        return valor;
    }

    /**
     * Lee una línea completa de texto (puede contener espacios). No hace falta
     * "limpiar el buffer" antes de leer: leerEntero y leerDecimal ya consumen
     * su propio salto de línea, así que este método siempre puede leer
     * directamente.
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    /**
     * Lee un único carácter no vacío (por ejemplo una letra de menú). Repite la
     * pregunta si el usuario solo presiona Enter.
     */
    public static char leerCaracter(String mensaje) {
        String texto = leerTexto(mensaje).trim();
        while (texto.isEmpty()) {
            System.out.println("Error: Debe ingresar al menos un carácter.");
            texto = leerTexto(mensaje).trim();
        }
        return texto.charAt(0);
    }

    /**
     * Pregunta de confirmación S/N reutilizable. Devuelve true solo si el
     * usuario responde "S" (sin distinguir mayúsculas/minúsculas).
     */
    public static boolean leerConfirmacion(String mensaje) {
        String respuesta = leerTexto(mensaje);
        return respuesta.trim().equalsIgnoreCase("S");
    }

}
