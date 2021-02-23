package com.company.lab_1;


class SortedLinkedList<T extends Comparable<T>> {
    Node head;

    class Node {
        T data;
        Node next;

        Node(T d) { data = d; }
    }

    public void insert(T data) {
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
        Node current = list.head;

        while (current != null) {
            this.insert(current.data);
            current = current.next;
        }
    }


    public static <S extends Comparable<S>> SortedLinkedList<S> fromArray(S[] arr) {
        SortedLinkedList<S> list = new SortedLinkedList<>();

        for (S i : arr) {
            list.insert(i);
        }

        return list;
    }


    public void printList() {
        Node currentNode = this.head;

        System.out.print("SortedLinkedList: ");

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
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