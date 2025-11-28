package ed.u2.algorithms;

public class ArraySearch {

    // Busca la primera aparición de la clave
    public static int firstOccurrence(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    // Busca la última aparición de la clave
    public static int lastOccurrence(int[] a, int key) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    // Búsqueda secuencial clásica
    public static int sequential(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    // Búsqueda secuencial con centinela (evita revisar límites)
    public static int sequentialSentinel(int[] a, int key) {
        if (a.length == 0) return -1;

        int last = a[a.length - 1];
        a[a.length - 1] = key; // colocamos el centinela

        int i = 0;
        while (a[i] != key) i++;

        a[a.length - 1] = last; // restaurar valor final

        // verificar si fue solo el centinela
        if (i == a.length - 1 && last != key) return -1;

        return i;
    }

    // Búsqueda binaria (array debe estar ordenado)
    public static int binary(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == key) return mid;
            if (key < a[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
