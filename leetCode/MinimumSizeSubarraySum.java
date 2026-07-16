package leetCode;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
// sum is greater than or equal to target. If there is no such subarray, return 0 instead.

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

//Input: target = 4, nums = [1,4,4]
//Output: 1

//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
