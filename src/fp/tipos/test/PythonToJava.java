package fp.tipos.test;
import java.util.ArrayList;
import java.util.List;
/*
 * En este pequeño sript hay funciones muy básicas que se hacer de sobra en Python,
 * y las estoy traspasando a Java para practicar. Funciones:
 * - suma
 * - esPar
 * - esPrimo
 * - factorial
 * - Fibonacci
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

    // Fibonacci
    public static List<Integer> fibonacci(int n){
        List<Integer> resultado = new ArrayList<>();
        Integer n1 = 0;
        Integer n2 = 1;
        Integer nuevo = 0;
        resultado.add(n1); resultado.add(n2);
        for (Integer i=n1; i < n; i++){
            nuevo = n1 + n2; 
            n1 = n2; n2 = nuevo;
            resultado.add(nuevo);
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

        // Prueba de código para Fibonacci
        int valores = 10;
        List<Integer> resultadof5 = fibonacci(valores);
        System.out.println("\nPrueba Función 5");
        System.out.println(resultadof5);
        
    }
}
