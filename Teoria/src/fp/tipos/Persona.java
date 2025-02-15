package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;

public record Persona(String nombre, String apellido1, String apellido2, String dni, LocalDate nacimiento) {
	
	public Persona(String nombre, String apellido1, String apellido2, String dni) {
		this(nombre, apellido1, apellido2, dni, LocalDate.now());
	}

	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + ", nacido el " + nacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	// Diremos que dos personas son iguales si tienen el mismo dni
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Persona) {
			Persona p = (Persona) o;
			result = Objects.equals(p.dni, dni);
		}
		return result;
	}
	
}
