package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
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
	
}
