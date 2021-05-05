package com.company.lab_3;

public class ArrayBasedList {
    private final int[] listArray;
    private static final int DEFAULT_SIZE = 10;
    private final int maxSize;
    private int listSize;

    ArrayBasedList(int size) {
        maxSize = size;
        listSize = 0;
        listArray = new int[size];
    }

    ArrayBasedList() { this(DEFAULT_SIZE); }

    public void append(int el) {
        if (listSize < maxSize)
            listArray[listSize++] = el;
    }

    public boolean isEmpty() { return listSize == 0; }
    public boolean isFull() { return listSize == maxSize; }
    public int getSize() { return listSize; }

    public void printList() {
        for(int i: listArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void HeapSort() {
        throw new UnsupportedOperationException();
    }
}
