package com.company.lab_1;


class SortedLinkedList {
    Node head;

    static class Node {
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

    public static void printList(SortedLinkedList list) {
        Node currentNode = list.head;

        System.out.print("LinkedList: ");

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}

class Main {

    public static void main(String[] args) {

        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        sortedLinkedList.insert(4);
        sortedLinkedList.insert(3);
        sortedLinkedList.insert(2);
        sortedLinkedList.insert(6);
        sortedLinkedList.insert(5);
        sortedLinkedList.insert(5);
        sortedLinkedList.insert(6);
        sortedLinkedList.insert(1);
        sortedLinkedList.insert(2);
        SortedLinkedList.printList(sortedLinkedList);
    }
}