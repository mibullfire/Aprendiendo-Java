package fp.tipos;
import static java.util.Collections.max;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class VinotecaBucles implements Vinoteca {
	private Set<Vino> vinos;
	
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
			res = Objects.equals(this.obtenerNumeroVino(), vinoteca.obtenerNumeroVino());
		}
		return res;
	}
	
	public int hashCode() {
		return this.obtenerNumeroVino().hashCode();
	}

	public Object getVinos() {
		return vinos;
	}

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
	public Vino obtenerVinoMejorPuntuado() {
		Comparator<Vino> cmp = Comparator.comparing(Vino::puntuacion);
		return max(vinos, cmp);
	}
}
