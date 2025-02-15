package fp.tipos;

import java.util.Objects;

public class Pais {
	private String nombre;
	private Long habitantes;
	private Double extension;
	private String capital;
	
	public Pais(String nombre, Long habitantes, Double extension, String capital) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.extension = extension;
		this.capital = capital;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(Long habitantes) {
		this.habitantes = habitantes;
	}


	public Double getExtension() {
		return extension;
	}


	public void setExtension(Double extension) {
		this.extension = extension;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", habitantes=" + habitantes + ", extension=" + extension + ", capital="
				+ capital + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, nombre);
	}

	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Pais) {
			Pais p = (Pais) o;
			result = Objects.equals(p.capital, capital) && Objects.equals(p.nombre, nombre);
		}
		return result;
	}
	
	

}
