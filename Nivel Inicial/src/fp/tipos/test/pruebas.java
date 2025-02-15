package fp.tipos.test;

import java.util.*;

public class pruebas {
    public static void main(String[] args){
        Long l = 321l;
        Integer valor = 2+2*l.intValue(); // Hay que tener cuidado con los tipos
        System.out.println(valor);

        String nombre = "Ángela";
        Integer lon = nombre.length();
        char inicial = nombre.charAt(0);
        char ultima = nombre.charAt(lon - 1);
        System.out.println(inicial);
        System.out.println(ultima);

        // Tema Listas
        List<Double> temperaturas = new LinkedList<>();
        temperaturas.add(23.3); // Se usa .add tanto para los conjuntos como para las listas.
        temperaturas.add(26.7);

        System.out.println(temperaturas);

        Double t1 = temperaturas.get(0);
        Integer numeroElementos = temperaturas.size();

        System.out.println(t1);
        System.out.println(numeroElementos);

        // Tema Conjuntos
        Set<Character> letras = new HashSet<>();
        letras.add('A');
        SortedSet<Character> letrasOrdenadas = new TreeSet<>();
        letrasOrdenadas.add('A');

        // Tema mapas
        Map<String, Double> temperaturasCiudad = new HashMap<>();
        temperaturasCiudad.put("Córdoba", 19.1);
        Double t = temperaturasCiudad.get("Córdoba");
        System.out.println(t);

    }
}
