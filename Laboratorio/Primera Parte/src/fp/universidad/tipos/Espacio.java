package fp.universidad.tipos;

import java.util.Objects;
import fp.utiles.Checkers;

public class Espacio implements Comparable<Espacio> {
	private static final String DELIMITADOR = ",";
	private TipoEspacio tipoEspacio;
	private String nombre;
	private Integer capacidad;
	private Integer planta;
	
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
		return planta;
	}
	/* Cambios para implementar la Factoria
	public Espacio(TipoEspacio tipoEspacio, String nombre, Integer capacidad) {
		super();
		checkCapacidad(capacidad);
		this.tipoEspacio = tipoEspacio;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	*/
	public Espacio(String s) {
		String [] splits = s.split(DELIMITADOR);
		Checkers.check("Numero splits erróneo", splits.length==4);
		String nombre = splits[0].trim();
		Integer planta = Integer.valueOf(splits[1].trim());
		Integer capacidad = Integer.valueOf(splits[2].trim());
		TipoEspacio tipo = TipoEspacio.valueOf(splits[3].toUpperCase().trim());
		checkCapacidad(capacidad);
		this.nombre = nombre;
		this.tipoEspacio = tipo;
		this.capacidad = capacidad;
		this.planta = planta;
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
