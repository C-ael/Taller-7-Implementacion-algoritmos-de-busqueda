package ed.u2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    // Lee una columna específica de un CSV y la devuelve como int[].
    public static int[] loadColumnAsIntArray(String file, int columnIndex, boolean extractNumber) {

        List<Integer> values = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Algunos CSV incluyen el caracter BOM al inicio. Lo retiramos para evitar errores
                if (line.startsWith("\uFEFF")) {
                    line = line.substring(1);
                }

                // Detecta el separador más probable entre ';' y ','
                // Esta línea evita fallos cuando un CSV usa otro delimitador inesperado
                String separator = line.contains(";") ? ";" : line.contains(",") ? "," : ";";

                String[] parts = line.split(separator);

                // Si la columna no existe en esa fila se ignora
                if (columnIndex >= parts.length) continue;

                String raw = parts[columnIndex].trim();

                // Si se activa, extrae solo los números de cadenas tipo: "CITA-066" → "066"
                if (extractNumber) {
                    raw = raw.replaceAll("[^0-9]", "");
                }

                // Si la celda quedó vacía, no se agrega nada
                if (raw.isEmpty()) continue;

                try {
                    values.add(Integer.parseInt(raw));
                } catch (NumberFormatException ignored) {
                    // Fila con datos no numéricos (simplemente se descarta)
                }
            }

        } catch (Exception e) {
            System.out.println("Error leyendo CSV: " + file);
            e.printStackTrace();
        }

        // Conversión de List<Integer> a int[]
        return values.stream().mapToInt(i -> i).toArray();
    }
}
