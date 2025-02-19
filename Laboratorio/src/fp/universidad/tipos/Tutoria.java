package fp.universidad.tipos;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.Duration;

public record Tutoria(DayOfWeek diaSemana, LocalTime comienzo, LocalTime fin) {
	public String toString() {
		return convertirADiaEspanol() + " " + comienzo + "-" + fin;
	}
	
	private String convertirADiaEspanol() {
		DayOfWeek x = diaSemana;
        return switch (x) {
            case MONDAY -> "L";
            case TUESDAY -> "M";
            case WEDNESDAY -> "X";
            case THURSDAY -> "J";
            case FRIDAY -> "V";
            case SATURDAY -> "S";
            case SUNDAY -> "D";
        };
	}
	
	public Long duracion() {
		Duration duracion = Duration.between(comienzo, fin);
		Long duracionx = duracion.toMinutes();
		return duracionx;
		/*
		int minutosComienzo = comienzo.getHour() * 60 + comienzo.getMinute();
		int minutosFin = fin.getHour() * 60 + fin.getMinute();
		return minutosFin - minutosComienzo;
		*/
	}

}
