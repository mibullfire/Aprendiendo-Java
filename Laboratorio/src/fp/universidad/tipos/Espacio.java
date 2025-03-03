package fp.universidad.tipos;

import java.util.Objects;

public class Espacio implements Comparable<Espacio> {
	private TipoEspacio tipoEspacio;
	private String nombre;
	private Integer capacidad;
	
	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		checkCapacidad(capacidad);
		this.capacidad = capacidad;
	}
	public Integer getPlanta(){
		return Integer.valueOf(nombre.charAt(1));
	}
	public Espacio(TipoEspacio tipoEspacio, String nombre, Integer capacidad) {
		super();
		checkCapacidad(capacidad);
		this.tipoEspacio = tipoEspacio;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return nombre + " (planta " + getPlanta() + ")";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, getPlanta());
	}
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Espacio) {
			Espacio e = (Espacio) o;
			res = Objects.equals(e.nombre, nombre) && Objects.equals(e.getPlanta(), getPlanta());
		}
		return res;
	}
	@Override
	public int compareTo(Espacio o) {
		int res;
		if (o == null) {
			throw new NullPointerException();
		}
		res = getPlanta().compareTo(o.getPlanta());
		if (res == 0) {
			res = getNombre().compareTo(o.getNombre());
		}
		return res;
	}
	public void checkCapacidad(Integer capacidad) {
		if (capacidad < 0) {
			throw new IllegalArgumentException("La capacidad del espacio no puede ser menor a cero");
		}
	}
	
	
	

	
	
	
	
	
	

}
