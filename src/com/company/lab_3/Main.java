package com.company.lab_3;

public class Main {
    public static void main(String[] args) {
        ArrayBasedList l = new ArrayBasedList();
        l.append(2);
        l.append(3);
        l.printList();
        l.append(1);
        l.printList();
        l.heapSort();
        l.printList();

        PriorityQueue q = new PriorityQueue();
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(6);
        q.enqueue(4);
        q.printQueue();
    }
}
