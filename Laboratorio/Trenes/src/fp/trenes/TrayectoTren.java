package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public interface TrayectoTren extends Comparable<TrayectoTren> {
	
	String getCodigoTren();

	String getNombre();

	List<String> getEstaciones();

	List<LocalTime> getHorasSalida();

	List<LocalTime> getHorasLlegada();

	void eliminarEstacion(String estacion);

	void aynadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida);

	Duration getDuracionTrayecto();

	LocalTime getHoraSalida(String estacion);

	LocalTime getHoraLlegada(String estacion);

	LocalTime getHoraSalida();

	int compareTo(TrayectoTren o);

}