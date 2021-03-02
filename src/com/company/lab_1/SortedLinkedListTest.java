package com.company.lab_1;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {

    @org.junit.jupiter.api.Test
    void isEmpty() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertTrue(list.isEmpty());

        list.addItem(3);
        assertFalse(list.isEmpty());

        list.deleteItem(3);
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addItem() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();

        list.addItem(4);
        assertEquals(list.indexOf(4), 0);

        list.addItem(2);
        assertEquals(list.indexOf(2), 0);
        assertEquals(list.indexOf(4), 1);
    }

    @org.junit.jupiter.api.Test
    void makeEmpty() {
        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(new Integer[] {1, 2, 3});
        assertFalse(list.isEmpty());
        list.makeEmpty();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void deleteItem() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertEquals(list.indexOf(1), -1);
        list.addItem(1);
        assertEquals(list.indexOf(1), 0);
        list.deleteItem(1);
        assertEquals(list.indexOf(1), -1);
    }

    @org.junit.jupiter.api.Test
    void mergeList() {
        SortedLinkedList<Integer> l1 = SortedLinkedList.fromArray(new Integer[] {1, 2});
        SortedLinkedList<Integer> l2 = SortedLinkedList.fromArray(new Integer[] {3, 4});
        l1.mergeList(l2);
        assertEquals(l1.indexOf(1), 0);
        assertEquals(l1.indexOf(2), 1);
        assertEquals(l1.indexOf(3), 2);
        assertEquals(l1.indexOf(4), 3);
    }

    @org.junit.jupiter.api.Test
    void fromArray() {
        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(new Integer[] {1, 2, 3});
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(2), 1);
        assertEquals(list.indexOf(3), 2);
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(new Integer[] {1, 2, 3});
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(2), 1);
        assertEquals(list.indexOf(3), 2);
        assertEquals(list.indexOf(4), -1);
    }


    @org.junit.jupiter.api.Test
    void getSize() {
        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(new Integer[] {1, 2, 3});
        assertEquals(list.getSize(), 3);
        list.makeEmpty();
        assertEquals(list.getSize(), 0);
    }
}