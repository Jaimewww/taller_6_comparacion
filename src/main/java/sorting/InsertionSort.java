package sorting;
import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento por inserción.
 * @author Jaime Landázuri, Alejandro Padilla
 */

public final class InsertionSort {
    public static void sort(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        System.out.println("------------------------------------------------");

        // Se recorre desde el segundo elemento hasta el final
        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;

            System.out.println("Iteración " + i + " (Valor a insertar: " + key + ")");

            // Trazas de desplazamientos internos
            while (j >= 0 && array[j] > key){
                // Imprimir posiciones movidas
                System.out.println("  - Desplazando " + array[j] + " de la pos " + j + " a la " + (j + 1));

                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;

            // Imprimir arreglo resultante por iteración
            System.out.println("  [Arreglo tras iteración " + i + "]: " + Arrays.toString(array));
            System.out.println("------------------------------------------------");
        }
    }
}
