package sorting;

import java.util.Arrays;

/**
* Implementacion de bubblesort (Ordenamiento por burbuja) para arreglos de int
* @author Jaime Landazuri, Alejandro Padilla
*/

public class BubbleSort {
    public static void sort(int[] array) {
        // Validación básica
        if (array == null) return;

        System.out.println("Estado inicial: " + Arrays.toString(array));
        System.out.println("------------------------------------------------");

        int length = array.length;
        boolean hasSwaps;
        int totalSwaps = 0; // Contador global de swaps (intercambios)
        int passCounter = 1; // Contador de pasadas

        // El bucle externo reduce el rango en cada pasada
        for (int i = length - 1; i > 0; i--) {

            hasSwaps = false;
            System.out.println("Pasada " + passCounter + " (Burbujeando hasta índice " + i + "):");

            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // Imprimimos el detalle ANTES del swap para ver qué se mueve
                    System.out.println("  -> Swap: " + array[j] + " > " + array[j + 1] +
                            " (índices " + j + " y " + (j + 1) + ")");

                    SortUtils.swap(j, j + 1, array);

                    hasSwaps = true;
                    totalSwaps++;
                }
            }

            // Imprimimos el estado del arreglo al terminar esta pasada
            System.out.println("  [Arreglo tras Pasada " + passCounter + "]: " + Arrays.toString(array));

            // OPTIMIZACIÓN: Corte temprano
            if (!hasSwaps) {
                System.out.println("  > No hubo cambios, arreglo ordenado.");
                System.out.println("------------------------------------------------");
                break;
            }

            System.out.println("------------------------------------------------");
            passCounter++;
        }

        System.out.println("Arreglo final ordenado: " + Arrays.toString(array));
        System.out.println("Total de intercambios realizados: " + totalSwaps);
    }
}