package fp.tipos;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class VinotecaStream extends VinotecaBucles implements Vinoteca {

	public VinotecaStream(Collection<Vino> coleccion_vinos) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer calcularNumeroVinosPais(String pais) {
		Long l = vinos.stream().filter(v->v.pais().equals(pais)).count();
		return l.intValue();
	}

	@Override
	public List<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup) {
		Checkers.check("La cota inferior no puede ser superior a la superior", inf<sup);
		return vinos.stream().filter(v->v.puntuacion()>inf&&v.puntuacion()<sup).toList();
	}

	@Override
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntuacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vino> obtenerVinosBaratos(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeVinoDeUvaEnRegion(String uva, String region) {
		// TODO Auto-generated method stub
		return vinos.stream().anyMatch(v->v.region().equals(region)&&v.Uva().equals(uva));
	}

	@Override
	public Set<String> calcularUvasDeRegion(String region) {
		// TODO Auto-generated method stub
		return vinos.stream().filter(v->v.region().equals(region)).map(Vino::Uva).collect(Collectors.toSet());
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		return vinos.stream().filter(v->v.region().equals(region)).mapToInt(Vino::puntuacion).sum();
	}

	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		return vinos.stream().filter(v->v.Uva().equals(uva)).mapToInt(Vino::puntuacion).average().orElse(0.);
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		return vinos.stream().filter(v->v.pais().equals(pais)).max(Comparator.comparing(Vino::puntuacion)).get();
	}

	@Override
	public Vino obtenerVinoMejorPuntuado() {
		return vinos.stream().max(Comparator.comparing(Vino::puntuacion)).get();
	}

	@Override
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer n) {
		return vinos.stream().filter(v->v.region().equals(region)).sorted(Comparator.comparing(Vino::precio)).limit(n).toList(); // o sublist(0, n)
	}

	@Override
	public Map<String, List<Vino>> agruparVinosPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<String>> agruparUvasPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double umbral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Vino>> calcularNMejoresVinosPorPais(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calcularRegionConMejoresVinos(Double umbral) {
		// TODO Auto-generated method stub
		return null;
	}


}
