package fp.universidad.tipos;

import java.util.Objects;

public record Asignatura(String nombre, String codigo, Double creditos, TipoAsignatura tipoAsignatura, Integer curso) {

	// Dos asignaturas se consideran iguales si tienen el mismo código.
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Asignatura) {
			Asignatura a = (Asignatura) o;
			result = Objects.equals(a.codigo, codigo);
			}
		return result;
	}
	public int hashCode() {
		return Objects.hashCode(codigo);
	}
	
	public String toString() {
		return "(" + codigo + ")" + " " + nombre;
	}
}
