package fp.tipos;

import java.util.Objects;

public class Articulo implements Comparable<Articulo> {
	private String nombre;
	private String referencia;
	private Double precio;
	private String categoria;
	private Integer stock;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Boolean getDisponibilidad() {
		return stock > 0;
	}
	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", referencia=" + referencia + ", precio=" + precio + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, nombre, referencia);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Articulo) {
			Articulo a = (Articulo) o;
			result = Objects.equals(a.categoria, categoria) && Objects.equals(a.nombre, nombre)
					&& Objects.equals(a.referencia, referencia);
		}
		return result;
	}
	
	public Articulo(String nombre, String referencia, Double precio, String categoria, Integer stock) {
		super();
		this.nombre = nombre;
		this.referencia = referencia;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	public int compareTo(Articulo a) {
		int res;
		if (a == null) {
			throw new NullPointerException();
		}
		res = getReferencia().compareTo(a.getReferencia());
		return res;
	}
	
	


}
