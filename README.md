Entendido. Es probable que las referencias de citación (\`\`) incluidas dentro del bloque de código anterior hayan interferido con el formato Markdown puro que necesitas para tu archivo.

A continuación, presento el contenido del `README.md` limpio, sin etiquetas de citación internas, listo para copiar y guardar en tu proyecto.

-----

````markdown
# Taller 6: Comparación de Algoritmos de Ordenamiento

Este proyecto tiene como objetivo realizar una comparación empírica del rendimiento de tres algoritmos de ordenamiento clásicos ($O(n^2)$). La aplicación carga datos reales desde archivos CSV, ejecuta benchmarks controlados y genera estadísticas detalladas sobre el comportamiento de cada algoritmo.

## Objetivo del Proyecto

El propósito principal es analizar cómo se comportan diferentes algoritmos de ordenamiento al procesar conjuntos de datos numéricos y fechas (timestamps). Para garantizar mediciones precisas, el sistema implementa:

* **Métricas de Eficiencia:** Medición de tiempo de ejecución (nanosegundos), número de comparaciones y cantidad de intercambios (swaps).
* **Metodología:** Ejecución de múltiples repeticiones (10 iteraciones), descarte de "calentamiento" (warm-up de 3 iteraciones) y cálculo de la **mediana** del tiempo para evitar ruido del sistema (Garbage Collector, JIT, etc.).
* **Aislamiento:** Carga de datos separada de la medición del algoritmo.

## Algoritmos Implementados

El proyecto compara las siguientes implementaciones optimizadas para la clase `Double`:

1.  **Bubble Sort:** Ordenamiento de burbuja con optimización de bandera (`swapped`) para detectar si el arreglo ya está ordenado.
2.  **Insertion Sort:** Ordenamiento por inserción, ideal para arreglos pequeños o parcialmente ordenados.
3.  **Selection Sort:** Ordenamiento por selección, que minimiza el número de intercambios.

## Requisitos Previos

* **Java JDK:** Versión 17 o superior (Recomendado 21 según configuración del proyecto).
* **Apache Maven:** Para la gestión de dependencias y construcción del proyecto.

## Dependencias

Este proyecto utiliza la librería **Apache Commons CSV** para el parseo robusto de los archivos de entrada (En este caso, el separador es el caracter ";").

En el archivo `pom.xml`:
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.14.1</version>
</dependency>
````

## ⚙️ Instalación y Compilación

1.  **Clonar el repositorio** (o descargar los archivos):

    ```bash
    git clone https://github.com/Jaimewww/taller_6_comparacion.git
    cd taller_6_comparacion
    ```

2.  **Compilar el proyecto y descargar dependencias:**
    Ejecuta el siguiente comando en la raíz del proyecto (donde está el `pom.xml`):

    ```bash
    mvn clean install
    ```

## Ejecución

Existen dos formas de ejecutar el proyecto:

### Opción A: Desde IntelliJ IDEA / Eclipse (Recomendado)

1.  Abre el proyecto como "Maven Project".
2.  Espera a que se indexen las dependencias.
3.  Navega a `src/main/java/Main.java`.
4.  Haz clic derecho y selecciona **Run 'Main.main()'**.

### Opción B: Desde Línea de Comandos (Maven)

Puedes ejecutar la clase principal directamente usando el plugin `exec-maven-plugin`. Asegúrate de estar en la carpeta raíz del proyecto:

```bash
mvn exec:java -Dexec.mainClass="Main"
```

*Nota: Si cambiaste la clase `Main` a un paquete específico (ej. `main.Main`), actualiza el comando anterior.*

## 📂 Estructura de Datos (CSV)

El proyecto incluye una utilidad `CsvReader` capaz de leer columnas de archivos CSV delimitados por punto y coma (`;`). Soporta:

* **Números:** `1`, `2`, `500`
* **Fechas ISO 8601:** `2025-03-03T09:15` (se convierten automáticamente a Timestamps Unix para ser ordenadas).

Archivos de prueba incluidos en `src/main/java/resources/`:

* `pacientes_500.csv`: Datos de prioridad de pacientes.
* `pacientes_500_casi_ordenados.csv`: Datos casi ordenados.
* `citas_100.csv`: Fechas y horas de citas médicas.
* `inventario_500_inverso.csv`: Datos de stock ordenados inversamente.

## Ejemplo de Salida

Al ejecutar el programa, verás un resumen estadístico como este:

```text
Cargando datos...
Datos cargados n: 500 elementos.
Tipo de datos del dataset: Duplicados
Iniciando benchmark para: Bubble Sort...

--- Resumen: Bubble Sort ---
Tiempo (mediana): 1254300 ns (1.2543 ms)
Comparaciones   : 124750
Intercambios    : 62300
------------------------------

Iniciando benchmark para: Insertion Sort...
--- Resumen: Insertion Sort ---
Tiempo (mediana): 450200 ns (0.4502 ms)
Comparaciones   : 62300
Intercambios    : 62300
------------------------------

Iniciando benchmark para: Selection Sort...
```

## Autores

* **Jaime Landázuri**
* **Alejandro Padilla**

<!-- end list -->
```