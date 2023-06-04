import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    private MyStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void pushAndTopTest() {
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertEquals(1, stack.top());

        stack.push(2);
        assertEquals(2, stack.top());

        stack.push(3);
        assertEquals(3, stack.top());

        assertFalse(stack.isEmpty());
    }

    @Test
    public void popTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        assertEquals(2, stack.top());

        stack.pop();
        assertEquals(1, stack.top());

        stack.pop();
        assertTrue(stack.isEmpty());

        // prueba que no se puede hacer pop de un stack vacio
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void isEmptyTest() {
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void makeEmptyTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());

        stack.makeEmpty();

        assertTrue(stack.isEmpty());
        assertThrows(EmptyStackException.class, () -> stack.top());
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }




}
