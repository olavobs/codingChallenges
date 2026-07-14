package leetCode;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
// same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.

//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]

//Input: nums = [2,0,1]
//Output: [0,1,2]

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{1, 2, 0});
    }

    public static void sortColors(int[] nums) {
        int index = 0;
        int next0pos = 0;
        int next2pos = nums.length - 1;

        while (index <= next2pos) {
            if (nums[index] == 0) {
                swap(nums, index, next0pos);
                next0pos++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, next2pos);
                next2pos--;
            } else {
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
