import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {
    private MyQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void enqueueTest() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.enqueue(2);
        queue.enqueue(3);

        // La cola debería tener los elementos en este orden: 1, 2, 3
    }

    @Test
    public void dequeueTest() {
        assertNull(queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertNull(queue.dequeue());
    }

    @Test
    public void isEmptyTest() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueueWithPriorityTest() {
        queue.enqueueWithPriority(1, 2); // 1 with priority 2
        queue.enqueueWithPriority(2, 1); // 2 with priority 1
        queue.enqueueWithPriority(3, 3); // 3 with priority 3

        // La cola debería tener los elementos en este orden, basado en su prioridad: 2, 1, 3
    }
}




