package fp.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Persona {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private LocalDate nacimiento;
	
		
	public Persona(String nombre, String apellido1, String apellido2, String dni) {
		this(nombre, apellido1, apellido2, dni, LocalDate.now());
	}
	
	public Persona (String s) {
		// 1.Trocear
		String[] splits = s.split(",");
		// 2.Checkear
		if (splits.length!=5) {
			throw new IllegalArgumentException("Número de trozos incorrectos");
		}
		// 3.Conversion de Tipos
		String apellido1 = splits[0].trim();
		String apellido2 = splits[1].trim();
		String nombre = splits[2].trim();
		String dni = splits[3].trim();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nacimiento = LocalDate.parse(splits[4].trim(), formato);
		//4.0 comprobacion de restricciones
		checkFechaNacimiento(nacimiento);
		
		//4. Asignación en atributos
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.dni = dni;
		this.nacimiento = nacimiento;
	}
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		checkFechaNacimiento(nacimiento);
		this.nacimiento = nacimiento;
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
	
	private void checkFechaNacimiento(LocalDate fecha) {
		if (fecha.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
	}

	public Persona(String nombre, String apellido1, String apellido2, String dni, LocalDate nacimiento) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.nacimiento = nacimiento;
	}
	
	
		
	
	
}
