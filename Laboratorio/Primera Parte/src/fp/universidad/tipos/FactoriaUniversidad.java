package fp.universidad.tipos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaUniversidad {
	
	private static final String DELIMITADOR_ASIG = "#";
	
	public static List<Espacio> leeEspacios(String ruta){
		List<Espacio> res = new ArrayList<Espacio>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ruta));
			for (String linea: lineas) {
				res.add(creaEspacio(linea));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	
	public static Espacio creaEspacio(String s) {
		return new Espacio(s);
		
	}
	
	
	public static Asignatura creaAsignatura(String s) {
		//"Fundamentos de Programacion#1234567#12.0#ANUAL#1"
		String[] splits = s.split(DELIMITADOR_ASIG);
		Checkers.check("Formato cadena no válida", splits.length==5);
		String nombre = splits[0].trim();
		String codigo = splits[1].trim();
		Double creditos = Double.valueOf(splits[2].trim());
		TipoAsignatura tipo = TipoAsignatura.valueOf(splits[3].trim());
		Integer curso = Integer.valueOf(splits[4].trim());
		
		return new Asignatura(nombre, codigo, creditos, tipo, curso);
	}
}
