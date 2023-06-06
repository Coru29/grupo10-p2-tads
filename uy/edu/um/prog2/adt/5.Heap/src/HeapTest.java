import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void testInsertionAndFind() {
        Heap<Integer, String> cbt = new Heap<>();

        // Testeamos la inserción y la búsqueda de los nodos
        for (int i = 1; i <= 100; i++) {
            cbt.insert(i, "Node" + i);
            assertEquals("Node" + i, cbt.find(i));
        }

        // Testeamos que los elementos fueron insertados correctamente
        for (int i = 1; i <= 100; i++) {
            assertEquals("Node" + i, cbt.find(i));
        }

        // Testeamos que la búsqueda de un elemento que no existe retorna null
        assertNull(cbt.find(101));
    }

    @Test
    void testDeleteRoot() {
        Heap<Integer, String> cbt = new Heap<>();

        // Insertamos algunos elementos
        for (int i = 1; i <= 5; i++) {
            cbt.insert(i, "Node" + i);
        }

        // Eliminamos la raíz y comprobamos que ya no está en el árbol
        cbt.delete();
        assertNull(cbt.find(5)); // asumiendo que estás usando un Max-Heap

        // Comprobamos que el resto de los elementos siguen en el árbol
        for (int i = 1; i < 5; i++) {
            assertEquals("Node" + i, cbt.find(i));
        }
    }

    @Test
    void testDeleteSpecificNode() {
        Heap<Integer, String> cbt = new Heap<>();

        // Insertamos algunos elementos
        for (int i = 1; i <= 5; i++) {
            cbt.insert(i, "Node" + i);
        }

        // Eliminamos un nodo específico y comprobamos que ya no está en el árbol
        cbt.delete(3);
        assertNull(cbt.find(3));

        // Comprobamos que el resto de los elementos siguen en el árbol
        for (int i = 1; i <= 5; i++) {
            if (i != 3) {
                assertEquals("Node" + i, cbt.find(i));
            }
        }
    }


    @Test
    public void pruebaEliminarLlaveEspecifica() {
        Heap<Integer, String> heap = new Heap<>();

        heap.insert(10, "diez");
        heap.insert(20, "veinte");
        heap.insert(30, "treinta");
        heap.insert(40, "cuarenta");
        heap.insert(50, "cincuenta");
        heap.insert(60, "sesenta");
        heap.insert(70, "setenta");

        // Montículo antes de eliminar:
        // [70, 50, 60, 10, 40, 20, 30]

        heap.delete(40);

        // Montículo después de eliminar (40):
        // [70, 30, 60, 10, 50, 20]

        assertEquals("setenta", heap.find(70));
        assertNull(heap.find(40));  // 40 debería ser eliminada

        heap.delete(70);

        // Montículo después de eliminar (70):
        // [60, 30, 20, 10, 50]

        assertEquals("sesenta", heap.find(60));
        assertNull(heap.find(70));  // 70 debería ser eliminada
    }


    @Test
    void testToString() {
        Heap<Integer, String> cbt = new Heap<>();

        // Insertamos algunos elementos y comprobamos la representación del árbol en formato String
        for (int i = 1; i <= 5; i++) {
            cbt.insert(i, "Node" + i);
            String treeString = cbt.toString();
            assertTrue(treeString.contains("{Key: " + i + ", Value: Node" + i + "}"));
        }
    }
}
