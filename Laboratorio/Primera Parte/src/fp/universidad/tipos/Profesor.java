package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static fp.utiles.Checkers.*;

public class Profesor extends Persona {

	private Categoria categoria;
	private SortedSet<Tutoria> tutorias;
	
	public Profesor(String dni, String nombre, String apellidos, LocalDate nacimiento, String mail, Categoria categoria) {
		super(dni, nombre, apellidos, nacimiento, mail);
		this.categoria = categoria;
		this.tutorias = new TreeSet<Tutoria>();
		this.creditosPorAsignatura= new HashMap<>();
		check("El profesor debe ser mayor de edad", getEdad()>=18);
			}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SortedSet<Tutoria> getTutorias() {
		return new TreeSet<Tutoria>(tutorias);
	}

	public void nuevaTutoria(LocalTime comienzo, Integer duracion, DayOfWeek dia) {
		Tutoria t = new Tutoria(dia, duracion, comienzo);
		tutorias.add(t);
	}
	public void borraTutoria(LocalTime comienzo, DayOfWeek dia) {
		Tutoria t = buscaTutoria(comienzo, dia);
		tutorias.remove(t);
	}
	private Tutoria buscaTutoria(LocalTime comienzo, DayOfWeek dia) {
		Tutoria res = null;
		for (Tutoria t: tutorias) {
			if (t.comienzo().equals(comienzo)&&t.diaSemana().equals(dia)) {
				res = t;
				break;
			}
		}
		return res;
	}

	public void borraTutorias() {
		tutorias.clear();
	}

	@Override
	public String toString() {
		return super.toString() + " (" + getCategoria() + ")";
	}
	
	
	/// MAPS
	
	private Map<Asignatura, Double> creditosPorAsignatura;
	
	public List<Asignatura> getAsignaturas(){
		return new ArrayList<>(creditosPorAsignatura.keySet());
	}
	
	public List<Double> getCreditos(){
		return new ArrayList<>(creditosPorAsignatura.values());
	}
	
	private Double getCreditosTotales() {
		Double total = 0.;
		for (Double c: getCreditos()) {
			total += c;
		}
		
		return total;
	}
	
	public void ImparteAsignatura(Asignatura a, Double credits) {
		check("Los créditos tienen que ser mayores de cero.", credits > 0);
		check("Los créditos no puede ser superior al número de créditos de la asignatura", credits <= a.creditos());
		check("La sua de c´reditos más el valor a añadir no peden superar los 24 créditos.", (getCreditosTotales() + credits) <= 24);

		creditosPorAsignatura.put(a, credits);
	}
	
	public void eliminaAsignatura(Asignatura a) {
		creditosPorAsignatura.remove(a);
	}
	
	public Double getDedicacionAsignatura(Asignatura a) {
		/*
		Double res = 0.;
		if (creditosPorAsignatura .containsKey(a)) {
			res = creditosPorAsignatura.get(a);
		}
		return res;
		*/
		return creditosPorAsignatura.getOrDefault(a, 0.);
	}
	
}
