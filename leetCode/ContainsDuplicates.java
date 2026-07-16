package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ContainsDuplicates {

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    // every element is distinct.

    //Input: nums = [1,2,3,1]
    //Output: true
    //Explanation:
    //The element 1 occurs at the indices 0 and 3.

    //Input: nums = [1,2,3,4]
    //Output: false
    //Explanation:
    //All elements are distinct.

    //Input: nums = [1,1,1,3,3,4,3,2,4,2]
    //Output: true

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{-1, -1, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> aux = new ArrayList<>();

        for (int num : nums) {
            if (aux.contains(num)) {
                return true;
            }
            aux.add(num);
        }

        return false;
    }
}
