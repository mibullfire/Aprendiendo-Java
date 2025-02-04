package fp.tipos.test;

/*
 * En este pequeño sript hay funciones muy básicas que se hacer de sobra en Python,
 * y las estoy traspasando a Java para practicar. Funciones:
 * - suma
 * - esPar
 * - esPrimo
 * - factorial
 * - reverse
 */

public class PythonToJava {

    // Suma de dos numeros a y b
    public static int suma(int a, int b){
        return a + b;
    }

    // Comprobar si un número es par
    public static String esPar(int numero){
        boolean resultado = false;
        if (numero % 2 == 0){
            resultado = true;
        }
        if (resultado == true) {
            return "par";
        } else {
            return "impar";
        }
    }

    // Comprobar si un número es primo
    public static boolean esPrimo(int numero){
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
            return false;
            }
        }
        return true;
    }

    // Factorial de un número
    public static int factorial(int numero){
        int resultado = 1;
        for(int i = 1; i <= numero; i++){
            resultado = resultado*i;
        }
        return resultado;
    }

    public static void main(String [] args){

        // Prueba de código para sumar dos números enteros 'a' y 'b'
        int a = 2;
        int b = 5;
        int resultadof1 = suma(a, b);
        System.out.println("\nPrueba Función 1");
        System.out.println("El resultado de " + a + "+" + b +" es " + resultadof1);

        // Prueba de código para comprobar si un número es par o no
        int c = 32;
        String resultadof2 = esPar(c);
        System.out.println("\nPrueba Función 2");
        System.out.println("El número " + c + " es " + resultadof2);

        // Prueba de código para comprobar si un número es primo o no
        int d = 23;
        boolean resultadof3 = esPrimo(d);
        System.out.println("\nPrueba Función 3");
        System.out.println("¿El número " + d + " es primo? " + resultadof3);

        // Prueba de código para el calculo de factorial
        int e = 3;
        int resultadof4 = factorial(e);
        System.out.println("\nPrueba Función 4");
        System.out.println("El factorial de "+e+" es "+resultadof4);
        
    }
}
