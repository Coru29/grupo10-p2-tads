import LinkedList.LL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
class TreeBSTTest {

    @org.junit.jupiter.api.Test
    void find() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
        TreeBST<String, String> tree = new TreeBST<>();

        tree.insert("3", "root");
        tree.insert("2", "izquierdo");
        tree.insert("4", "derecho");

        assertEquals("root", tree.find("3"));
        assertEquals("izquierdo", tree.find("2"));
        assertEquals("derecho", tree.find("4"));
    }

    @Test
    void delete() {
        TreeBST<String, String> tree = new TreeBST<>();


        tree.insert("5", "nodo5");
        tree.insert("3", "nodo3");
        tree.insert("7", "nodo7");
        tree.insert("2", "nodo2");
        tree.insert("4", "nodo4");
        tree.insert("6", "nodo6");
        tree.insert("8", "nodo8");

        assertEquals("nodo5", tree.find("5"));
        assertEquals("nodo3", tree.find("3"));
        assertEquals("nodo7", tree.find("7"));
        assertEquals("nodo2", tree.find("2"));
        assertEquals("nodo4", tree.find("4"));
        assertEquals("nodo6", tree.find("6"));
        assertEquals("nodo8", tree.find("8"));

        tree.delete("5");
        assertNull(tree.find("5"));
        assertEquals("nodo6", tree.find("6"));

        tree.delete("3");
        assertNull(tree.find("3"));
        assertEquals("nodo4", tree.find("4"));

        tree.delete("7");
        assertNull(tree.find("7"));
        assertEquals("nodo8", tree.find("8"));

        tree.delete("2");
        assertNull(tree.find("2"));

        tree.delete("4");
        assertNull(tree.find("4"));

        tree.delete("6");
        assertNull(tree.find("6"));

        tree.delete("8");
        assertNull(tree.find("8"));
    }

    @Test
    public void testPreOrder() {
        TreeBST<String, String> tree = new TreeBST<>();

        tree.insert("5", "nodo5");
        tree.insert("3", "nodo3");
        tree.insert("7", "nodo7");
        tree.insert("2", "nodo2");
        tree.insert("4", "nodo4");
        tree.insert("6", "nodo6");
        tree.insert("8", "nodo8");

        LL<String> expectedPreOrder = new LL<>();
        expectedPreOrder.add("5");
        expectedPreOrder.add("3");
        expectedPreOrder.add("2");
        expectedPreOrder.add("4");
        expectedPreOrder.add("7");
        expectedPreOrder.add("6");
        expectedPreOrder.add("8");

        expectedPreOrder.get(0);

        assertEquals(expectedPreOrder.get(0), tree.preOrder().get(0));
        assertEquals(expectedPreOrder.get(1), tree.preOrder().get(1));
        assertEquals(expectedPreOrder.get(2), tree.preOrder().get(2));
        assertEquals(expectedPreOrder.get(3), tree.preOrder().get(3));
        assertEquals(expectedPreOrder.get(4), tree.preOrder().get(4));
        assertEquals(expectedPreOrder.get(5), tree.preOrder().get(5));
        assertEquals(expectedPreOrder.get(6), tree.preOrder().get(6));

    }

    @Test
    public void testInOrder() {
        TreeBST<String, String> tree = new TreeBST<>();

        tree.insert("5", "nodo5");
        tree.insert("3", "nodo3");
        tree.insert("7", "nodo7");
        tree.insert("2", "nodo2");
        tree.insert("4", "nodo4");
        tree.insert("6", "nodo6");
        tree.insert("8", "nodo8");

        LL<String> expectedInOrder = new LL<>();
        expectedInOrder.add("2");
        expectedInOrder.add("3");
        expectedInOrder.add("4");
        expectedInOrder.add("5");
        expectedInOrder.add("6");
        expectedInOrder.add("7");
        expectedInOrder.add("8");

        assertEquals(expectedInOrder.get(0), tree.inOrder().get(0));
        assertEquals(expectedInOrder.get(1), tree.inOrder().get(1));
        assertEquals(expectedInOrder.get(2), tree.inOrder().get(2));
        assertEquals(expectedInOrder.get(3), tree.inOrder().get(3));
        assertEquals(expectedInOrder.get(4), tree.inOrder().get(4));
        assertEquals(expectedInOrder.get(5), tree.inOrder().get(5));
        assertEquals(expectedInOrder.get(6), tree.inOrder().get(6));
    }

    @Test
    public void testPostOrder() {
        TreeBST<String, String> tree = new TreeBST<>();

        tree.insert("5", "nodo5");
        tree.insert("3", "nodo3");
        tree.insert("7", "nodo7");
        tree.insert("2", "nodo2");
        tree.insert("4", "nodo4");
        tree.insert("6", "nodo6");
        tree.insert("8", "nodo8");

        LL<String> expectedPostOrder = new LL<>();
        expectedPostOrder.add("2");
        expectedPostOrder.add("4");
        expectedPostOrder.add("3");
        expectedPostOrder.add("6");
        expectedPostOrder.add("8");
        expectedPostOrder.add("7");
        expectedPostOrder.add("5");

        assertEquals(expectedPostOrder.get(0), tree.postOrder().get(0));
        assertEquals(expectedPostOrder.get(1), tree.postOrder().get(1));
        assertEquals(expectedPostOrder.get(2), tree.postOrder().get(2));
        assertEquals(expectedPostOrder.get(3), tree.postOrder().get(3));
        assertEquals(expectedPostOrder.get(4), tree.postOrder().get(4));
        assertEquals(expectedPostOrder.get(5), tree.postOrder().get(5));
        assertEquals(expectedPostOrder.get(6), tree.postOrder().get(6));
    }


    @Test
    void countLeaf() {
        TreeBST<Integer, String> bst = new TreeBST<>();

        // Insertamos datos en el árbol
        bst.insert(8, "Node1");
        bst.insert(3, "Node2");
        bst.insert(10, "Node3");
        bst.insert(1, "Node4");
        bst.insert(6, "Node5");
        bst.insert(14, "Node6");
        bst.insert(4, "Node7");
        bst.insert(7, "Node8");
        bst.insert(13, "Node9");

        // En este árbol, los nodos con claves 1, 4, 7 y 13 son hojas.
        assertEquals(4, bst.countLeaf());
    }

    @Test
    void countCompleteElements() {
        TreeBST<Integer, String> bst = new TreeBST<>();

        // Insertamos datos en el árbol
        bst.insert(8, "Node1");
        bst.insert(3, "Node2");
        bst.insert(10, "Node3");
        bst.insert(1, "Node4");
        bst.insert(6, "Node5");
        bst.insert(14, "Node6");
        bst.insert(4, "Node7");
        bst.insert(7, "Node8");
        bst.insert(13, "Node9");

        // En este árbol, los nodos con claves 8, 3 y 10 son nodos completos (tienen ambos hijos).
        assertEquals(3, bst.countCompleteElements());
    }


}