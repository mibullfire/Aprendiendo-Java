package fp.tipos.test;

public class CalculoImc {

    public static void main(String[] args){
        Double estatura = 1.67;
        Double peso = 70.1;
        Double imc = getImc(peso, estatura);
        System.out.println("Tu imc es: " + imc);
    }

    private static Double getImc(Double peso, Double estatura){
        Double respuesta = peso / Math.pow(estatura, 2); // Math.pow(a, b) eleva a al exponente b
        return respuesta;   
    }
    
}
