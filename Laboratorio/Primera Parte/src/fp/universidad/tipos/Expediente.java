package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;

public class Expediente {
    
    private HashSet<Nota> notas;
    
    public Expediente() {
        this.notas = new HashSet<>();
    }
    
    public HashSet<Nota> getNotas() {
        return notas;
    }
    
    public Double getNotaMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        Double suma = 0.0;
        for (Nota nota : notas) {
            suma += nota.nota();
        }
        return suma / notas.size();
    }
    
    public void nuevaNota(Nota n) {
    	for (Nota nota : notas) {
    		if (nota.equals(n)) {
    			notas.remove(nota);
    		}
    	}
    	notas.add(n);
    }

	@Override
	public String toString() {
		return "[" + notas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(notas);
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Expediente) {
			Expediente e = (Expediente) o;
			res = Objects.equals(getNotas(), e.getNotas());
		}
		return res;
	}
    
    
}
