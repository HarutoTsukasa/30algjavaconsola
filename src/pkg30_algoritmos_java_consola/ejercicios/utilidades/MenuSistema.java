package pkg30_algoritmos_java_consola.ejercicios.utilidades;

import pkg30_algoritmos_java_consola.ejercicios.NivelAvanzado;
import pkg30_algoritmos_java_consola.ejercicios.NivelBasico;
import pkg30_algoritmos_java_consola.ejercicios.NivelIntermedio;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class MenuSistema {

    private final NivelBasico nivelBasico = new NivelBasico();
    private final NivelIntermedio nivelIntermedio = new NivelIntermedio();
    private final NivelAvanzado nivelAvanzado = new NivelAvanzado();

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = EntradaUsuario.leerEntero("Seleccione una opción (0 para salir): ");
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n\u001B[1;35m=== SISTEMA DE EJERCICIOS DE ALGORITMOS ===\u001B[0m");
        System.out.println("\u001B[1;32m=== NIVEL BÁSICO ===\u001B[0m");
        System.out.println("1. Suma de dos números");
        System.out.println("2. Área de un triángulo");
        System.out.println("3. Conversión Celsius a Fahrenheit");
        System.out.println("4. Par o impar");
        System.out.println("5. Velocidad de un vehículo");
        System.out.println("6. Positivo/Negativo/Cero");
        System.out.println("7. Máximo de tres números");
        System.out.println("8. Año bisiesto");
        System.out.println("9. Mayoría de edad");

        System.out.println("\n\u001B[1;33m=== NIVEL INTERMEDIO ===\u001B[0m");
        System.out.println("10. Cálculo con raíces");
        System.out.println("11. Generador de números primos");
        System.out.println("12. Cálculo del Factorial");
        System.out.println("13. Calculadora básica");
        System.out.println("14. Hipotenusa");
        System.out.println("15. Descuento de producto");
        System.out.println("16. Tabla de multiplicar");
        System.out.println("17. Números pares en rango");
        System.out.println("18. Validación de fecha");

        System.out.println("\n\u001B[1;31m=== NIVEL AVANZADO ===\u001B[0m");
        System.out.println("19. Ordenamiento burbuja");
        System.out.println("20. Búsqueda en listas");
        System.out.println("21. Serie Fibonacci");
        System.out.println("22. Triángulos");
        System.out.println("23. Juego de adivinanza");
        System.out.println("24. MCD con Euclides");
        System.out.println("25. Sistema de encuestas");
        System.out.println("26. Simulador financiero");
        System.out.println("27. Conversor de unidades");
        System.out.println("28. Generador de contraseñas");
        System.out.println("29. Sistema de autenticación");
        System.out.println("30. Analizador de texto");
        System.out.println("0. Salir");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 ->
                nivelBasico.sumaDosNumeros();
            case 2 ->
                nivelBasico.areaTriangulo();
            case 3 ->
                nivelBasico.conversionCelsiusFahrenheit();
            case 4 ->
                nivelBasico.parOImpar();
            case 5 ->
                nivelBasico.velocidadVehiculo();
            case 6 ->
                nivelBasico.clasificarNumero();
            case 7 ->
                nivelBasico.maximoTresNumeros();
            case 8 ->
                nivelBasico.anioBisiesto();
            case 9 ->
                nivelBasico.mayoriaEdad();

            case 10 ->
                nivelIntermedio.calculoRaices();
            case 11 ->
                nivelIntermedio.generadorPrimos();
            case 12 ->
                nivelIntermedio.calculoFactorial();
            case 13 ->
                nivelIntermedio.calculadoraBasica();
            case 14 ->
                nivelIntermedio.calcularHipotenusa();
            case 15 ->
                nivelIntermedio.descuentoProducto();
            case 16 ->
                nivelIntermedio.tablaMultiplicar();
            case 17 ->
                nivelIntermedio.numerosParesRango();
            case 18 ->
                nivelIntermedio.validacionFecha();

            case 19 ->
                nivelAvanzado.ordenamientoBurbuja();
            case 20 ->
                nivelAvanzado.busquedaListas();
            case 21 ->
                nivelAvanzado.serieFibonacci();
            case 22 ->
                nivelAvanzado.clasificarTriangulo();
            case 23 ->
                nivelAvanzado.juegoAdivinanza();
            case 24 ->
                nivelAvanzado.mcdEuclides();
            case 25 ->
                nivelAvanzado.sistemaEncuestas();
            case 26 ->
                nivelAvanzado.simuladorFinanciero();
            case 27 ->
                nivelAvanzado.conversorUnidades();
            case 28 ->
                nivelAvanzado.generadorContrasenas();
            case 29 ->
                nivelAvanzado.sistemaAutenticacion();
            case 30 ->
                nivelAvanzado.analizadorTexto();

            case 0 ->
                System.out.println("\u001B[1;35m¡Gracias por usar el sistema!\u001B[0m");
            default ->
                System.out.println("\u001B[1;31mOpción inválida. Intente nuevamente.\u001B[0m");
        }

        if (opcion != 0) {
            System.out.println("\nPresione Enter para continuar...");
            EntradaUsuario.leerTexto("");
        }
    }

}
