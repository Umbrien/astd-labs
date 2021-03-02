package com.company.lab_1;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListIteratorTest {

    @org.junit.jupiter.api.Test
    void hasNext() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());

        list.addItem(1);
        iterator = list.iterator();
        assertTrue(iterator.hasNext());

        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void next() {
        Integer[] array = {1, 2, 3, 4, 5};

        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(array);
        Iterator<Integer> iterator = list.iterator();

        for (int el: array) {
            assertEquals(el, iterator.next());
        }
    }
}