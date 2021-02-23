package com.company.lab_1;

import java.util.Iterator;


class SortedLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

    private SortedLinkedList<T>.Node currentNode;

    public SortedLinkedListIterator(SortedLinkedList<T> sortedLinkedList) {
        this.currentNode = sortedLinkedList.head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T dataToReturn = currentNode.data;
        currentNode = currentNode.next;
        return dataToReturn;
    }
}

class SortedLinkedList<T extends Comparable<T>> implements Iterable<T>{
    Node head;

    @Override
    public Iterator<T> iterator() {
        return new SortedLinkedListIterator<T>(this);
    }

    class Node {
        T data;
        Node next;

        Node(T d) { data = d; }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addItem(T data) {
        Node new_node = new Node(data);

        if (head == null || head.data.compareTo(new_node.data) >= 0) {
            new_node.next = head;
            head = new_node;
        } else {
            Node current = head;

            while (current.next != null && current.next.data.compareTo(new_node.data) < 0) {
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
    }

    public void mergeList(SortedLinkedList<T> list) {
        for(T el: list) {
            this.addItem(el);
        }
    }


    public static <S extends Comparable<S>> SortedLinkedList<S> fromArray(S[] arr) {
        SortedLinkedList<S> list = new SortedLinkedList<>();

        for (S i : arr) {
            list.addItem(i);
        }

        return list;
    }

    int indexOf(T item) {
        int index = 0;
        for(T el: this) {
            if (item == el)
                return index;
            index++;
        }
        return -1;
    }

    public void printList() {

        System.out.print("SortedLinkedList: ");

        for(T el: this) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        for (T el: this)
            size++;
        return size;
    }
}

class Main {

    public static void main(String[] args) {

        SortedLinkedList<Integer> list = SortedLinkedList.fromArray(new Integer[] {1, 6, 3, 1, 2, 5});
        list.printList();
        SortedLinkedList<String> stringList = SortedLinkedList.fromArray(new String[] {"a", "b", "bb", "aa", "ab"});
        stringList.printList();

        SortedLinkedList<Integer> l1 = SortedLinkedList.fromArray(new Integer[] {1, 2});
        SortedLinkedList<Integer> l2 = SortedLinkedList.fromArray(new Integer[] {3, 4});
        l1.mergeList(l2);
        l1.printList();
    }
}