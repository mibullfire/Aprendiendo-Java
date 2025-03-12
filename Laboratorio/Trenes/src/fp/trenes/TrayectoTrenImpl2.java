package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class TrayectoTrenImpl2 implements TrayectoTren {
	private String codigoTren, nombre;
	private List <Parada> paradas;
	
	
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	
	@Override
	public String getCodigoTren() {
		return codigoTren;
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public List<String> getEstaciones() {
		return estaciones;
	}
	@Override
	public List<LocalTime> getHorasSalida() {
		return horasSalida;
	}
	@Override
	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}
	@Override
	public void eliminarEstacion() {
		
	}
	@Override
	public void aynadirEstacionIntermedia(int posicion, LocalTime horaLlegada, LocalTime horaSalida) {
		
	}
	@Override
	public Duration getDuracionTrayecto() {
		return null;
	}
	@Override
	public LocalTime getHoraSalida(String estacion) {
		return null;
	}
	@Override
	public LocalTime getHoraLlegada(String estacion) {
		return null;
	}
	@Override
	public LocalTime getHoraSalida() {
		return null;
	}
}
