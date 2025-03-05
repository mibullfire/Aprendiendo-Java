package fp.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.AsignaturaFake;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.Persona;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.TipoEspacio;
import fp.universidad.tipos.Tutoria;

public class TestAsignatura {
	public static void main (String[] args) {
		AsignaturaFake a = new AsignaturaFake("Fundamentos de Programación", "0000230", 12.0, TipoAsignatura.ANUAL, 1);
		System.out.println(a.getCreditos());
		
		Asignatura a2 = new Asignatura("Fundamentos de Programación", "0000230", 12.0, TipoAsignatura.ANUAL, 1);
		System.out.println(a2);
		System.out.println(a2.creditos());
		
		Asignatura a3 = new Asignatura("Fundamentos de Programación", "0000230", 12.0, TipoAsignatura.ANUAL, 1);
		System.out.println(a3);
		System.out.println(a3.creditos());
		
		System.out.println("a1 y a2 son iguales? " + a.equals(a2));
		System.out.println("a2 y a3 son iguales? " + a2.equals(a3));
		
		Persona p = new Persona("32910888G", "Miguel", "Toro Llamas", LocalDate.of(2004, 10, 23), "prueba@");
		System.out.println(p);
		
		Espacio e = new Espacio(TipoEspacio.LABORATORIO, "A3.10", 100);
		System.out.println(e);
		System.out.println(e.getPlanta());
		
		Nota n = new Nota(a2, 2014, 9.0, Convocatoria.PRIMERA, true);
		System.out.println(n);
		
		Tutoria t = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(17, 30), LocalTime.of(19, 0));
		System.out.println(t);
		System.out.println(t.duracion());
		
	}
	

}
