package fp.universidad.tipos;

public record Nota(Asignatura asignatura, Integer curso, Double nota, Convocatoria convocatoria, Boolean honor) {
	
	public Nota {
		if (nota < 0 || nota > 10) {
			throw new IllegalArgumentException("La nota debe estar entre 0 y 10.");
		}
		if (nota < 9 && honor == true){
			throw new IllegalArgumentException("No puedes dar una matrícula a alguien con menos de 9 de nota.");
		}
	}
	public Nota(Asignatura asignatura, Integer curso, Double nota, Convocatoria convocatoria) {
        this(asignatura, curso, nota, convocatoria, false);
    }
	
	public Calificacion calificacion() {
		if (nota >= 9 && honor == false) {
			return Calificacion.SOBRESALIENTE;
		} else if (nota >= 9 && honor == true){
			return Calificacion.MATRICULA_HONOR;
		} else if (nota >= 7) {
			return Calificacion.NOTABLE;
		} else if (nota >= 5) {
			return Calificacion.APROBADO;
		} else {
			return Calificacion.SUSPENSO;
		}
	}

	public String cursoAcademico(){
		return curso + "-" + (curso % 100 + 1); // Para obtener las dos últimas cifras, obtenemos el resto de dividir entre 100
	}
	
	public String toString() {
		return "(" + asignatura.codigo() + ") " + asignatura.nombre() + ", " + cursoAcademico() + ", " + convocatoria + ", " + nota + ", " + calificacion();
	}
	
}
