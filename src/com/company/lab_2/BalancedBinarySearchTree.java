package com.company.lab_2;


import java.util.ArrayList;

public class BalancedBinarySearchTree<T extends Comparable<T>> {
    Node root;

    class Node {
        T data;
        int height;
        Node left, right;

        Node(T d) { data = d; }
    }

    boolean isEmpty() {return root == null;}

    boolean isFull() {return !isEmpty();}

    int recursiveSize(Node current) {
        if (current == null) return 0;

        return 1 + recursiveSize(current.left) + recursiveSize(current.right);
    }

    int size() {
        return recursiveSize(root);
    }

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

        // Balancing
        root = rebalance(root);
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

    private T findSmallestValue(Node node) {
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    /**
     * Find node to delete, then delete it
     */
    private Node recursiveDelete(Node current, T item) {
        if (current == null) return null;

        // Node to delete found
        if (item.compareTo(current.data) == 0) {
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
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = recursiveDelete(current.right, smallestValue);
            return current;
        }

        if (item.compareTo(current.data) < 0) {
            current.left = recursiveDelete(current.left, item);
            return current;
        }
        current.right = recursiveDelete(current.right, item);
        return current;
    }

    void deleteItem(T item) {
        root = recursiveDelete(root, item);
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

    private void printTree_inorder_recursive(Node node) {
        if(node == null) return;

        printTree_inorder_recursive(node.left);
        System.out.print(node.data + " ");
        printTree_inorder_recursive(node.right);
    }

    void printTree_inorder() {
        printTree_inorder_recursive(this.root);
        System.out.print("\n");
    }

    private void printTree_postorder_recursive(Node node) {
        if(node == null) return;

        printTree_postorder_recursive(node.left);
        printTree_postorder_recursive(node.right);
        System.out.print(node.data + " ");
    }

    void printTree_postorder() {
        printTree_postorder_recursive(this.root);
        System.out.print("\n");
    }

    private void storeInOrder(Node root, ArrayList<T> arr) {
        if (root != null) {
            storeInOrder(root.left, arr);
            arr.add(root.data);
            storeInOrder(root.right, arr);
        }
    }

    private ArrayList<T> mergeSortedArrays(ArrayList<T> arr1, ArrayList<T> arr2) {
        int i = 0, j = 0;
        ArrayList<T> arr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i).compareTo(arr2.get(j)) < 0) {
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            arr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }

    private Node constructBSTFromSortedArray(ArrayList<T> arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = constructBSTFromSortedArray(arr, start, mid - 1);
        root.right = constructBSTFromSortedArray(arr, mid + 1, end);
        return root;
    }

    void insertBBST(BalancedBinarySearchTree<T> tree) {
        ArrayList<T> thisArr = new ArrayList<>();
        storeInOrder(this.root, thisArr);

        ArrayList<T> treeArr = new ArrayList<>();
        storeInOrder(tree.root, treeArr);

        ArrayList<T> mergedArr = mergeSortedArrays(thisArr, treeArr);

        this.root = constructBSTFromSortedArray(mergedArr, 0, mergedArr.size() - 1);
    }

    @SafeVarargs
    public static <S extends Comparable<S>> BalancedBinarySearchTree<S> fromArray(S... arr) {
        BalancedBinarySearchTree<S> tree = new BalancedBinarySearchTree<>();

        for(S i: arr) {
            tree.addItem(i);
        }

        return tree;
    }

}
