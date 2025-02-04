package fp.tipos;

/**
 * Enumeración que representa diferentes colores.
 * 
 * Un enum en Java es un tipo especial de clase que representa un grupo de constantes (variables que no cambian).
 * Los enums son útiles cuando se necesita representar un conjunto fijo de constantes, como días de la semana, 
 * estados de un proceso, direcciones (NORTE, SUR, ESTE, OESTE), etc.
 * 
 * En este caso, el enum Color define cuatro constantes: ROJO, VERDE, VIOLETA y MAGENTA.
 * Cada una de estas constantes es una instancia del enum Color.
 * 
 * Los enums en Java proporcionan varios beneficios:
 * - Seguridad de tipo: Los enums garantizan que solo se puedan usar valores válidos definidos en el enum.
 * - Legibilidad: Los enums hacen que el código sea más fácil de leer y entender.
 * - Funcionalidad adicional: Los enums pueden tener métodos, constructores y campos, lo que permite agregar 
 *   funcionalidad adicional si es necesario.
 */

public enum Color {
    ROJO, VERDE, VIOLETA, MAGENTA
}
