package com.company.lab_3;

import java.util.ArrayList;

public class PriorityQueue {
    private Node root;

    static class Node {
        int data;
        private int dataPriority;
        int height;
        Node left, right;

        Node(int d) { data = d; }

        public void setDataPriority(int i) {
            if (i > 0 && i < 7) {
                dataPriority = i;
            }
        }
    }

    boolean isEmpty() {return root == null;}

    boolean isFull() {return !isEmpty();}

    private int recursiveSize(Node current) {
        if (current == null) return 0;

        return 1 + recursiveSize(current.left) + recursiveSize(current.right);
    }

    public int size() {
        return recursiveSize(root);
    }

    private Node recursiveAdd(Node current, int item) {
        if (current == null) {
            return new Node(item);
        }

        if(item < current.data) {
            current.left = recursiveAdd(current.left, item);
        } else if (item > current.data) {
            current.right = recursiveAdd(current.right, item);
        } else {
            //value already exists
            return current;
        }

        return current;
    }

    private void addItem(int item) {
        // Normal insert
        root = recursiveAdd(root, item);

        // Balancing
        root = rebalance(root);
    }

    public void enqueue(int i) {
        addItem(i);
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(Node current) {
        current.height = 1 + Math.max(height(current.left), height(current.right));
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.left;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) <= height(z.right.left)) {
                z.right = rotateRight(z.right);
            }
            z = rotateLeft(z);
        } else if (balance < -1) {
            if (height(z.left.left) < height(z.left.right)) {
                z.left = rotateLeft(z.left);
            }
            z = rotateRight(z);
        }
        return z;
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    private int findHighestValue(Node node) {
        return node.right == null ? node.data : findHighestValue(node.right);
    }

    /**
     * Find node to delete, then delete it
     */
    private Node recursiveDelete(Node current, int item) {
        if (current == null) return null;

        // Node to delete found
        if (item == current.data) {
            // Node is a leaf
            if (current.left == null && current.right == null) {
                return null;
            }

            // Node has only right child
            if (current.left == null) {
                return current.right;
            }

            // Node has only left child
            if (current.right == null) {
                return current.left;
            }

            // Node has both left and right children
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = recursiveDelete(current.right, smallestValue);
            return current;
        }

        if (item < current.data) {
            current.left = recursiveDelete(current.left, item);
            return current;
        }
        current.right = recursiveDelete(current.right, item);
        return current;
    }

    private void deleteItem(int item) {
        root = recursiveDelete(root, item);
    }

    public int dequeueMax() {
        int max = findHighestValue(root);
        deleteItem(max);
        return max;
    }

    private void printQueue_recursive(Node node) {
        if(node == null) return;

        printQueue_recursive(node.left);
        System.out.print(node.data + " ");
        printQueue_recursive(node.right);
    }

    void printQueue() {
        printQueue_recursive(this.root);
        System.out.print("\n");
    }
}
