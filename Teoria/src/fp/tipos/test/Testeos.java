package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.Persona;

public class Testeos {
	public static void main(String[] args) {
		Persona p1 = new Persona("Miguel", "Toro", "Llamas", "32910888G");
		System.out.println(p1);
		Persona p2 = new Persona("Ángela", "Trujillo", "Mayén", "32910888G", LocalDate.of(2008, 02, 17));
		System.out.println(p2);
		
		System.out.println(p1 == p2); // Son distintos objetos, por lo que devuelve false
		System.out.println(p1.equals(p2)); // Si dos personas tienen el mismo dni se consideran la misma.
	}
}
