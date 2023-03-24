package algoexpert;

import java.util.List;

public class ValidSubsequence {

    // We are given two arrays of integers array and sequence. We are asked to implement a function that is going to check whether all the numbers in
    // the sequence appear in the array and they appear in the same order. In other words, the function needs to find out if we can get the sequence array
    // from the array, when we delete some or no elements in the array without changing the order of the remaining elements.

    public static void main(String[] args) {
        var lista1 = List.of(5, 1, 22, 25, 6, -1, 8, 3);
        var lista2 = List.of(1, 6, -1, 10);
        System.out.println(isValidSubsequence(lista1, lista2));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        var aux = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == sequence.get(aux)) {
                aux++;
            }
        }
        return aux == sequence.size();
    }

}
