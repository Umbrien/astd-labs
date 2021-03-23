package com.company.lab_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinarySearchTreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void isEmpty() {
        BalancedBinarySearchTree<Integer> tree = new BalancedBinarySearchTree<>();
        assertTrue(tree.isEmpty());

        tree.addItem(3);
        assertFalse(tree.isEmpty());
    }

    @Test
    void isFull() {
        BalancedBinarySearchTree<Integer> tree = new BalancedBinarySearchTree<>();
        assertFalse(tree.isFull());

        tree.addItem(3);
        assertTrue(tree.isFull());
    }

    @Test
    void size() {
        BalancedBinarySearchTree<Integer> tree = new BalancedBinarySearchTree<>();
        assertEquals(tree.size(), 0);

        tree.addItem(1);
        assertEquals(tree.size(), 1);
        tree.addItem(256);
        assertEquals(tree.size(), 2);
    }

    @Test
    void addItem() {
        BalancedBinarySearchTree<Integer> intTree = new BalancedBinarySearchTree<>();
        intTree.addItem(0);
        intTree.addItem(2);
        intTree.addItem(-4);
        intTree.addItem(200);

        intTree.printTree_preorder();
        assertEquals("0 -4 2 200 \n", outContent.toString());
    }

    @Test
    void deleteItem() {
        BalancedBinarySearchTree<Integer> tree = BalancedBinarySearchTree.fromArray(1,2,3);
        tree.printTree_preorder();
        assertEquals("1 2 3 \n", outContent.toString());
        tree.deleteItem(2);
        tree.printTree_preorder();
        assertEquals("1 2 3 \n1 3 \n", outContent.toString());
    }

    @Test
    void search() {
        BalancedBinarySearchTree<Integer> tree = new BalancedBinarySearchTree<>();
        assertFalse(tree.search(3));
        tree.addItem(3);
        assertTrue(tree.search(3));
    }

    @Test
    void printTree_preorder() {
        // https://neerc.ifmo.ru/wiki/images/c/cf/Binary_search_tree.svg.png

        BalancedBinarySearchTree<Integer> tree = BalancedBinarySearchTree.fromArray(8, 3, 10, 1, 6, 14, 4, 7, 13);
        tree.printTree_preorder();
        assertEquals("8 3 1 6 4 7 10 14 13 \n", outContent.toString());
    }

    @Test
    void printTree_inorder() {
        BalancedBinarySearchTree<Integer> tree = BalancedBinarySearchTree.fromArray(8, 3, 10, 1, 6, 14, 4, 7, 13);
        tree.printTree_inorder();
        assertEquals("1 3 4 6 7 8 10 13 14 \n", outContent.toString());
    }

    @Test
    void printTree_postorder() {
        BalancedBinarySearchTree<Integer> tree = BalancedBinarySearchTree.fromArray(8, 3, 10, 1, 6, 14, 4, 7, 13);
        tree.printTree_postorder();
        assertEquals("1 4 7 6 3 13 14 10 8 \n", outContent.toString());
    }

    @Test
    void insertBBST() {
        // https://www.tutorialcup.com/wp-content/uploads/2020/07/Merge-Two-Balanced-Binary-Search-Trees1.png
        BalancedBinarySearchTree<Integer> t1 = BalancedBinarySearchTree.fromArray(7, 5, 8, 4, 6, 9);

        // https://www.tutorialcup.com/wp-content/uploads/2020/07/Merge-Two-Balanced-Binary-Search-Trees2.png
        BalancedBinarySearchTree<Integer> t2 = BalancedBinarySearchTree.fromArray(2, 1, 3);

        t1.insertBBST(t2);

        // https://www.tutorialcup.com/wp-content/uploads/2020/07/Merge-Two-Balanced-Binary-Search-Trees3.png
        t1.printTree_preorder();
        assertEquals("5 2 1 3 4 7 6 8 9 \n", outContent.toString());
    }

    @Test
    void fromArray() {
        BalancedBinarySearchTree<Integer> intTree = BalancedBinarySearchTree.fromArray(1, 2, 3);
        intTree.printTree_preorder();
        assertEquals("1 2 3 \n", outContent.toString());

        BalancedBinarySearchTree<String> stringTree = BalancedBinarySearchTree.fromArray("a", "b", "c");
        stringTree.printTree_preorder();
        assertEquals("1 2 3 \na b c \n", outContent.toString());

    }
}