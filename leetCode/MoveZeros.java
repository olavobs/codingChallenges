package leetCode;

//Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while
//keeping the order of non-zero elements unchanged. Perform this operation in-place without creating a copy
//of the array.

//nums = [2,0,4,0,9]
// output: [2,4,9,0,0]


import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{2, 0, 4, 0, 0, 0, 1, 9});
    }


    public static void moveZeroes(int[] nums) {
        int zeroPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[zeroPosition];
                nums[zeroPosition] = nums[i];
                nums[i] = temp;
                zeroPosition++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
