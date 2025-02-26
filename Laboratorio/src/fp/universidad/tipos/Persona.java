package fp.universidad.tipos;
import static fp.utiles.Checkers.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona implements Comparable<Persona> {
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
		checkDni(dni);
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
		checkMail(mail);
		this.mail = mail;
	}
	
	public Integer getEdad() {
		Period periodo = nacimiento.until(LocalDate.now());
		return periodo.getYears();
	}
	
	public String toString() {
		return dni + " - " + apellidos + ", " + nombre + " - " + nacimiento.getDayOfMonth()+"/"+nacimiento.getMonthValue()+"/"+nacimiento.getYear();
	}
	
	// Constructor sin mail:
	public Persona(String dni, String nombre, String apellidos, LocalDate nacimiento) {
		this(dni, nombre, apellidos, nacimiento, "");
	}
	
	private void checkDni(String dni) {
		check("DNI", Character.isDigit(dni.charAt(0))
				&& Character.isDigit(dni.charAt(1))
				&& Character.isDigit(dni.charAt(2))
				&& Character.isDigit(dni.charAt(3))
				&& Character.isDigit(dni.charAt(4))
				&& Character.isDigit(dni.charAt(5))
				&& Character.isDigit(dni.charAt(6))
				&& Character.isDigit(dni.charAt(7))
				&& Character.isLetter(dni.charAt(8)));
	}
	
	private void checkMail(String mail) {
		check("El email debe ser una cadena vacía o contener un carácter @", mail.equals("") || mail.contains("@"));
	}
	
	public Persona(String dni, String nombre, String apellidos, LocalDate nacimiento, String mail) {
		super();
		checkDni(dni);
		checkMail(mail);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.mail = mail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre, dni);
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Persona) {
			Persona p = (Persona) o;
			res = Objects.equals(p.dni, dni) && Objects.equals(p.nombre, nombre) && Objects.equals(p.apellidos, apellidos);
		}
		return res;
	}
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		int res;
		if (o == null) {
			throw new NullPointerException();
		}
		res = getApellidos().compareTo(o.getApellidos());
		;
		if (res == 0) {
			res = getNombre().compareTo(o.getNombre());
		} else if (res == 0) {
			res = getDni().compareTo(o.getDni());
		}
		return res;
	}
	
	
	
	
	
	
	

}
