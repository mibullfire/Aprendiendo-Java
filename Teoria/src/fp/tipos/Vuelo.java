package fp.tipos;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Vuelo {
	private String identificador;
	private Set<Persona> pasajeros;
	
	public Vuelo(String identificador, Set<Persona> pasajeros) {
		super();
		this.identificador = identificador;
		this.pasajeros = new HashSet<>(pasajeros);
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Set<Persona> getPasajeros() {
		return new HashSet<>(pasajeros);
	}

	public void setPasajeros(Set<Persona> pasajeros) {
		this.pasajeros = pasajeros;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(identificador, pasajeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(identificador, other.identificador) && Objects.equals(pasajeros, other.pasajeros);
	}

	@Override
	public String toString() {
		return "Vuelo [identificador=" + identificador + ", pasajeros=" + pasajeros + "]";
	}
	
	
	
	

}
