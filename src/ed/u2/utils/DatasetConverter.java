package ed.u2.utils;

import ed.u2.algorithms.Node;

public class DatasetConverter {

    // convierte int[] → SLL (Node)
    public static Node toSLL(int[] data) {

        if (data.length == 0)
            return null;

        Node head = new Node(data[0]);
        Node current = head;

        // construir la cadena de nodos
        for (int i = 1; i < data.length; i++) {
            current.next = new Node(data[i]);
            current = current.next;
        }

        return head;
    }
}
