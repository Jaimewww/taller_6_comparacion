import sorting.InsertionSort;
import util.CsvReader;
import sorting.BubbleSort;
import sorting.SortStats;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase principal para ejecutar benchmarks de algoritmos de ordenamiento.
 * @author Jaime Landázuri, Alejandro Padilla
 */

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Cargando datos...");
            Double[] originalData = CsvReader.readDoubleColumn("src/main/java/resources/pacientes_500.csv", "prioridad");
            String type = "Duplicados"; // Depende del dataset cargado

            System.out.println("Datos cargados n: " + originalData.length + " elementos.");
            System.out.println("Tipo de datos del dataset: " + type);

            runBenchmark("Bubble Sort", originalData);

            runBenchmark("Insertion Sort", originalData);

            runBenchmark("Selection Sort", originalData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para ejecutar el benchmark de un algoritmo especifico
    public static void runBenchmark(String algorithmName, Double[] originalData) {
        int R = 10; // Repeticiones totales
        int discard = 3; // Primeras a descartar (calentamiento)
        List<Long> times = new ArrayList<>();
        SortStats lastStats = null;

        System.out.println("Iniciando benchmark para: " + algorithmName + "...");

        for (int i = 0; i < R; i++) {
            // Clonar el arreglo en cada iteración.
            // Si no se clona, en la 2da vuelta el arreglo ya estará ordenado y el tiempo será falso.
            Double[] dataCopy = Arrays.copyOf(originalData, originalData.length);

            SortStats stats = null;

            // Aquí seleccionamos qué algoritmo correr
            if (algorithmName.equals("Bubble Sort")) {
                stats = BubbleSort.sort(dataCopy);
            } else if (algorithmName.equals("Insertion Sort")) {
                stats = InsertionSort.sort(dataCopy);
            } else if (algorithmName.equals("Selection Sort")) {
                stats = sorting.SelectionSort.sort(dataCopy);
            }


            // Lógica de descarte y recolección
            if (i >= discard) {
                times.add(stats.timeNano);
            }

            // Guardamos una referencia a las estadísticas para obtener swaps/comps luego
            if (lastStats == null) lastStats = stats;
        }

        // Calcular Mediana
        Collections.sort(times); // Ordenar tiempos de menor a mayor
        long medianTime;
        int size = times.size();
        if (size % 2 == 0)
            medianTime = (times.get(size / 2) + times.get(size / 2 - 1)) / 2;
        else
            medianTime = times.get(size / 2);

        // Usamos los swaps/comparisons de una ejecución cualquiera (son deterministas)
        // pero usamos el tiempo mediano calculado.
        SortStats finalReport = new SortStats(algorithmName, lastStats.comparisons, lastStats.swaps, medianTime);
        finalReport.printSummary();
    }
}