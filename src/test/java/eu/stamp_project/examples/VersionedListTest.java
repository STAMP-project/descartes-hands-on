package eu.stamp_project.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionedListTest {

    @Test
    public void testAdd() {
        VersionedList<Integer> list = new VersionedList<>();
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, (int)list.get(0));
    }

    @Test
    public void testRemove() {
        VersionedList<Integer> list = new VersionedList<>(2, 3, 4, 3, 2);
        list.remove(2);
        assertFalse(list.contains(2));
    }

}