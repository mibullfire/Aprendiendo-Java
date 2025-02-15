package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;

/*
 * Class of 14/02/2025
 */

public class Empresa {
	private String nombre;
	private String CIF;
	private LocalDate fechaFundacion;
	private Integer empleados;
	
	public Empresa(String nombre, String cIF, LocalDate fechaFundacion, Integer empleados) {
		super();
		this.nombre = nombre;
		CIF = cIF;
		this.fechaFundacion = fechaFundacion;
		this.empleados = empleados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}
	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	public Integer getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", CIF=" + CIF + ", empleados=" + empleados + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaFundacion, nombre);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Empresa) {
			Empresa e = (Empresa) o;
			result = Objects.equals(e.fechaFundacion, fechaFundacion) && Objects.equals(e.nombre, nombre);
		}
		return result;
		
	}
	
	
}
