package fp.universidad.tipos;

import java.time.LocalDate;
import java.util.HashSet;

public class Alumno extends Persona {
	private HashSet<Asignatura> asignaturas;
	private Integer curso;
	
	
	public Alumno(String dni, String nombre, String apellidos, LocalDate nacimiento, String mail) {
		super(dni, nombre, apellidos, nacimiento);
		this.asignaturas = new HashSet<Asignatura>();
		this.curso = 0; //cursoAlto(asignaturas);
		checkMail(mail);
	}
	
	private void checkMail(String mail) {
		if (!(mail.endsWith("@alum.us.es"))) {
		throw new IllegalArgumentException("El mail del alumno debe acabar por @alum.us.es");
		}
	}
	
	/*TODO
	private Integer cursoAlto(HashSet<Asignatura> asignaturas) {
		Integer res = 0;
		return res;
	}
	*/
	
	public HashSet<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	//TODO
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	public void matriculaAsignatura(Asignatura a) {
		if (asignaturas.contains(a)) {
			throw new IllegalArgumentException("El alumno ya está matriculado de la asignatura " + a);
		} else {
			asignaturas.add(a);
		}
	}
	
	public void eliminaAsignatura(Asignatura a) {
		if (asignaturas.contains(a)) {
			throw new IllegalArgumentException("El alumno no está matriculado de la asignatura" + a);
		} else {
			asignaturas.remove(a);
		}
	}
	
	public Boolean estaMatriculado(Asignatura a) {
		Boolean res = false;
		if (asignaturas.contains(a)) {
			res = true;
		}
		return res;
	}
	
	/*
	 * La representación de un alumno será el número del curso seguido del carácter ‘º’, 
	 * entre paréntesis, seguido de un espacio y la representación como cadena de la persona. 
	 * Por ejemplo, "(1º) 28864657W – García Vaquero, Pascual – 15/09/1998”. Nota: hasta que no 
	 * se implemente la propiedad curso, use un interrogante (?) para representar el curso del alumno; 
	 * coloque un TODO para añadirlo más adelante.
	 */
	
	public String toString() {
		return "(" + getCurso() + "º) " + super.toString();
	}
	
	
	

}
