package fp.tipos;

import java.util.Objects;

/*
 * Class of 14/02/2025
 */

public class Videojuego {
	private String nombre;
	private String distribuidora;
	private Integer anyo;
	private Double ventasGLobales;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
	public Integer getAnyo() {
		return anyo;
	}
	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}
	public Double getVentasGLobales() {
		return ventasGLobales;
	}
	public void setVentasGLobales(Double ventasGLobales) {
		this.ventasGLobales = ventasGLobales;
	}
	public Videojuego(String nombre, String distribuidora, Integer anyo, Double ventasGLobales) {
		super();
		this.nombre = nombre;
		this.distribuidora = distribuidora;
		this.anyo = anyo;
		this.ventasGLobales = ventasGLobales;
	}
	
	// Equals form made on class
	@Override
	public int hashCode() {
		return Objects.hash(anyo, nombre);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Videojuego) {
			Videojuego v = (Videojuego) o;
			result = Objects.equals(nombre, v.nombre) &&
					Objects.equals(anyo, v.anyo);
		}
		return result;
	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", distribuidora=" + distribuidora + ", anyo=" + anyo
				+ ", ventasGLobales=" + ventasGLobales + "]";
	}
	
	

}
