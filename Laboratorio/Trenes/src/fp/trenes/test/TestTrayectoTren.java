package fp.trenes.test;
import java.time.LocalTime;

import fp.trenes.*;

public class TestTrayectoTren {
	public static void main(String[] args) {
		TrayectoTren trayecto1 = new TrayectoTrenImpl2("02471", "Sevilla-Madrid", TipoTren.AVE, "Sevilla Santa Justa", "Madrid Puerta Atocha",LocalTime.of(7, 0), LocalTime.of(10, 2));
		System.out.println(trayecto1);
	}
}
