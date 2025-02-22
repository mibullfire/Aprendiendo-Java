package fp.tipos.test;

public class TestException {
    public static void main(String... args) {

        try {
            Integer i = 2/0;
            // throw new IllegalStateException();

        } catch(Exception e) {
            System.out.println("Se ha lanzado una excepción");
        } finally {
            System.out.println("Después de la excepción");
        }

    }
    
}
