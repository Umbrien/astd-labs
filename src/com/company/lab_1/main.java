package com.company.lab_1;


class SortedLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    public void insert(int data) {
        Node new_node = new Node(data);

        if (head == null || head.data >= new_node.data) {
            new_node.next = head;
            head = new_node;
        } else {
            Node current = head;

            while (current.next != null && current.next.data < new_node.data) {
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
    }

    public void mergeList(SortedLinkedList list) {
        Node current = list.head;

        while (current != null) {
            this.insert(current.data);
            current = current.next;
        }
    }

    public static SortedLinkedList fromArray(int[] arr) {
        SortedLinkedList list = new SortedLinkedList();

        for (int i : arr) {
            list.insert(i);
        }

        return list;
    }


    public static void printList(SortedLinkedList list) {
        Node currentNode = list.head;

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

        SortedLinkedList list = SortedLinkedList.fromArray(new int[] {1, 6, 3, 1, 2, 5});
        SortedLinkedList.printList(list);

        SortedLinkedList l1 = SortedLinkedList.fromArray(new int[] {1, 2});
        SortedLinkedList l2 = SortedLinkedList.fromArray(new int[] {3, 4});
        l1.mergeList(l2);
        SortedLinkedList.printList(l1);
    }
}