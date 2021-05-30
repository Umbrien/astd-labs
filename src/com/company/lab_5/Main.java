package com.company.lab_5;

import java.util.Random;

public class Main {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergekSort(int[] a, int n) {
        if (n < 2) return;

        if (n < 10) {
            bubbleSort(a);
        } else {
            int mid = n / 2;
            int[] l = new int[mid];
            int[] r = new int[n - mid];

            System.arraycopy(a, 0, l, 0, mid);
            if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);
            mergekSort(l, mid);
            mergekSort(r, n - mid);
            merge(a, l, r, mid, n - mid);
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void main(String[] args) {
        final Random random = new Random();

        int[] L = new int[100];
        int[] L1 = new int[100];

        for (int i = 0; i < 100; i++) {
            L[i] = random.nextInt(100) + 1;
        }
        System.arraycopy(L, 0, L1, 0, 100);

        long start = System.nanoTime();
        mergekSort(L, L.length);
        long end = System.nanoTime();
        System.out.println("mergeksort took " + (end - start) + " nanoseconds");
        for (int l : L) {
            System.out.print(l + " ");
        }
        System.out.println();

        long start1 = System.nanoTime();
        mergeSort(L1, L1.length);
        long end1 = System.nanoTime();
        System.out.println("mergesort took " + (end1 - start1) + " nanoseconds");
        for (int l1 : L1) {
            System.out.print(l1 + " ");
        }
        System.out.println();
    }
}
