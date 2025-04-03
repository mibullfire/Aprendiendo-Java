package fp.tipos;

import java.util.Collection;
import java.util.Set;

public interface Vinoteca {

	void agregarVino(Vino v);

	void eliminarVino(Vino v);

	Integer obtenerNumeroVino();

	Boolean contieneVino(Vino v);

	void agregarVinos(Collection<Vino> vinos);

	Boolean contieneVinos(Collection<Vino> vinos);

	Object getVinos();
	
	Integer calcularNumeroVinosPais(String pais);
	
	Set<String> calcularUvasDeRegion(String region);
	
	Vino obtenerVinoMejorPuntuado();

}