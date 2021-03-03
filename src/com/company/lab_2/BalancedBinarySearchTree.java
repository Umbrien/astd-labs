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

    int size() { throw new UnsupportedOperationException(); }

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

    int depthOf(T item) { throw new UnsupportedOperationException(); }

    private void printTree_preorder_recursive(Node node) {
        if(node == null) return;

        System.out.print(node.data + " ");
        printTree_preorder_recursive(node.left);
        printTree_preorder_recursive(node.right);
    }

    void printTree_preorder() {
        printTree_preorder_recursive(this.root);
        System.out.print("\n");
    }

    void printTree_inorder() {
        throw new UnsupportedOperationException();
    }

    void printTree_postorder() {
        throw new UnsupportedOperationException();
    }

    void insertBBST(BalancedBinarySearchTree<T> tree) { throw new UnsupportedOperationException(); }

    @SafeVarargs
    public static <S extends Comparable<S>> BalancedBinarySearchTree<S> fromArray(S... arr) {
        BalancedBinarySearchTree<S> tree = new BalancedBinarySearchTree<>();

        for(S i: arr) {
            tree.addItem(i);
        }

        return tree;
    }

}
