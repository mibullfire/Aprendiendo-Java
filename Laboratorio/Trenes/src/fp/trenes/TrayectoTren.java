package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public interface TrayectoTren {

	String getCodigoTren();

	String getNombre();

	List<String> getEstaciones();

	List<LocalTime> getHorasSalida();

	List<LocalTime> getHorasLlegada();

	void eliminarEstacion();

	void aynadirEstacionIntermedia(int posicion, LocalTime horaLlegada, LocalTime horaSalida);

	Duration getDuracionTrayecto();

	LocalTime getHoraSalida(String estacion);

	LocalTime getHoraLlegada(String estacion);

	LocalTime getHoraSalida();

}