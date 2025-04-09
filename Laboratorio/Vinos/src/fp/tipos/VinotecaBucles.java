package fp.tipos;
import static java.util.Collections.max;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class VinotecaBucles implements Vinoteca {
	protected Set<Vino> vinos;
	
	public VinotecaBucles() {
		super();
		vinos = new HashSet<Vino>();
	}
	
	public VinotecaBucles(Collection<Vino> vinos) {
		super();
		this.vinos = new HashSet<>(vinos);
	}

	@Override
	public void agregarVino(Vino v) {
		vinos.add(v);
	}
	
	@Override
	public void eliminarVino(Vino v) {
		if (!vinos.contains(v)) {
			throw new IllegalArgumentException();
		}
		vinos.remove(v);
	}
	
	@Override
	public Integer obtenerNumeroVino() {
		return vinos.size();
	}
	
	@Override
	public Boolean contieneVino(Vino v) {
		return vinos.contains(v);
	}
	
	@Override
	public void agregarVinos(Collection<Vino> vinos) {
		vinos.addAll(vinos);
	}
	
	@Override
	public Boolean contieneVinos(Collection<Vino> vinos) {
		return vinos.containsAll(vinos);
	}
	
	public String toString() {
		return "[" + vinos.size() +"]";
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if(o instanceof Vinoteca) {
			Vinoteca vinoteca = (Vinoteca) o;
			//TODO No está resuelto. Está mal diseñado, propiedad no observable
			res = Objects.equals(this.obtenerNumeroVino(), vinoteca.obtenerNumeroVino()) && Objects.equals(true, vinoteca.contieneVinos(vinos));
		}
		return res;
	}
	
	public int hashCode() {
		return Objects.hash(obtenerNumeroVino(), vinos);
	}

	public Object getVinos() {
		return vinos;
	}

	//TRATAMIENTOS SECUENCIALES SIMPLES
	
	@Override
	public Integer calcularNumeroVinosPais(String pais) {
		List<Vino> vinosPais = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.pais().equals(pais)) {
				vinosPais.add(v);
			}
		}
		return vinosPais.size();
	}
	
	@Override
	public List<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup) {
		List<Vino> vinosRango = new ArrayList<Vino>();
		if (inf > sup) {
			throw new IllegalArgumentException("La cota inferior no puede ser mayor a la superior");
		}
		for (Vino v: vinos) {
			if (v.puntuacion() >= inf && v.puntuacion() <= sup) {
				vinosRango.add(v);
			}
		}
		return vinosRango;
	}
	
	@Override
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntuacion) {
		List<Vino> vinitos = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.pais().equals(pais) && v.puntuacion() >= umbralPuntuacion) {
				vinitos.add(v);
			}
		}
		return vinitos.size();
	}
	
	@Override
	public List<Vino> obtenerVinosBaratos(Double precio) {
		List<Vino> vinitos = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.precio() < precio) {
				vinitos.add(v);
			}
		}
		return vinitos;
	}
	
	@Override
	public Boolean existeVinoDeUvaEnRegion(String uva, String region) {
		List<Vino> vinitos = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.Uva().equals(uva) && v.region().equals(region)) {
				vinitos.add(v);
			}
		}
		return (vinitos.size()>0);
	}

	// TRATAMIENTOS SECUENCIALES DE ACUMULACION
	
	@Override
	public Set<String> calcularUvasDeRegion(String region) {
		List<Vino> filtrado = new ArrayList<Vino>();
		for(Vino v: vinos) {
			if(v.region().equals(region)) {
				filtrado.add(v);
			}
		}
		
		Set<String> res = new HashSet<String>();
		for (Vino v: filtrado) {
			res.add(v.Uva());
		}
		
;		return res;
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		List<Integer> puntos = new ArrayList<Integer>();
		for (Vino v: vinos) {
			if(v.pais().equals(region)) {
				puntos.add(v.puntuacion());
			}
		}
		return puntos.stream().collect(Collectors.summingInt(Integer::intValue));
	}
	
	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
	    Double result = 0.0;
	    Double res = 0.0;
	    for(Vino v: vinos) {
	      if(v.Uva().equals(uva)) {
	        result += v.puntuacion();
	        res += 1.0;
	      }
	    }
	    return result/res;
	  }
	
	// TRATAMIENTOS SECUENCIALES CON CREITERIO DE ORDENACION 
	
	@Override
	public Vino obtenerVinoMejorPuntuado() {
		Comparator<Vino> cmp = Comparator.comparing(Vino::puntuacion);
		return max(vinos, cmp);
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		Comparator<Vino> cmp = Comparator.comparing(Vino::puntuacion);
		List<Vino> vinitos = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.pais().equals(pais)) {
				vinitos.add(v);
			}
		}
		return max(vinitos, cmp);
	}

	@Override
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer n) {
		Comparator<Vino> cpm = Comparator.comparing(Vino::precio);
		List<Vino> vinitos = new ArrayList<Vino>();
		for (Vino v: vinos) {
			if (v.region().equals(region)) {
				vinitos.add(v);
			}
		}
		vinitos.sort(cpm);
		return vinitos.subList(0, n);
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
	
	private Integer cuentaCalidadesPrecio(List<Vino> lista, Double umbral) {
		List<Vino> res = new ArrayList<Vino>();
		for (Vino v: lista) {
			if(v.getCalidadPrecio()>=umbral) {
				res.add(v);
			}
		}
		return res.size();
	}

	@Override
	public Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double umbral) {
		Map<String, List<Vino>> agregacion = new HashMap<String, List<Vino>>();
		for (Vino v:vinos) {
			String key = v.region();
			if (agregacion.containsKey(key)) {
				agregacion.get(key).add(v);
			} else {
				List<Vino> lista = new ArrayList<Vino>();
				lista.add(v);
				agregacion.put(key, lista);
			}
		}
		
		Map<String, Integer> res = new HashMap<String, Integer>();
		for (String key: agregacion.keySet()) {
			res.put(key, cuentaCalidadesPrecio(agregacion.get(key), umbral));
		}
		return res;
	}

	@Override
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		Comparator<Vino> cmp = Comparator.comparing(Vino::precio);
		Map<String, List<Vino>> mapeado = new HashMap<>();
		for (Vino v: vinos) {
			mapeado.putIfAbsent(v.pais(), new ArrayList<>());
			mapeado.get(v.pais()).add(v);
		}
		Map<String, Vino> resultado = new HashMap<>();
		for (Map.Entry<String, List<Vino>> entry : mapeado.entrySet()) {
			resultado.put(entry.getKey(), entry.getValue().stream().max(cmp).orElse(null));
		}
		return resultado;
	}

	@Override
	public Map<String, List<Vino>> calcularNMejoresVinosPorPais(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calcularRegionConMejoresVinos(Double umbral) {
		Map<String, Integer> numeroVinosBuenosPorRegion = calcularCalidadPrecioPorRegionMayorDe(umbral);
		return max(numeroVinosBuenosPorRegion.keySet(), Comparator.comparing(region->numeroVinosBuenosPorRegion.get(region)).thenComparing(Comparator.naturalOrder()));
	}
	
	// TRATAMIENTOS SECUENCIALES CON MAP
	
	
	
}
