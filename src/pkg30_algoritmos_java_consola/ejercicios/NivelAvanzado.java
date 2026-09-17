package pkg30_algoritmos_java_consola.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import pkg30_algoritmos_java_consola.ejercicios.utilidades.EntradaUsuario;
import pkg30_algoritmos_java_consola.ejercicios.utilidades.Validaciones;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class NivelAvanzado {

    private final Random random = new Random();

    public void ordenamientoBurbuja() {
        System.out.println("\n=== ORDENAMIENTO BURBUJA ===");
        int n = EntradaUsuario.leerEntero("Ingrese la cantidad de números a ordenar: ");

        double[] numeros = new double[n];
        System.out.println("Ingrese " + n + " números reales:");
        for (int i = 0; i < n; i++) {
            numeros[i] = EntradaUsuario.leerDecimal("Número " + (i + 1) + ": ");
        }

        char orden = Character.toUpperCase(
                EntradaUsuario.leerCaracter("¿Ordenar ascendente (A) o descendente (D)? "));

        // Ordenamiento burbuja
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean necesitaIntercambio = (orden == 'A')
                        ? numeros[j] > numeros[j + 1]
                        : numeros[j] < numeros[j + 1];

                if (necesitaIntercambio) {
                    double temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        System.out.println("Array ordenado:");
        for (double num : numeros) {
            System.out.printf("%.1f ", num);
        }
        System.out.println();
    }

    public void busquedaListas() {
        System.out.println("\n=== BÚSQUEDA EN LISTAS ===");
        List<Integer> numeros = new ArrayList<>();
        int n = EntradaUsuario.leerEntero("Ingrese la cantidad de números: ");

        System.out.println("Ingrese " + n + " números:");
        for (int i = 0; i < n; i++) {
            numeros.add(EntradaUsuario.leerEntero("Número " + (i + 1) + ": "));
        }

        int objetivo = EntradaUsuario.leerEntero("Ingrese el número a buscar: ");

        // Búsqueda secuencial
        int posicion = -1;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == objetivo) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Número encontrado en la posición: " + (posicion + 1));
        } else {
            System.out.println("Número no encontrado en la lista.");
        }

        // Para búsqueda binaria necesitaríamos ordenar primero
        if (EntradaUsuario.leerConfirmacion("\n¿Desea realizar búsqueda binaria? (S/N): ")) {
            numeros.sort(Integer::compareTo);
            System.out.println("Lista ordenada para búsqueda binaria: " + numeros);

            int inicio = 0;
            int fin = numeros.size() - 1;
            boolean encontrado = false;

            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;

                if (numeros.get(medio) == objetivo) {
                    System.out.println("Número encontrado (binaria) en índice: " + medio);
                    encontrado = true;
                    break;
                } else if (numeros.get(medio) < objetivo) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }

            if (!encontrado) {
                System.out.println("Número no encontrado (búsqueda binaria).");
            }
        }
    }

    public void serieFibonacci() {
        System.out.println("\n=== SERIE FIBONACCI ===");
        int n = EntradaUsuario.leerEntero("Ingrese la cantidad de términos: ");

        if (n <= 0) {
            System.out.println("Error: Debe ingresar un número positivo.");
            return;
        }

        if (n > 50) {
            System.out.println("Advertencia: Más de 50 términos puede causar overflow.");
        }

        System.out.println("Serie Fibonacci:");
        long a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long suma = a + b;
            a = b;
            b = suma;

            // Detectar posible overflow
            if (a < 0 && i < n) {
                System.out.println("\nAdvertencia: Overflow detectado en término " + i);
                break;
            }
        }
        System.out.println();
    }

    public void clasificarTriangulo() {
        System.out.println("\n=== CLASIFICACIÓN DE TRIÁNGULOS ===");
        double l1 = EntradaUsuario.leerDecimal("Ingrese lado 1: ");
        double l2 = EntradaUsuario.leerDecimal("Ingrese lado 2: ");
        double l3 = EntradaUsuario.leerDecimal("Ingrese lado 3: ");

        if (!Validaciones.esTrianguloValido(l1, l2, l3)) {
            System.out.println("Error: Los lados no forman un triángulo válido.");
            return;
        }

        // Clasificación
        if (l1 == l2 && l2 == l3) {
            System.out.println("Triángulo EQUILÁTERO");
        } else if (l1 != l2 && l1 != l3 && l2 != l3) {
            System.out.println("Triángulo ESCALENO");
        } else {
            System.out.println("Triángulo ISÓSCELES");
        }
    }

    public void juegoAdivinanza() {
        System.out.println("\n=== JUEGO DE ADIVINANZA ===");
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 0;
        int maxIntentos = 10;
        boolean adivinado = false;

        System.out.println("¡Adivina el número entre 1 y 100!");
        System.out.println("Tienes " + maxIntentos + " intentos.");

        while (intentos < maxIntentos && !adivinado) {
            int intento = EntradaUsuario.leerEntero("Intento " + (intentos + 1) + ": ");
            intentos++;

            if (intento == numeroSecreto) {
                adivinado = true;
                System.out.println("¡Felicidades! Adivinaste en " + intentos + " intentos.");
            } else if (intento < numeroSecreto) {
                System.out.println("El número es MAYOR que " + intento);
            } else {
                System.out.println("El número es MENOR que " + intento);
            }
        }

        if (!adivinado) {
            System.out.println("¡Lo siento! El número era: " + numeroSecreto);
        }
    }

    public void mcdEuclides() {
        System.out.println("\n=== MCD CON ALGORITMO DE EUCLIDES ===");
        int a = EntradaUsuario.leerEntero("Ingrese el primer número: ");
        int b = EntradaUsuario.leerEntero("Ingrese el segundo número: ");

        if (a <= 0 || b <= 0) {
            System.out.println("Error: Ambos números deben ser positivos.");
            return;
        }

        // Algoritmo de Euclides
        int temp1 = Math.abs(a);
        int temp2 = Math.abs(b);

        while (temp2 != 0) {
            int temp = temp2;
            temp2 = temp1 % temp2;
            temp1 = temp;
        }

        int mcd = temp1;
        System.out.println("MCD(" + a + ", " + b + ") = " + mcd);
    }

    public void sistemaEncuestas() {
        System.out.println("\n=== SISTEMA DE ENCUESTAS ===");
        List<String> respuestas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n1. Agregar respuesta");
            System.out.println("2. Ver resultados");
            System.out.println("3. Salir");
            opcion = EntradaUsuario.leerEntero("Seleccione opción: ");

            switch (opcion) {
                case 1 -> {
                    String respuesta = EntradaUsuario.leerTexto("Ingrese su respuesta: ");
                    respuestas.add(respuesta);
                    System.out.println("Respuesta registrada.");
                }
                case 2 -> {
                    System.out.println("\n=== RESULTADOS DE LA ENCUESTA ===");
                    System.out.println("Total de respuestas: " + respuestas.size());
                    System.out.println("Respuestas:");
                    for (int i = 0; i < respuestas.size(); i++) {
                        System.out.println((i + 1) + ". " + respuestas.get(i));
                    }
                }
                case 3 ->
                    System.out.println("Saliendo del sistema de encuestas...");
                default ->
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    public void simuladorFinanciero() {
        System.out.println("\n=== SIMULADOR FINANCIERO ===");
        double capital = EntradaUsuario.leerDecimal("Ingrese el capital inicial: ");
        double tasa = EntradaUsuario.leerDecimal("Ingrese la tasa de interés anual (%): ");
        int periodos = EntradaUsuario.leerEntero("Ingrese el número de períodos (años): ");

        if (capital <= 0 || tasa < 0 || periodos <= 0) {
            System.out.println("Error: Datos inválidos.");
            return;
        }

        double tasaDecimal = tasa / 100;
        double montoFinal = capital * Math.pow(1 + tasaDecimal, periodos);
        double interesGenerado = montoFinal - capital;

        System.out.printf("\nCapital inicial: $%.2f%n", capital);
        System.out.printf("Tasa de interés: %.2f%% anual%n", tasa);
        System.out.printf("Períodos: %d años%n", periodos);
        System.out.printf("Monto final: $%.2f%n", montoFinal);
        System.out.printf("Interés generado: $%.2f%n", interesGenerado);
        System.out.printf("Rentabilidad: %.2f%%%n", (interesGenerado / capital) * 100);
    }

    public void conversorUnidades() {
        System.out.println("\n=== CONVERSOR DE UNIDADES ===");
        System.out.println("1. Temperatura (Celsius / Fahrenheit / Kelvin)");
        System.out.println("2. Longitud (metros / pies / pulgadas)");
        System.out.println("3. Masa (kilogramos / libras / onzas)");

        int opcion = EntradaUsuario.leerEntero("Seleccione el tipo de conversión: ");

        switch (opcion) {
            case 1 ->
                convertirTemperatura();
            case 2 ->
                convertirLongitud();
            case 3 ->
                convertirMasa();
            default ->
                System.out.println("Opción inválida.");
        }
    }

    private void convertirTemperatura() {
        System.out.println("\nConversión de temperatura:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.println("3. Celsius a Kelvin");
        System.out.println("4. Kelvin a Celsius");

        int opcion = EntradaUsuario.leerEntero("Seleccione opción: ");
        double valor = EntradaUsuario.leerDecimal("Ingrese el valor a convertir: ");

        double resultado;
        String conversion;

        switch (opcion) {
            case 1 -> {
                resultado = (valor * 9 / 5) + 32;
                conversion = valor + "°C = " + resultado + "°F";
            }
            case 2 -> {
                resultado = (valor - 32) * 5 / 9;
                conversion = valor + "°F = " + resultado + "°C";
            }
            case 3 -> {
                resultado = valor + 273.15;
                conversion = valor + "°C = " + resultado + "K";
            }
            case 4 -> {
                resultado = valor - 273.15;
                conversion = valor + "K = " + resultado + "°C";
            }
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        System.out.println("Resultado: " + conversion);
    }

    private void convertirLongitud() {
        System.out.println("\nConversión de longitud:");
        double metros = EntradaUsuario.leerDecimal("Ingrese la longitud en metros: ");

        double pies = metros * 3.28084;
        double pulgadas = metros * 39.3701;

        System.out.printf("%.2f metros = %.2f pies%n", metros, pies);
        System.out.printf("%.2f metros = %.2f pulgadas%n", metros, pulgadas);
    }

    private void convertirMasa() {
        System.out.println("\nConversión de masa:");
        double kg = EntradaUsuario.leerDecimal("Ingrese la masa en kilogramos: ");

        double libras = kg * 2.20462;
        double onzas = kg * 35.274;

        System.out.printf("%.2f kg = %.2f libras%n", kg, libras);
        System.out.printf("%.2f kg = %.2f onzas%n", kg, onzas);
    }

    public void generadorContrasenas() {
        System.out.println("\n=== GENERADOR DE CONTRASEÑAS ===");
        int longitud = EntradaUsuario.leerEntero("Ingrese la longitud de la contraseña (8-32): ");

        if (longitud < 8 || longitud > 32) {
            System.out.println("Error: Longitud debe estar entre 8 y 32 caracteres.");
            return;
        }

        boolean incluirMayusculas = EntradaUsuario.leerConfirmacion("¿Incluir mayúsculas? (S/N): ");
        boolean incluirNumeros = EntradaUsuario.leerConfirmacion("¿Incluir números? (S/N): ");
        boolean incluirSimbolos = EntradaUsuario.leerConfirmacion("¿Incluir símbolos? (S/N): ");

        String minusculas = "abcdefghijklmnñopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder caracteres = new StringBuilder(minusculas);
        if (incluirMayusculas) {
            caracteres.append(mayusculas);
        }
        if (incluirNumeros) {
            caracteres.append(numeros);
        }
        if (incluirSimbolos) {
            caracteres.append(simbolos);
        }

        StringBuilder contrasena = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            contrasena.append(caracteres.charAt(index));
        }

        System.out.println("Contraseña generada: " + contrasena);
    }

    public void sistemaAutenticacion() {
        System.out.println("\n=== SISTEMA DE AUTENTICACIÓN ===");
        System.out.println("(Demo educativa: usuario y contraseña están escritos en el código,");
        System.out.println(" esto NO es seguro para una aplicación real.)");
        final String USUARIO_CORRECTO = "admin";
        final String CONTRASENA_CORRECTA = "1234";

        int intentos = 3;
        boolean autenticado = false;

        while (intentos > 0 && !autenticado) {
            String usuario = EntradaUsuario.leerTexto("Usuario: ");
            String contrasena = EntradaUsuario.leerTexto("Contraseña: ");

            if (usuario.equals(USUARIO_CORRECTO) && contrasena.equals(CONTRASENA_CORRECTA)) {
                autenticado = true;
                System.out.println("¡Acceso concedido!");
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }

        if (!autenticado) {
            System.out.println("Acceso bloqueado. Demasiados intentos fallidos.");
        }
    }

    public void analizadorTexto() {
        System.out.println("\n=== ANALIZADOR DE TEXTO ===");
        String texto = EntradaUsuario.leerTexto("Ingrese un texto: ");

        if (texto.isBlank()) {
            System.out.println("Error: El texto no puede estar vacío.");
            return;
        }

        // Contar vocales y consonantes
        int vocales = 0;
        int consonantes = 0;
        String textoMinusculas = texto.toLowerCase().replaceAll("[^a-záéíóúñ]", "");

        for (char c : textoMinusculas.toCharArray()) {
            if ("aeiouáéíóú".indexOf(c) != -1) {
                vocales++;
            } else {
                consonantes++;
            }
        }

        // Contar palabras
        String[] palabras = texto.trim().split("\\s+");
        int cantidadPalabras = texto.trim().isEmpty() ? 0 : palabras.length;

        // Mostrar resultados
        System.out.println("\n=== RESULTADOS DEL ANÁLISIS ===");
        System.out.println("Texto original: \"" + texto + "\"");
        System.out.println("Longitud del texto: " + texto.length() + " caracteres");
        System.out.println("Cantidad de palabras: " + cantidadPalabras);
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
        System.out.println("Caracteres totales (sin espacios): " + texto.replace(" ", "").length());

        // Palabra más larga
        if (cantidadPalabras > 0) {
            String palabraMasLarga = "";
            for (String palabra : palabras) {
                if (palabra.length() > palabraMasLarga.length()) {
                    palabraMasLarga = palabra;
                }
            }
            System.out.println("Palabra más larga: \"" + palabraMasLarga + "\" (" + palabraMasLarga.length() + " letras)");
        }
    }

}
