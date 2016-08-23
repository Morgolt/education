package test;

import com.morgolt.education.datastructure.hashtable.HashTableImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableImplTest {
    HashMap<Integer, String> expectedMap;
    HashTableImpl<Integer, String> currentMap;
    @Before
    public void setUp() throws Exception {
        expectedMap = new HashMap<>();
        expectedMap.put(1, "foo");
        expectedMap.put(2, "bar");
        expectedMap.put(3, "han");
        expectedMap.put(4, "solo");
        expectedMap.put(5, "r2");
        currentMap = new HashTableImpl<>();
        currentMap.put(1, "foo");
    }

    @Test
    public void put() throws Exception {
        currentMap = new HashTableImpl<>();
        currentMap.put(1, "foo");
        currentMap.put(2, "bar");
        currentMap.put(3, "han");
        currentMap.put(4, "solo");
        currentMap.put(5, "r2");
        assertEquals(expectedMap.size(), currentMap.size());
    }

    @Test
    public void search() throws Exception {
        assertEquals(expectedMap.get(1), currentMap.search(1));
    }

    @Test
    public void delete() throws Exception {
        currentMap.delete(1);
        assertNull(currentMap.search(1));
    }

    @Test
    public void testNonexistentKey() throws Exception {
        assertNull(currentMap.search(112));
    }
}