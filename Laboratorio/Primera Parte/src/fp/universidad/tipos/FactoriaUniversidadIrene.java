package fp.universidad.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaUniversidadIrene {
	
	private static final String DELIMITADOR_AS = "#";
	private static final String DELIMITADOR_N = ",";
	
	public static List<Espacio> leeEspacios(String ruta) {
		List<Espacio> result = new ArrayList<Espacio>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", ruta);
		for(String linea:lineas) {
			result.add(creaEspacio(linea));
		}
		return result;	
	}

	public static Espacio creaEspacio(String s) {
		return new Espacio(s);
	}
	
	public static Despacho creaDespacho(String s) {
		
		return null;
	}
	
	public static Alumno creaAlumno(String s) {
		String [] splits = s.split(DELIMITADOR_N);
		
		Checkers.check("Numero splits erróneo", splits.length == 5);
		
		String dni = splits[0].trim();
		String nombre = splits[1].trim();  
		String apellidos = splits[2].trim();
		LocalDate fecha_nacimiento = LocalDate.parse(splits[3].trim());
		String email = splits[4].trim();
		
		return new Alumno(dni, nombre, apellidos, fecha_nacimiento, email);
	}
	
	public static Asignatura creaAsignatura(String s) {
		String [] splits = s.split(DELIMITADOR_AS);
		
		Checkers.check("Numero splits erróneo", splits.length == 5);
		
		String nombre = splits[0].trim();
		String codigo = splits[1].trim();
		Double creditos = Double.valueOf(splits[2].trim());
		TipoAsignatura tipo = TipoAsignatura.valueOf(splits[3].toUpperCase().trim());
		Integer curso = Integer.valueOf(splits[4].trim());
		
		return new Asignatura(nombre, codigo, creditos, tipo, curso);
	}
	
	public static Nota creaNota(String s) {
		String [] splits = s.split(DELIMITADOR_N);
		
		Checkers.check("Numero splits erróneo", splits.length == 5);
		
		Asignatura asignatura = creaAsignatura(splits[0].trim());
		Integer anyo = Integer.valueOf(splits[1].trim());
		Convocatoria convocatoria = Convocatoria.valueOf(splits[2].toUpperCase().trim());
		Double nota = Double.valueOf(splits[3].trim());
		Boolean mencion_honor = Boolean.valueOf(splits[4].trim());
		
		return new Nota(asignatura, anyo, nota, convocatoria, mencion_honor);
	}

}
