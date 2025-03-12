package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrayectoTrenImpl2 implements TrayectoTren {
	private String codigoTren, nombre;
	private TipoTren tipo;
	private List <Parada> paradas;

	public TrayectoTrenImpl2(String codigoTren, String nombre, TipoTren tipo, String origen, String fin, LocalTime horaSalida, LocalTime horaLlegada) {
		this.codigoTren = codigoTren;
		this.nombre = nombre;
		this.paradas = new ArrayList<Parada>();
		Parada ori = new Parada(origen, null, horaSalida);
		Parada fi = new Parada(fin, horaLlegada, null);
		this.paradas.add(ori); this.paradas.add(fi);
		checkCodigo(codigoTren);
		checkNoNull(horaLlegada);
		checkNoNull(horaSalida);
		checkHoras(horaSalida, horaLlegada);
	}
	
	public void checkHoras(LocalTime horaSalida, LocalTime horaLlegada) {
		if (horaSalida.isAfter(horaLlegada)) {
			throw new IllegalArgumentException("La hora de salida no puede ser después de la hora de llegada.");
		}
	}
	public void checkNoNull(LocalTime parametro) {
		if (parametro == null) {
			throw new IllegalArgumentException("La hora no puede ser nula.");
		}
	}

	public void checkCodigo(String codigo) {
		if (codigo.length()!=5 && Character.isDigit(codigo.charAt(0))
				&& Character.isDigit(codigo.charAt(1))
				&& Character.isDigit(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3))
				&& Character.isDigit(codigo.charAt(4))) {
			throw new IllegalArgumentException("El código debe contener solo dígitos y ser de longitud 5");
		}
	}
	
	public TipoTren getTipo() {
		return tipo;
	}
	public String getCodigoTren() {
		return codigoTren;
	}
	public String getNombre() {
		return nombre;
	}
	public List<String> getEstaciones() {
		List<String> res = new ArrayList<String>();
		for (Parada p: paradas) {
			res.add(p.estacion());
		}
		return res;
	}
	public List<LocalTime> getHorasSalida() {
		List<LocalTime> res = new ArrayList<LocalTime>();
		for (Parada p: paradas) {
			res.add(p.horaSalida());
		}
		return res;
	}
	public List<LocalTime> getHorasLlegada() {
		List<LocalTime> res = new ArrayList<LocalTime>();
		for (Parada p: paradas) {
			res.add(p.horaLlegada());
		}
		return res;
	}
	public Duration getDuracionTrayecto() {
		LocalTime horaSalida = getHoraSalida();
		LocalTime horaLlegada = getHoraLlegada();
		return Duration.between(horaSalida, horaLlegada);
	}
	public LocalTime getHoraSalida() {
		return paradas.get(0).horaSalida();
	}
	public LocalTime getHoraLlegada() {
		return paradas.get(paradas.size()-1).horaLlegada();
	}
	public LocalTime getHoraSalida(String estacion) {
		Parada res = null;
		for (Parada p: paradas) {
			if (p.estacion().equals(estacion)) {
				res = p;
				break;
			}
		}
		return res.horaSalida();
	}
	public LocalTime getHoraLlegada(String estacion) {
		Parada res = null;
		for (Parada p: paradas) {
			if (p.estacion().equals(estacion)) {
				res = p;
				break;
			}
		}
		return res.horaLlegada();
	}
	
	public void eliminarEstacion(String estacion) {
		Parada parada = null;
		for (Parada p: paradas) {
			if (p.estacion().equals(estacion)) {
				parada = p;
			}
		}
		paradas.remove(parada);
		
	}
	//TODO Añadir las excepciones y restricciones:
	public void aynadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Parada p = new Parada(estacion, horaLlegada, horaSalida);
		paradas.add(posicion, p);
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoTren, nombre, paradas, tipo);
	}


	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof TrayectoTren) {
			TrayectoTren other = (TrayectoTren) obj;
			res = Objects.equals(getHoraSalida(), other.getHoraSalida()) && Objects.equals(codigoTren, other.getCodigoTren())
					&& Objects.equals(nombre, other.getNombre());
		}
		return res;
	}


	@Override
	public int compareTo(TrayectoTren t) {
		int res = nombre.compareTo(t.getNombre());
		if (res == 0) {
			res = getHoraSalida().compareTo(t.getHoraSalida());
		} if (res == 0) {
			res = codigoTren.compareTo(t.getCodigoTren());
		}
		return 0;
	}


	@Override
	public String toString() {
		String res = nombre + "-" + tipo + "(" + codigoTren +")\n";
		for (Parada p : paradas) {
			LocalTime horaLlegada = p.horaLlegada();
			res += p.estacion()+"\t"+(horaLlegada==null?"":horaLlegada)+"\t"+p.horaSalida()+"\n";
		}
		return res;
	}
	
}
