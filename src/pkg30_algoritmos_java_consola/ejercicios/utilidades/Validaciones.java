package pkg30_algoritmos_java_consola.ejercicios.utilidades;

/**
 *
 * @author NESTOR_RIAÑO
 */
public class Validaciones {

    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }

    public static boolean esNumeroNegativo(double numero) {
        return numero < 0;
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static boolean esTrianguloValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a)
                && a > 0 && b > 0 && c > 0;
    }

    public static boolean esFechaValida(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (esAnioBisiesto(anio)) {
            diasPorMes[1] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

}
