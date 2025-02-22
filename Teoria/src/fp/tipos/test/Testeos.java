package fp.tipos.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.tipos.Pais;
import fp.tipos.Persona;

public class Testeos {
	public static void main(String[] args) {
		// Persona p1 = new Persona("Miguel", "Toro", "Llamas", "32910888G");
		// System.out.println(p1);
		// Persona p2 = new Persona("Ángela", "Trujillo", "Mayén", "7", LocalDate.of(2008, 02, 17));
		// System.out.println(p2);
		Persona p3 = new Persona("Toro,Llamas,Miguel,3291x,23/10/2005");
		System.out.println(p3);
		
		// System.out.println(p1 == p2); // Son distintos objetos, por lo que devuelve false
		// System.out.println(p1.equals(p2)); // Si dos personas tienen el mismo dni se consideran la misma.
		/*
		Set<Persona> conjunto = new HashSet<>();
		conjunto.add(p2);
		conjunto.add(p1);
		System.out.println(conjunto);
		List<Persona> copia = new ArrayList<>(conjunto);
		System.out.println(copia);
		
		
		Vuelo v = new Vuelo("Ib32748", conjunto);
		System.out.println(v);
		*/
		
		Pais pais1 = new Pais("España", 43000000l , 45000., "Jerez de la Frontera");
		Pais pais2 = new Pais("España", 3000000l , 30000., "A");
		
		Set<Pais> paises = new HashSet<>();
		paises.add(pais1);
		paises.add(pais2);
		System.out.println(paises);
		List<Pais> copia = new ArrayList<>(paises);
		copia.sort(null);
		System.out.println(copia);
		
		
		
		
		
	}
}
