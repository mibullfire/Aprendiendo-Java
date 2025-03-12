package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;

public record Centro(String nombre, String direccion, Integer plantas, Integer sotanos, HashSet<Espacio> espacios) implements Comparable <Centro> {
	
	public Centro(String nombre, String direccion, Integer plantas, Integer sotanos) {
		this(nombre, direccion, plantas, sotanos, new HashSet<>());
	}
	
	public Centro {
		checkPlantas(plantas, sotanos);
	}
	
	public void nuevoEspacio(Espacio e) {
		if (e.getPlanta() <= plantas && e.getPlanta() >= -sotanos) {
			espacios.add(e);
		} else {
			throw new IllegalArgumentException("La planta debe de estar entre " + -sotanos + " y " + plantas + ".");
		}
	}
	
	public void eliminaEspacio(Espacio e) {
		espacios.remove(e);
	}
	
	public void checkPlantas(Integer plantas, Integer sotanos) {
		if(!(plantas >= 1 && sotanos >= 0)) {
			throw new IllegalArgumentException("Debe de tener al menos una planta, y 0 o más sotanos");
		}
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Centro) {
			Centro c = (Centro) o;
			res = Objects.equals(nombre, c.nombre);
		}
		return res;
	}

	public int compareTo(Centro c) {
		int res;
		if (c == null) {
			throw new NullPointerException();
		}
		res = nombre.compareTo(c.nombre);
		return res;
	}
	
	//TODO funciones
}
