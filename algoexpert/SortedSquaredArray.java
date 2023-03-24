package algoexpert;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-2, -1})));
    }

    public static int[] sortedSquaredArray(int[] array) {
        for(int i = 0; i < array.length; i++){
            array[i] = array[i] * array[i];
        }
        return Arrays.stream(array).sorted().toArray();
    }
}
