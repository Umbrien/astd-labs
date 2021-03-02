package com.company.lab_2;


public class BalancedBinarySearchTree<T extends Comparable<T>> {
    Node root;

    class Node {
        T data;
        BalancedBinarySearchTree.Node left;
        BalancedBinarySearchTree.Node right;

        Node(T d) { data = d; }
    }

    boolean isEmpty() {return true;}

    boolean isFull() {return !isEmpty();}

    int size() {return -1;}

    void addItem(T item) {}

    boolean search(T item) {return false;}

    int depthOf(T item) {return -1;}

    void printTree_preorder() {}

    void printTree_inorder() {}

    void printTree_postorder() {}

    void insertBBST(BalancedBinarySearchTree<T> tree) {}

}
