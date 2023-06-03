import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearProbingHashTableTest {
    private LinearProbingHashTable<Integer, String> hashTable;

    @BeforeEach //antes de cada test hace una nueva tabla
    void setUp() {
        hashTable = new LinearProbingHashTable<>();
    }

    @Test
    void put() {
        // Prueba agregar un elemento.
        hashTable.put(1, "One");
        assertTrue(hashTable.contains(1));
        assertEquals("One", hashTable.get(1));

        // Prueba sobrescribir un elemento.
        hashTable.put(1, "New One");
        assertTrue(hashTable.contains(1));
        assertEquals("New One", hashTable.get(1));

        // Prueba agregar múltiples elementos.
        for (int i = 2; i < 100; i++) {
            hashTable.put(i, "Number " + i);
        }

        // Prueba que todos los elementos estén presentes.
        // Este bucle comienza en 2, porque ya hemos verificado la clave 1 arriba.
        for (int i = 2; i < 100; i++) {
            assertTrue(hashTable.contains(i));
            assertEquals("Number " + i, hashTable.get(i));
        }
        // Verifica nuevamente el valor de la clave 1.
        assertEquals("New One", hashTable.get(1));


    }

    @Test
    void remove() {
        // Añadir elementos a la tabla hash
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");

        // Prueba la eliminación de elementos que existen
        hashTable.remove(1);
        assertFalse(hashTable.contains(1));
        hashTable.remove(2);
        assertFalse(hashTable.contains(2));

        // Asegurarse de que otros elementos no se ven afectados
        assertTrue(hashTable.contains(3));

        // Prueba la eliminación de un elemento que no existe
        hashTable.remove(4);
        assertFalse(hashTable.contains(4));
    }

    @Test
    void resize() {
        // Añadir más elementos de los que puede albergar inicialmente la tabla hash
        // Por defecto, inicializamos la tabla hash con un tamaño de 10
        for (int i = 0; i < 20; i++) {
            hashTable.put(i, "Number " + i);
        }

        // Comprobar que todos los elementos están presentes
        for (int i = 0; i < 20; i++) {
            assertTrue(hashTable.contains(i));
            assertEquals("Number " + i, hashTable.get(i));
        }

    }

}
