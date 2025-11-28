package ed.u2.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DatasetBuilder {

    // Escribe un arreglo en un .txt con valores separados por espacios.
    private static void writeTXT(String path, int[] data) {
        try (FileWriter writer = new FileWriter(path)) {

            // Se escribe cada valor separado por espacio sin dejar uno extra al final.
            for (int i = 0; i < data.length; i++) {
                writer.write(data[i] + (i == data.length - 1 ? "" : " "));
            }

            System.out.println("Archivo generado: " + path);

        } catch (IOException e) {
            System.out.println("Error escribiendo " + path);
            e.printStackTrace();
        }
    }

    // Dataset A – valores mezclados (prioridad de pacientes).
    private static int[] buildDatasetA() {

        // Se extraen solo los números del ID (columna2): ej. "CITA-088" → 88.
        int[] data = CSVLoader.loadColumnAsIntArray("datasets/pacientes_500.csv", 2, false);

        // Solo se toman los primeros 100.
        return Arrays.copyOf(data, 100);
    }

    // Dataset B – orden descendente (stock del inventario).
    private static int[] buildDatasetB() {
        int[] data = CSVLoader.loadColumnAsIntArray("datasets/inventario_500_inverso.csv", 2, false);
        return Arrays.copyOf(data, 100);
    }

    // Dataset C – orden ascendente (IDs de citas).
    private static int[] buildDatasetC() {
        int[] data = CSVLoader.loadColumnAsIntArray("datasets/citas_100.csv", 0, true);

        // Asegura que el dataset quede ascendente.
        Arrays.sort(data);
        return data;
    }

    // Dataset D – casi ordenado.
    private static int[] buildDatasetD() {
        int[] data = CSVLoader.loadColumnAsIntArray("datasets/citas_100_casi_ordenadas.csv", 0, true);
        return data;
    }

    // Ejecuta la construcción y escritura de los cuatro datasets.
    public static void generateAll() {

        System.out.println("\n====== Generando datasets .txt desde CSV ======\n");

        writeTXT("datasets/datasetA.txt", buildDatasetA());
        writeTXT("datasets/datasetB.txt", buildDatasetB());
        writeTXT("datasets/datasetC.txt", buildDatasetC());
        writeTXT("datasets/datasetD.txt", buildDatasetD());

        System.out.println("\nDatasets generados correctamente.\n");
    }

    // Ejecutable rapido para generar los .txt usados en la clase SearchDemo
    public static void main(String[] args) {
        generateAll();
    }
}
