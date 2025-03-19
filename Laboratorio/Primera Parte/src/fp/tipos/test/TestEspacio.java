package fp.tipos.test;

import java.util.List;

import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.FactoriaUniversidad;

public class TestEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Espacio e = new Espacio("A0.10;0;100;TEORIA");
		System.out.println(e);
		
		List<Espacio> espacios = FactoriaUniversidad.leeEspacios("data/espacios.csv");
		System.out.println("Listado de espacios");
		espacios.stream().forEach(es->System.out.println(es));
		//System.out.println(espacios);

	}

}
