package ed.u2.algorithms;

public class Node {
    public int value;   // el dato que guarda el nodo
    public Node next;   // referencia al siguiente nodo

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
