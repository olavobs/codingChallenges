package algoexpert;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        var orderedArray = bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3});

        System.out.println(Arrays.toString(orderedArray));
    }

    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
