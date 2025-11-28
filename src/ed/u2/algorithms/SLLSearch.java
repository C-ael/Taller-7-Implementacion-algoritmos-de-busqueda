package ed.u2.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SLLSearch {

    // Recorre la lista desde el inicio y devuelve el primer índice donde aparece la clave, da -1 en caso de no encontrar
    public static int firstOccurrence(Node head, int key) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.value == key) return index;  // se detiene en la primera coincidencia
            current = current.next;
            index++;
        }
        return -1;  // no encontrado
    }

    // Recorre toda la lista y guarda el último índice donde aparece la clave
    public static int lastOccurrence(Node head, int key) {
        Node current = head;
        int index = 0;
        int last = -1;  // conserva la última coincidencia encontrada

        while (current != null) {
            if (current.value == key) last = index;  // no se detiene y sigue buscando más
            current = current.next;
            index++;
        }
        return last;
    }

    // Devuelve un arreglo con todos los índices donde aparece la clave
    public static int[] findAll(Node head, int key) {
        List<Integer> indices = new ArrayList<>();  // almacena todas las posiciones encontradas
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.value == key) indices.add(index);  // agrega todas las coincidencias
            current = current.next;
            index++;
        }

        // Conversión: pasar List<Integer> a int[]
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);  // posible error si la lista está vacía
        }

        return result;
    }
}
