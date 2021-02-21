package com.company;


class SortedLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    // TODO remove static
    public static SortedLinkedList insert(SortedLinkedList list, int data) {
        Node new_node = new Node(data);

        // if list is empty
        if (list.head == null || list.head.data >= new_node.data) {
            new_node.next = list.head;
            list.head = new_node;
        } else {
            Node current = list.head;

            while (current.next != null && current.next.data < new_node.data) {
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
        return  list;
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
        SortedLinkedList.insert(sortedLinkedList, 4);
        SortedLinkedList.insert(sortedLinkedList, 3);
        SortedLinkedList.insert(sortedLinkedList, 2);
        SortedLinkedList.insert(sortedLinkedList, 6);
        SortedLinkedList.insert(sortedLinkedList, 5);
        SortedLinkedList.insert(sortedLinkedList, 5);
        SortedLinkedList.insert(sortedLinkedList, 6);
        SortedLinkedList.insert(sortedLinkedList, 1);
        SortedLinkedList.insert(sortedLinkedList, 2);
        SortedLinkedList.printList(sortedLinkedList);
    }
}