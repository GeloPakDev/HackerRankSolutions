package com.company.hackerranksolutions.sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void printArray(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static int introTutorial(int V, List<Integer> arr) {
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (V == arr.get(i)) {
                index = i;
            }
        }
        return index;
    }

    public static void insertionSort1(int n, List<Integer> ar) {
        //create variable for saving the last value in it
        int temp;

        for (int i = ar.size() - 1; i > 0; i--) {
            temp = ar.get(i);
            //if the last element in the sorted partition is greater than temp variable place greater on the temp place
            if (ar.get(i - 1) > temp) {
                ar.set(i, ar.get(i - 1));
                printArray(ar);
                ar.set(i - 1, temp);
            }
        }
        printArray(ar);
    }

    public static void insertionSort2(List<Integer> arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.size(); firstUnsortedIndex++) {
            //Save the value of the element we are going to insert
            int newElement = arr.get(firstUnsortedIndex);

            int i;
            for (i = firstUnsortedIndex; i > 0 && arr.get(i - 1) > newElement; i--) {
                arr.set(i, arr.get(i - 1));
            }
            arr.set(i, newElement);
        }
    }

    public static int runningTime(List<Integer> arr) {
        int counter = 0;
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.size(); firstUnsortedIndex++) {
            //Save the value of the element we are going to insert
            int newElement = arr.get(firstUnsortedIndex);

            int i;
            for (i = firstUnsortedIndex; i > 0 && arr.get(i - 1) > newElement; i--) {
                arr.set(i, arr.get(i - 1));
            }
            arr.set(i, newElement);
            counter++;
        }
        return counter;

    }

    public static List<Integer> quickSort(List<Integer> arr) {

        int pivotIndex = 0; // not a great choice of pivot.
        int pivotValue = arr.get(pivotIndex);

        swap(arr, pivotIndex, arr.size() - 1); // put pivot at end for now.

        /* Linear search, comparing all elements to pivotValue and swapping as necessary */
        int indexToReturn = 0;
        for (
                int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < pivotValue) {
                swap(arr, i, indexToReturn);
                indexToReturn++;
            }
        }

        swap(arr, indexToReturn, arr.size() - 1); // puts pivot where it belongs
        return arr;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] list = new int[arr.size()];
        for (Integer integer : arr) {
            list[integer]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int el : list) {
            result.add(el);
        }
        return result;
    }
}