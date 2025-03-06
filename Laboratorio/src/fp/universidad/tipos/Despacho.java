package fp.universidad.tipos;

import java.util.HashSet;

public class Despacho extends Espacio {
	
	private HashSet<Profesor> profesores;

	public Despacho(String nombre, Integer capacidad, HashSet<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad);
		this.profesores = profesores;
		checkCapacidad(profesores, capacidad);
	}
	
	public Despacho(String nombre, Integer capacidad, Profesor profesor) {
		super(TipoEspacio.OTRO, nombre, capacidad);
		this.profesores = new HashSet<Profesor>();
		this.profesores.add(profesor);
		checkCapacidad(profesores, capacidad);
	}
	
	public Despacho(String nombre, Integer capacidad) {
		super(TipoEspacio.OTRO, nombre, capacidad);
		this.profesores = new HashSet<Profesor>();
		checkCapacidad(profesores, capacidad);
	}
	
	public void setTipo() {
		throw new UnsupportedOperationException();	
	}
	
	private void checkCapacidad(HashSet<Profesor> profesores, Integer capacidad) {
		if (profesores.size() > capacidad) {
			throw new IllegalArgumentException("Se ha excedido la capacidad de profesores en este despacho, valor máximo: "+capacidad);
		}
	}

	public HashSet<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(HashSet<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public String toString() {
		return super.toString() + profesores;
	}
}
