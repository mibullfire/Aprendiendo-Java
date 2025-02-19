package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate nacimiento;
	private String mail;
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public String getMail() {
		return mail;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Integer getEdad() {
		Period periodo = nacimiento.until(LocalDate.now());
		return periodo.getYears();
	}
	
	public String toString() {
		return dni + " - " + apellidos + ", " + nombre + " - " + nacimiento.getDayOfMonth()+"/"+nacimiento.getMonthValue()+"/"+nacimiento.getYear();
	}
	public Persona(String dni, String nombre, String apellidos, LocalDate nacimiento, String mail) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.mail = mail;
	}
	
	
	
	

}
