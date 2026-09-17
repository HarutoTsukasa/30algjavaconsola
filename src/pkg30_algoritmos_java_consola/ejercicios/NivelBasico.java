package pkg30_algoritmos_java_consola.ejercicios;

import pkg30_algoritmos_java_consola.ejercicios.utilidades.EntradaUsuario;
import pkg30_algoritmos_java_consola.ejercicios.utilidades.Validaciones;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class NivelBasico {

    public void sumaDosNumeros() {
        System.out.println("\n=== SUMA DE DOS NÚMEROS ===");
        double num1 = EntradaUsuario.leerDecimal("Ingrese el primer número: ");
        double num2 = EntradaUsuario.leerDecimal("Ingrese el segundo número: ");

        double resultado = num1 + num2;
        System.out.printf("La suma de %.2f + %.2f = %.2f%n", num1, num2, resultado);
    }

    public void areaTriangulo() {
        System.out.println("\n=== ÁREA DE UN TRIÁNGULO ===");
        double base = EntradaUsuario.leerDecimal("Ingrese la base del triángulo: ");
        double altura = EntradaUsuario.leerDecimal("Ingrese la altura del triángulo: ");

        if (base <= 0 || altura <= 0) {
            System.out.println("Error: La base y altura deben ser positivas.");
            return;
        }

        double area = (base * altura) / 2;
        System.out.printf("El área del triángulo es: %.2f%n", area);
    }

    public void conversionCelsiusFahrenheit() {
        System.out.println("\n=== CONVERSIÓN CELSIUS A FAHRENHEIT ===");
        double celsius = EntradaUsuario.leerDecimal("Ingrese la temperatura en Celsius: ");

        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.printf("%.2f°C = %.2f°F%n", celsius, fahrenheit);
    }

    public void parOImpar() {
        System.out.println("\n=== PAR O IMPAR ===");
        int numero = EntradaUsuario.leerEntero("Ingrese un número entero: ");

        if (Validaciones.esPar(numero)) {
            System.out.println("El número " + numero + " es PAR");
        } else {
            System.out.println("El número " + numero + " es IMPAR");
        }
    }

    public void velocidadVehiculo() {
        System.out.println("\n=== VELOCIDAD DE UN VEHÍCULO ===");
        double distancia = EntradaUsuario.leerDecimal("Ingrese la distancia (km): ");
        double tiempo = EntradaUsuario.leerDecimal("Ingrese el tiempo (horas): ");

        if (tiempo <= 0) {
            System.out.println("Error: El tiempo debe ser mayor a 0.");
            return;
        }

        double velocidad = distancia / tiempo;
        System.out.printf("La velocidad es: %.2f km/h%n", velocidad);
    }

    public void clasificarNumero() {
        System.out.println("\n=== CLASIFICAR NÚMERO ===");
        double numero = EntradaUsuario.leerDecimal("Ingrese un número: ");

        if (numero > 0) {
            System.out.println("El número es POSITIVO");
        } else if (numero < 0) {
            System.out.println("El número es NEGATIVO");
        } else {
            System.out.println("El número es CERO");
        }
    }

    public void maximoTresNumeros() {
        System.out.println("\n=== MÁXIMO DE TRES NÚMEROS ===");
        double num1 = EntradaUsuario.leerDecimal("Ingrese el primer número: ");
        double num2 = EntradaUsuario.leerDecimal("Ingrese el segundo número: ");
        double num3 = EntradaUsuario.leerDecimal("Ingrese el tercer número: ");

        double maximo = Math.max(num1, Math.max(num2, num3));
        System.out.printf("El número mayor es: %.2f%n", maximo);
    }

    public void anioBisiesto() {
        System.out.println("\n=== AÑO BISIESTO ===");
        int anio = EntradaUsuario.leerEntero("Ingrese un año: ");

        if (Validaciones.esAnioBisiesto(anio)) {
            System.out.println("El año " + anio + " es BISIESTO");
        } else {
            System.out.println("El año " + anio + " NO es bisiesto");
        }
    }

    public void mayoriaEdad() {
        System.out.println("\n=== MAYORÍA DE EDAD ===");
        int edad = EntradaUsuario.leerEntero("Ingrese su edad: ");

        if (edad >= 18) {
            System.out.println("Es MAYOR de edad");
        } else {
            System.out.println("Es MENOR de edad");
        }
    }

}
