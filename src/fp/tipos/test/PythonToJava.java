package fp.tipos.test;

/*
 * En este pequeño sript hay funciones muy básicas que se hacer de sobra en Python,
 * y las estoy traspasando a Java para practicar. Funciones:
 * - suma
 * - esPar
 * - esPrimo
 */

public class PythonToJava {
    public static int suma(int a, int b){
        return a + b;
    }

    public static String esPar(int numero){
        boolean resultado;
        if (numero % 2 == 0){
            resultado = true;
        }
        else {
            resultado = false;
        }
        if (resultado == true) {
            return "par";
        } else {
            return "impar";
        }
    }
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
        
    }
}
