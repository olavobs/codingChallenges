package leetCode;

//You are given an integer array nums consisting of n elements, and an integer k.
//
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
// Any answer with a calculation error less than 10-5 will be accepted.

//Input: nums = [1,12,-5,-6,50,3], k = 4
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

//Input: nums = [5], k = 1
//Output: 5.00000

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int auxSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            auxSum += nums[i];
            auxSum -= nums[i - k];

            maxSum = Math.max(auxSum, maxSum);
        }

        return (double) maxSum / k;
    }
}
