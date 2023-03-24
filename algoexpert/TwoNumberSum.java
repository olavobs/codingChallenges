package algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    //Given an array of distinct integers and an integer representing the target sum, we are asked to implement a function that is going to find out
    // whether there's a pair of numbers in the array that adds up to the target sum. If such pair exists, return the pair in any order;
    // otherwise return an empty array. We cannot add a number to itself to get the target sum.

    public static void main(String[] args) {
        var array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.toString(twoNumberSum(array, 10)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> numberSet = new HashSet<>();

        for(int i = 0; i < array.length; i++){
            var complement = targetSum - array[i];
            if(numberSet.contains(complement)){
                return new int[]{array[i], complement};
            } else {
                numberSet.add(array[i]);
            }
        }
        return new int[0];
    }

}
