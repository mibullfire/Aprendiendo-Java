package fp.tipos;

public record Asignatura(String nombre, String codigo, Double creditos, TipoAsignatura tipoAsignatura, Integer curso) {

	public String toString() {
		return "(" + codigo + ")" + " " + nombre;
	}
}
