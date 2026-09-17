package pkg30_algoritmos_java_consola.ejercicios;

import pkg30_algoritmos_java_consola.ejercicios.utilidades.EntradaUsuario;
import pkg30_algoritmos_java_consola.ejercicios.utilidades.Validaciones;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class NivelIntermedio {

    public void calculoRaices() {
        System.out.println("\n=== CÁLCULO CON RAÍCES ===");
        double numero = EntradaUsuario.leerDecimal("Ingrese un número: ");

        if (numero < 0) {
            System.out.println("Error: No se puede calcular raíz cuadrada de números negativos.");
            return;
        }

        double raizCuadrada = Math.sqrt(numero);
        double raizCubica = Math.cbrt(numero);

        System.out.printf("Raíz cuadrada de %.2f = %.4f%n", numero, raizCuadrada);
        System.out.printf("Raíz cúbica de %.2f = %.4f%n", numero, raizCubica);
    }

    public void generadorPrimos() {
        System.out.println("\n=== GENERADOR DE NÚMEROS PRIMOS ===");
        int inicio = EntradaUsuario.leerEntero("Ingrese el inicio del rango: ");
        int fin = EntradaUsuario.leerEntero("Ingrese el fin del rango: ");

        if (inicio > fin) {
            System.out.println("Error: El inicio debe ser menor que el fin.");
            return;
        }

        System.out.println("Números primos en el rango [" + inicio + ", " + fin + "]:");

        int contador = 0;
        for (int i = Math.max(2, inicio); i <= fin; i++) {
            if (esPrimo(i)) {
                System.out.print(i + " ");
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("No hay números primos en este rango.");
        } else {
            System.out.println("\nTotal: " + contador + " números primos.");
        }
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void calculoFactorial() {
        System.out.println("\n=== CÁLCULO DEL FACTORIAL ===");
        int numero = EntradaUsuario.leerEntero("Ingrese un número entero no negativo: ");

        if (numero < 0) {
            System.out.println("Error: No existe factorial de números negativos.");
            return;
        }

        if (numero > 20) {
            System.out.println("Advertencia: Para números mayores a 20 puede haber overflow.");
        }

        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }

        System.out.println(numero + "! = " + factorial);
    }

    public void calculadoraBasica() {
        System.out.println("\n=== CALCULADORA BÁSICA ===");
        System.out.println("Operaciones disponibles: +, -, *, /");

        double num1 = EntradaUsuario.leerDecimal("Ingrese el primer número: ");
        String operacion = EntradaUsuario.leerTexto("Ingrese la operación (+, -, *, /): ");
        double num2 = EntradaUsuario.leerDecimal("Ingrese el segundo número: ");

        double resultado;
        //boolean operacionValida = true;

        switch (operacion) {
            case "+" ->
                resultado = num1 + num2;
            case "-" ->
                resultado = num1 - num2;
            case "*" ->
                resultado = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: División por cero no permitida.");
                    return;
                }
                resultado = num1 / num2;
            }
            default -> {
                System.out.println("Error: Operación no válida.");
                return;
            }
        }

        System.out.printf("%.2f %s %.2f = %.2f%n", num1, operacion, num2, resultado);
    }

    public void calcularHipotenusa() {
        System.out.println("\n=== CÁLCULO DE HIPOTENUSA ===");
        double cateto1 = EntradaUsuario.leerDecimal("Ingrese el primer cateto: ");
        double cateto2 = EntradaUsuario.leerDecimal("Ingrese el segundo cateto: ");

        if (cateto1 <= 0 || cateto2 <= 0) {
            System.out.println("Error: Los catetos deben ser positivos.");
            return;
        }

        double hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
        System.out.printf("La hipotenusa es: %.2f%n", hipotenusa);
    }

    public void descuentoProducto() {
        System.out.println("\n=== DESCUENTO DE PRODUCTO ===");
        double precio = EntradaUsuario.leerDecimal("Ingrese el precio original: ");
        double descuento = EntradaUsuario.leerDecimal("Ingrese el porcentaje de descuento: ");

        if (precio <= 0 || descuento < 0 || descuento > 100) {
            System.out.println("Error: Datos inválidos.");
            return;
        }

        double descuentoAplicado = precio * (descuento / 100);
        double precioFinal = precio - descuentoAplicado;

        System.out.printf("Precio original: $%.2f%n", precio);
        System.out.printf("Descuento (%.1f%%): $%.2f%n", descuento, descuentoAplicado);
        System.out.printf("Precio final: $%.2f%n", precioFinal);
    }

    public void tablaMultiplicar() {
        System.out.println("\n=== TABLA DE MULTIPLICAR ===");
        int numero = EntradaUsuario.leerEntero("Ingrese un número: ");

        System.out.println("Tabla de multiplicar del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", numero, i, numero * i);
        }
    }

    public void numerosParesRango() {
        System.out.println("\n=== NÚMEROS PARES EN RANGO ===");
        int limite = EntradaUsuario.leerEntero("Ingrese el límite (N): ");

        if (limite < 1) {
            System.out.println("Error: El límite debe ser mayor a 0.");
            return;
        }

        System.out.println("Números pares desde 1 hasta " + limite + ":");
        for (int i = 2; i <= limite; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void validacionFecha() {
        System.out.println("\n=== VALIDACIÓN DE FECHA ===");
        int dia = EntradaUsuario.leerEntero("Ingrese el día: ");
        int mes = EntradaUsuario.leerEntero("Ingrese el mes: ");
        int anio = EntradaUsuario.leerEntero("Ingrese el año: ");

        if (Validaciones.esFechaValida(dia, mes, anio)) {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es VÁLIDA");
            if (Validaciones.esAnioBisiesto(anio)) {
                System.out.println("El año " + anio + " es bisiesto.");
            }
        } else {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es INVÁLIDA");
        }
    }

}
