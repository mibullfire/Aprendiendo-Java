package fp.universidad.tipos;

import java.time.LocalTime;
import java.util.Objects;
import java.time.DayOfWeek;
import java.time.Duration;

public record Tutoria(DayOfWeek diaSemana, LocalTime comienzo, LocalTime fin) implements Comparable<Tutoria> {
	
	public Tutoria{
		checkDia(diaSemana);
		checkDuracion(comienzo, fin);
	}
	
	public Tutoria(DayOfWeek dia, Integer duracion, LocalTime comienzo) {
		this(dia, comienzo, comienzo.plusMinutes(duracion));
	}
	
	public String toString() {
		return convertirADiaEspanol() + " " + comienzo + "-" + fin;
	}
	
	public void checkDia(DayOfWeek diaSemana) {
		if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
			throw new IllegalArgumentException("Las tutorías deben de ser entre semana.");
		}
	}
	
	private void checkDuracion(LocalTime comienzo, LocalTime fin) {
		if (Duration.between(comienzo, fin).toMinutes() < 15) {
			throw new IllegalArgumentException("Las tutorías deben ser al menos de 15 minutos.");
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
	
	public Integer duracion() {
		Duration duracion = Duration.between(comienzo, fin);
		Long l = duracion.toMinutes();
		return l.intValue();
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
