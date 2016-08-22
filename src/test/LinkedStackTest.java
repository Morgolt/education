package test;

import com.morgolt.education.datastructure.stack.LinkedStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LinkedStackTest {

    LinkedStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new LinkedStack();
    }

    @Test
    public void testPushPop() throws Exception {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNullOnEmptyStack() throws Exception {
        assertNull(stack.pop());
    }

    @Test
    public void testPeek() throws Exception {
        stack.push(1);
        assertTrue(stack.peek().equals(1));
    }

}