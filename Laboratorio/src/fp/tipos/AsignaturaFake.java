package fp.tipos;

public class AsignaturaFake {
	private String nombre;
	private String acronimo;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipoAsignatura;
	private Integer curso;
	
	// source -> Generate getters and setters -> Select all getters
	public String getNombre() {
		return nombre;
	}
	public String getAcronimo() {
		//TODO Do later
		return null;
	}
	public String getCodigo() {
		return codigo;
	}
	public Double getCreditos() {
		return creditos;
	}
	public TipoAsignatura getTipoAsignatura() {
		return tipoAsignatura;
	}
	public Integer getCurso() {
		return curso;
	}
	
	public String toString() {
		return "(" + codigo + ")" + " " + nombre;
	}
	
	public AsignaturaFake(String nombre, String codigo, Double creditos, TipoAsignatura tipoAsignatura,
			Integer curso) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipoAsignatura = tipoAsignatura;
		this.curso = curso;
	}
	
	
}
