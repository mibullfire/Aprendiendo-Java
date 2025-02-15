package fp.tipos.test;

import fp.tipos.Color;

public class TestColor {
    
    public static void main(String [] args){
        Color color = Color.VERDE; // Con esto seleccionamos el color del ENUM Color, en este caso VERDE
        System.out.println("El color seleccionado es el " + color); // Imprimimos el Color por pantalla
        System.out.println(color.ordinal()); // Con ordinal vemos el número que ocupa en esa secuencia
    
    }
}
