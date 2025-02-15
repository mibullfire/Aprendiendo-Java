package fp.tipos;

import java.util.Objects;

public class Jugador {
	private String nombre;
	private String nacimiento;
	private Double altura;
	private String nacionalidad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
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
	public Jugador(String nombre, String nacimiento, Double altura, String nacionalidad) {
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
	
	

}
