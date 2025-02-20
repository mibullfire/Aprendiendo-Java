package fp.universidad.tipos;

import java.util.Objects;
import java.util.*;

public class Grado {
	private String nombre;
	private Set<Asignatura> obligatorias;
	private Set<Asignatura> optativas;
	private Integer minimoCreditosOptativas;
	
	public Grado(String nombre, Set<Asignatura> obligatorias, Set<Asignatura> optativas,
			Integer minimoCreditosOptativas) {
		this.nombre = nombre;
		this.obligatorias = obligatorias;
		this.optativas = optativas;
		this.minimoCreditosOptativas = minimoCreditosOptativas;
	}
	
	private Set<Asignatura> getTodasAsignaturas(){
		Set<Asignatura> result = new HashSet<Asignatura>();
		
		// Un HashSet con todas las asignaturas, tanto obliagtorias como optativas
		Set<Asignatura> asignaturas = new HashSet<Asignatura>(obligatorias);
		asignaturas.addAll(optativas);
		return result;
	}
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		Set<Asignatura> result = new HashSet<Asignatura>();
		
		for (Asignatura a: getTodasAsignaturas()) {
			if (a.curso().equals(curso)) {
				result.add(a);
			}
		}
		return result;
	}
	
	public Asignatura getAsignatura(String codigo) {
		Asignatura result = null;
		for (Asignatura a: getTodasAsignaturas()) {
			if (a.codigo().equals(codigo)) {
				result = a;
			}
		}
		return result;
	}


	public Double getCreditos() {
		Double delFor = 0.0;
		for (Asignatura a: getTodasAsignaturas()) {
			delFor += a.creditos();
		}
		
		return delFor + minimoCreditosOptativas;
	}
	
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grado other = (Grado) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
