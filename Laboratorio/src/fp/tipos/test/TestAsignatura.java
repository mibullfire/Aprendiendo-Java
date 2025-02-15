package fp.tipos.test;

import fp.tipos.AsignaturaFake;
import fp.tipos.Convocatoria;
import fp.tipos.DiaSemana;
import fp.tipos.Espacio;
import fp.tipos.Persona;
import fp.tipos.TipoAsignatura;
import fp.tipos.TipoEspacio;
import fp.tipos.Nota;
import fp.tipos.Tutoria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.tipos.Asignatura;

public class TestAsignatura {
	public static void main (String[] args) {
		AsignaturaFake a = new AsignaturaFake("Fundamentos de Programación", "000230", 12.0, TipoAsignatura.ANUAL, 1);
		System.out.println(a.getCreditos());
		
		Asignatura a2 = new Asignatura("Fundamentos de Programación", "000230", 12.0, TipoAsignatura.ANUAL, 1);
		System.out.println(a2);
		System.out.println(a2.creditos());
		
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
