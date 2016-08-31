package test;

import com.morgolt.education.datastructure.trees.BinaryTree;
import com.morgolt.education.datastructure.trees.ITree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private final ByteArrayOutputStream outputString = new ByteArrayOutputStream();
    private ITree<Integer, String> tree = new BinaryTree<>();
    private final String expectedString = "onetwothreefourfivesix";

    @Before
    public void setUp() throws Exception {
        tree.insert(4, "four");
        tree.insert(1, "one");
        tree.insert(2, "two");
        tree.insert(3, "three");
        tree.insert(5, "five");
        tree.insert(6, "six");
        System.setOut(new PrintStream(outputString));
    }

    @Test
    public void insert() throws Exception {
        tree.insert(7, "seven");
        assertEquals(7, tree.getCount());
    }

    @Test
    public void insertDuplicate() throws Exception {
        int count = tree.getCount();
        tree.insert(1, "one");
        assertEquals(count, tree.getCount());
    }

    @Test
    public void delete() throws Exception {
        tree.delete(7);
        assertFalse(tree.contains(7));
        assertEquals(6, tree.getCount());
    }

    @Test
    public void search() throws Exception {
        assertEquals("one", tree.search(1));
    }

    @Test
    public void traverse() throws Exception {
        Consumer<String> consumer = System.out::print;
        tree.traverse(consumer);
        assertEquals(expectedString, outputString.toString());
    }

    @Test
    public void contains() throws Exception {
        assertTrue(tree.contains(2));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}