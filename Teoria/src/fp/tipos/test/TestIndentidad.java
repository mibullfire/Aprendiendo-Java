package fp.tipos.test;
import fp.tipos.Videojuego;

public class TestIndentidad {
	public static void main(String[] args) {
		Videojuego v1 = new Videojuego("EA2024", "EA", 2024, 1500.0);
		Videojuego v2 = new Videojuego("EA2024", "EA", 2024, 1500.0);
		Videojuego v3 = v2;
		
		/*
		 * Each video game has an internal code
		 */
		System.out.println(v1 == v2);
		System.out.println(v3 == v2);
		
		/*
		 * To see if two objects have the same values, we need to see equals.
		 * To fix it, we need to rewrite the code and include hash code and equals on the class Videogame()
		 */
		System.out.println(v1.equals(v2));
		System.out.println(v3.equals(v2));
	}
}
