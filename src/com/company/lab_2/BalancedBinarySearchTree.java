package com.company.lab_2;


public class BalancedBinarySearchTree<T extends Comparable<T>> {
    Node root;

    class Node {
        T data;
        Node left, right;

        Node(T d) { data = d; }
    }

    boolean isEmpty() {return root == null;}

    boolean isFull() {return !isEmpty();}

    int size() {return -1;}

    private Node recursiveAdd(Node current, T item) {
        if (current == null) {
            return new Node(item);
        }

        if(item.compareTo(current.data) < 0) {
            current.left = recursiveAdd(current.left, item);
        } else if (item.compareTo(current.data) > 0) {
            current.right = recursiveAdd(current.right, item);
        } else {
            //value already exists
            return current;
        }

        return current;
    }

    void addItem(T item) {
        // Normal insert
        root = recursiveAdd(root, item);

        // TODO check if balanced. If not, go balance, emo kid
    }

    private boolean recursiveSearch(Node current, T item) {
        if(current == null) {
            return false;
        }
        if (item == current.data) {
            return true;
        }
        return item.compareTo(current.data) < 0
                ? recursiveSearch(current.left, item)
                : recursiveSearch(current.right, item);
    }

    boolean search(T item) {
        return recursiveSearch(root, item);
    }

    int depthOf(T item) {return -1;}

    void printTree_preorder() {}

    void printTree_inorder() {}

    void printTree_postorder() {}

    void insertBBST(BalancedBinarySearchTree<T> tree) {}

}
