package leetCode;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
//non-decreasing order.

//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].

//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));

    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int nextHighestPosition = right;
        int[] response = new int[nums.length];
        while (left <= right) {
            int leftNumberSquared = nums[left] * nums[left];
            int rightNumberSquared = nums[right] * nums[right];
            if (leftNumberSquared > rightNumberSquared) {
                left++;
                response[nextHighestPosition] = leftNumberSquared;
            } else {
                right--;
                response[nextHighestPosition] = rightNumberSquared;
            }
            nextHighestPosition--;
        }
        return response;
    }
}
