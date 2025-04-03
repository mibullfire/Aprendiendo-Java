package fp.utiles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Fichero {
	public static List<String> leeLineas(String ruta) {
		List<String> lineas = new ArrayList<String>();
		try {
			lineas = Files.readAllLines(Paths.get(ruta));
		} catch (Exception e) {
			throw new IllegalArgumentException("La ruta del fichero no es valida");
		}
		return lineas;
	}
}
