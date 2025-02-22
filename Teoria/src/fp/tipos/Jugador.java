package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;

public class Jugador implements Comparable<Jugador> {
	private String nombre;
	private LocalDate nacimiento;
	private Double altura;
	private String nacionalidad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		checkNacimiento(nacimiento);
		this.nacimiento = nacimiento;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Jugador(String nombre, LocalDate nacimiento, Double altura, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.altura = altura;
		this.nacionalidad = nacionalidad;
	}
	
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nacimiento=" + nacimiento + ", altura=" + altura + ", nacionalidad="
				+ nacionalidad + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nacimiento, nombre);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Jugador) {
			Jugador j = (Jugador) o;
			result = Objects.equals(j.nacimiento, nacimiento) && Objects.equals(j.nombre, nombre);
		}
		return result;
	}

	private void checkNacimiento(LocalDate fecha) {
		if (fecha.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
	}
	
	public int compareTo(Jugador j) {
		int res;
		if (j == null) {
			throw new NullPointerException();
		}
		res = getNombre().compareTo(j.getNombre());
		if (res == 0) {
			res = getNacimiento().compareTo(j.getNacimiento());
			if (res == 0) {
				res = getNacionalidad().compareTo(j.getNacionalidad());
			}
		}
		return res;
	}
	
	

}
