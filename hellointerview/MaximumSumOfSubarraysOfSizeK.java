package hellointerview;

//Given an array of integers nums and an integer k, find the maximum sum of any contiguous subarray of size k.

//nums = [2, 1, 5, 1, 3, 2]
//k = 3

public class MaximumSumOfSubarraysOfSizeK {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    public static Integer maxSum(int[] nums, Integer k) {
        int current = 0;

        for (int i = 0; i < k; i++) {
            current += nums[i];
        }

        int answer = current;
        for (int i = k; i < nums.length; i++) {
            current += nums[i];
            current -= nums[i - k];
            answer = Math.max(answer, current);
        }
        return answer;
    }
}
