package fp.universidad.tipos;

import java.util.HashSet;

public class Despacho extends Espacio {
	
	private HashSet<Profesor> profesores;

	public Despacho(String nombre, Integer capacidad, HashSet<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad);
		this.profesores = profesores;
		checkCapacidad(profesores, capacidad);
	}
	
	public void setTipo() {
		throw new UnsupportedOperationException();	
	}
	
	private void checkCapacidad(HashSet<Profesor> profesores, Integer capacidad) {
		if (profesores.size() > capacidad) {
			throw new IllegalArgumentException("Se ha excedido la capacidad de profesores en este despacho, valor máximo: "+capacidad);
		}
	}

	public HashSet<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(HashSet<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	/*TODO
	 * El tipo Despacho debe dar flexibilidad a la hora de crear los objetos, por lo que deberá proporcionar tres constructores distintos. 
	 * El primer constructor creará un despacho a partir de los mismos parámetros que el constructor del tipo Espacio salvo el tipo, que se inicializará con el valor 'OTRO',
	 *  junto con un conjunto de profesores. El segundo constructor creará un despacho a partir de los mismos parámetros que el constructor del tipo Espacio salvo el tipo, 
	 *  que se inicializará con el valor 'OTRO', junto con un solo profesor. Finalmente, el tercer constructor creará un despacho a partir de los mismos parámetros que el
	 *   constructor del tipo Espacio salvo el tipo, que se inicializará con el valor 'OTRO'. En este caso el despacho no tendrá ningún profesor asignado.

Dos despachos son iguales si tienen el mismo nombre y están en la misma planta. Además, su ordenación natural coincide con la de cualquier otro espacio. Finalmente, 
un despacho tiene la misma representación que los espacios, seguida de los profesores que ocupan el despacho (utilice la representación como cadena de la propiedad profesores). 
Por ejemplo: "M2.25 (planta 2) [28200400P – Martín Oviedo, María – 21/05/1985 (TITULAR), 33123210J – Vegarredonda Ordiales, Jorge – 25/11/1990 (CONTRATADO_DOCTOR)]".
	 */
	
	
	
	
	

}
