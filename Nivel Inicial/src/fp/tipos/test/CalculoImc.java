package fp.tipos.test;

import java.util.*;

import fp.tipos.TipoIMC;

public class CalculoImc {

    public static void main(String[] args){
        Double estatura = 1.80;
        Double peso = 64.2;
        Double imc = getImc(peso, estatura);
        System.out.println("Tu imc es: " + imc);

        List<Double> cosas = generaIMCsRandom(5);
        System.out.println(cosas);

        TipoIMC tipo = getTipoIMC(imc);
        System.out.println(tipo);
        
        Double media = getIMCMedio(cosas);
        System.out.println(media);
    }

    private static Double getImc(Double peso, Double estatura){
        Double respuesta = peso / Math.pow(estatura, 2); // Math.pow(a, b) eleva a al exponente b
        return respuesta;   
    }

    private static List<Double> generaIMCsRandom(Integer n){
        List<Double> resultado = new LinkedList<Double>();
        for (Integer i=1; i<=n; i++){
            Double aleatorio = Math.random() * 35 + 15;
            resultado.add(aleatorio);
        }
        return resultado;
    }

    private static TipoIMC getTipoIMC(Double imc){
        TipoIMC respuesta ;
        if (imc < 18.5){
            respuesta = TipoIMC.Bajo;
        } else if (18.5 <= imc && imc <= 24.9){
            respuesta = TipoIMC.Normal;
        } else if (25 <= imc && imc <= 29.9){
            respuesta = TipoIMC.Sobrepeso;
        } else {
            respuesta = TipoIMC.Obeso;
        }
        return respuesta;
    }

    private static Double getIMCMedio(List<Double> lista){
        Double respuesta = 0d;
        for (Integer i=1; i<lista.size(); i++){
            respuesta = respuesta + lista.get(i);
        }

        // También podemos usar un stream para calcular la suma
        Double respuesta2 = lista.stream() // Obtiene un flujo (stream) de la lista
                    .mapToDouble(Double::doubleValue) // Convierte cada elemento del flujo a un valor double
                    .sum(); // Suma todos los valores double del flujo y devuelve el resultado
        
        return respuesta2/lista.size();
    }
    
}
