package fp.tipos;

import java.time.LocalDate;

public record Persona(String nombre, String apellido, LocalDate nacimiento) {
	
	public Persona(String nombre, String apellido) {
		this(String nombre, String apellido, LocalDate.MIN);
	}

}
