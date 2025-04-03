package fp.tipos;

import fp.utiles.Checkers;

public record Vino(String pais, String region, Integer puntuacion, Double precio, String Uva) {
	
	public Vino {
		Checkers.check("Puntuacion no valida", puntuacion >= 0 && puntuacion <= 100);
		Checkers.check("El precio tiene que ser mayor a cero", precio > 0);
	}
	
	public Double getCalidadPrecio() {
		return puntuacion/precio;
	}
}
