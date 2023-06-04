public class Node<T extends Comparable<T>> {

    public T data;
    public Node<T> next;

    public int priority;

    public Node(T data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

}
