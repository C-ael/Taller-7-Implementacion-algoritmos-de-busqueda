package ed.u2.utils;

import ed.u2.algorithms.Node;

// utilidades para imprimir datasets (arreglo y SLL)
public class PrintUtils {

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    public static void printSLL(Node head) {
        Node current = head;

        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println(" ]");
    }
}
