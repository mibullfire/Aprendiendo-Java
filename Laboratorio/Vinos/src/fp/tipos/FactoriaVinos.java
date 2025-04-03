package fp.tipos;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Fichero;

public class FactoriaVinos {
	private static final String DELIMITADOR = ",";
	
	private static Vino parsearVino(String linea){
		String [] splits = linea.split(DELIMITADOR);
		Checkers.check("Formato valido", splits.length==5);
		
		String pais = splits[0].trim();
		String region = splits[1].trim();
		Integer puntuacion = Integer.valueOf(splits[2].trim());
		Double precio = Double.valueOf(splits[3].trim());
		String uva = splits[4].trim();
		
		return new Vino(pais, region, puntuacion, precio, uva);
	}
	
	public static Vinoteca leerVinoteca(String ruta) {
		List<String> lineas = Fichero.leeLineas(ruta);
		lineas.remove(0);
		
		List<Vino> vinos = new ArrayList<Vino>();
		
		for (String linea: lineas) {
			Vino v = parsearVino(linea);
			vinos.add(v);
		}
		
		return new VinotecaBucles(vinos);
	}
}
