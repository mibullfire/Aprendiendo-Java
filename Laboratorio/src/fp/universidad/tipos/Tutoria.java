package fp.universidad.tipos;

import java.time.LocalTime;
import java.util.Objects;
import java.time.DayOfWeek;
import java.time.Duration;

public record Tutoria(DayOfWeek diaSemana, LocalTime comienzo, LocalTime fin) implements Comparable<Tutoria> {
	
	public Tutoria{
		checkDia(diaSemana);
		checkDuracion(duracion());
	}
	
	public String toString() {
		return convertirADiaEspanol() + " " + comienzo + "-" + fin;
	}
	
	public void checkDia(DayOfWeek diaSemana) {
		if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
			throw new IllegalArgumentException("Las tutorías deben de ser entre semana.");
		}
	}
	
	public void checkDuracion(Long duracion) {
		if (duracion < 15l) {
			throw new IllegalArgumentException("Las tutorías deben de ser almenos de 15 minutos.");
		}
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

	@Override
	public int hashCode() {
		return Objects.hash(comienzo, diaSemana);
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Tutoria) {
			Tutoria t = (Tutoria) o;
			res = Objects.equals(comienzo, t.comienzo) && Objects.equals(diaSemana, t.diaSemana);	
		}
		return res;
	}
	
	public int compareTo(Tutoria t) {
		int res;
		if (t == null) {
			throw new NullPointerException();
		}
		res = diaSemana.compareTo(t.diaSemana);
		if (res == 0) {
			res = comienzo.compareTo(t.comienzo);
		}
		return res;
	}
	
	

}
