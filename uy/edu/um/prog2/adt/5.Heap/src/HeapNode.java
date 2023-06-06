public class HeapNode<K extends Comparable<K>, V> implements Comparable<HeapNode<K, V>> {
    K key;
    V value;
    HeapNode<K, V> leftChild;
    HeapNode<K, V> rightChild;

    HeapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public int compareTo(HeapNode<K, V> otherNode) {
        return this.key.compareTo(otherNode.key);
    }
}
