package fp.tipos;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
	
	List<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup);
	
	Integer calcularNumeroVinosDePaisConPuntuacionSuperior (String pais, Integer umbralPuntuacion);
	
	List<Vino> obtenerVinosBaratos(Double precio);
	
	Boolean existeVinoDeUvaEnRegion(String uva, String region);
	
	Set<String> calcularUvasDeRegion(String region);
	
	Integer calcularTotalPuntosVinosDeRegion(String region);
	
	Double calcularMediaPuntosVinosDeUva(String uva);
	
	Vino obtenerVinoMejorPuntuadoDePais(String pais);
	
	Vino obtenerVinoMejorPuntuado();
	
	List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer n);
	
	Map<String, List<Vino>> agruparVinosPorPais();
	
	Map<String, Set<String>> agruparUvasPorPais();
	
	Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double umbral);
	
	Map<String, Vino> calcularVinoMasCaroPorPais();
	
	Map<String, List<Vino>> calcularNMejoresVinosPorPais(Integer n);
	
	String calcularRegionConMejoresVinos(Double umbral);
	
	

}