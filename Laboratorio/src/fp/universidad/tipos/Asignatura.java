package fp.universidad.tipos;

import static fp.utiles.Checkers.*;

import java.util.Objects;

public record Asignatura(String nombre, String codigo, Double creditos, TipoAsignatura tipoAsignatura, Integer curso) implements Comparable<Asignatura> {

	
	public Asignatura{
		checkCreditos(creditos); // Usando variables de check propias
		check("El curso debe de estar entre 1 y 4", curso >= 1 && curso <= 4); // Usando el checkers.java
		checkCodigo(codigo);
	}
	
	private void checkCreditos(Double creditos) {
		if (creditos <= 0) {
			throw new IllegalArgumentException("Los créditos deben ser mayores a cero");
		}
	}
	private void checkCodigo(String Codigo) {
		if(!(codigo.length()==7 
				&& Character.isDigit(codigo.charAt(0))
				&& Character.isDigit(codigo.charAt(1))
				&& Character.isDigit(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3))
				&& Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5))
				&& Character.isDigit(codigo.charAt(6)))) {
			throw new IllegalArgumentException("El código tiene que tener 7 dígitos");
		}
	}
	
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
	@Override
	public int compareTo(Asignatura o) {
		if (o == null) {
			throw new NullPointerException();
		}
		return codigo.compareTo(o.codigo);
	}
	
}
