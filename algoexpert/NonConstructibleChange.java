package algoexpert;

// We are given an array of positive integers, which represent the values of coins that we have in our possession. The array could have duplicates.
// We are asked to write a function that returns the minimum amount of change that we cannot create with our coins. For instance, if the input array
// is [1, 2, 5], the minimum amount of change that we cannot create is 4, since we can create 1, 2, 3 (1 + 2) and 5.

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        var currentChange = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > currentChange + 1) {
                break;
            }
            currentChange += coins[i];
        }

        return currentChange + 1;
    }

}
