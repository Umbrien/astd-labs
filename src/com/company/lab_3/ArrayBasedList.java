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

    public void heapSort() {
        int temp;
        int size = listSize-1;

        for (int i = (listSize / 2); i >= 0; i--) {
            heapify(i, size);
        }

        for (int i = size; i >= 0; i--) {
            temp = listArray[0];
            listArray[0] = listArray[size];
            listArray[size] = temp;
            size--;
            heapify(0, size);
        }
    }

    public void heapify(int i, int heapSize) {
        int a = 2*i;
        int b = 2*i+1;
        int largestElement;

        if (a<= heapSize && listArray[a] > listArray[i]) {
            largestElement = a;
        } else {
            largestElement = i;
        }
        if (b <= heapSize && listArray[b] > listArray[largestElement]) {
            largestElement = b;
        }

        if (largestElement != i) {
            int temp = listArray[i];
            listArray[i] = listArray[largestElement];
            listArray[largestElement] = temp;
            heapify(largestElement, heapSize);
        }
    }
}
