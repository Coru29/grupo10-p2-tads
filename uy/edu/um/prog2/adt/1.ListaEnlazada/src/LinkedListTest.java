import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest {
    private Lista<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new LL<>();
    }

    @Test
    public void addTest() {
        // Añadir a una lista vacia
        int initialValue = 10;
        lista.add(initialValue);
        assertEquals(1, lista.size());
        assertEquals(initialValue, lista.get(0).intValue());

        // Una q no este vacia
        int secondValue = 20;
        lista.add(secondValue);
        assertEquals(2, lista.size());
        assertEquals(secondValue, lista.get(1).intValue());

        // Añadiendo muchos y checkeando el orden
        int[] addedValues = {30, 40, 50};
        for (int i = 0; i < addedValues.length; i++) {
            lista.add(addedValues[i]);
            assertEquals(initialValue + (i + 2) * 10, lista.get(i + 2).intValue());
        }
        assertEquals(5, lista.size());

        // Añadir al principio
        lista.add(5);
        assertEquals(6, lista.size());
        assertEquals(5, lista.get(5).intValue());
    }

    @Test
    public void removeTest() {
        // Añadir elementos a la lista
        for (int i = 0; i < 5; i++) {
            lista.add(i);
        }

        // Prueba eliminar el elemento en la primera posición
        lista.remove(0);
        assertEquals(4, lista.size());
        for (int i = 0; i < 4; i++) {
            assertEquals(i + 1, lista.get(i).intValue());
        }

        // Prueba eliminar el elemento en la última posición
        lista.remove(lista.size() - 1);
        assertEquals(3, lista.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(i + 1, lista.get(i).intValue());
        }

        // Prueba eliminar un elemento en el medio
        lista.remove(1);
        assertEquals(2, lista.size());
        assertEquals(1, lista.get(0).intValue());
        assertEquals(3, lista.get(1).intValue());
    }

    @Test
    public void addFirstTest() {
        // Compruebo que la lista está vacía
        assertEquals(0, lista.size());

        // Añado el primer elemento
        lista.addFirst(1);
        assertEquals(1, lista.size());
        assertEquals(1, lista.get(0).intValue());

        // Añado un segundo elemento al inicio
        lista.addFirst(2);
        assertEquals(2, lista.size());
        assertEquals(2, lista.get(0).intValue());
        assertEquals(1, lista.get(1).intValue());

        // Compruebo que el valor inicial se mueve al siguiente índice
        lista.addFirst(3);
        assertEquals(3, lista.size());
        assertEquals(3, lista.get(0).intValue());
        assertEquals(2, lista.get(1).intValue());
        assertEquals(1, lista.get(2).intValue());
    }

    @Test
    public void addAtTest() {
        // Añado un primer elemento en la posición 0
        lista.addAt(1, 0);
        assertEquals(1, lista.size());
        assertEquals(1, lista.get(0).intValue());

        // Añado un elemento en la posición 1
        lista.addAt(2, 1);
        assertEquals(2, lista.size());
        assertEquals(1, lista.get(0).intValue());
        assertEquals(2, lista.get(1).intValue());

        // Añado un elemento en la posición 1 y compruebo que los elementos se mueven correctamente
        lista.addAt(3, 1);
        assertEquals(3, lista.size());
        assertEquals(1, lista.get(0).intValue());
        assertEquals(3, lista.get(1).intValue());
        assertEquals(2, lista.get(2).intValue());

        // Pruebo añadir un elemento en una posición inválida (por encima)
        assertThrows(IndexOutOfBoundsException.class, () -> lista.addAt(4, 4));

        // Pruebo añadir un elemento en una posición inválida (por debajo)
        assertThrows(IndexOutOfBoundsException.class, () -> lista.addAt(5, -1));
    }


    @Test
    public void addInOrderTest() {
        lista.addInOrder(5);
        lista.addInOrder(3);
        lista.addInOrder(4);
        lista.addInOrder(2);
        lista.addInOrder(1);

        // Comprobar si los elementos están en el orden correcto
        assertEquals(1, lista.get(0));
        assertEquals(2, lista.get(1));
        assertEquals(3, lista.get(2));
        assertEquals(4, lista.get(3));
        assertEquals(5, lista.get(4));

        // Comprobar si se ha actualizado correctamente el tamaño de la lista
        assertEquals(5, lista.size());

        // Intentar agregar elementos en orden no consecutivo
        lista.addInOrder(10);
        lista.addInOrder(7);
        lista.addInOrder(8);

        assertEquals(7, lista.get(5));
        assertEquals(8, lista.get(6));
        assertEquals(10, lista.get(7));
        assertEquals(8, lista.size());
    }



}