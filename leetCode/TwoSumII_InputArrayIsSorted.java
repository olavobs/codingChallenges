package leetCode;

//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
// such that they add up to a specific target number. Let these two numbers be numbers[index1] and
// numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers index1 and index2, each incremented by one, as an integer \
// array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.

//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); //[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6))); //[1,3]
    }

    public static int[] twoSum(int[] numbers, int target) {
        // Solution 1
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    return new int[]{i + 1, j + 1};
//                }
//            }
//        }
//        return null;

        // Solution 2
//        int left = 0;
//        int right = numbers.length - 1;
//
//        while (left < right) {
//            if (numbers[left] + numbers[right] > target) {
//                right--;
//            } else if (numbers[left] + numbers[right] < target) {
//                left++;
//            } else if (numbers[left] + numbers[right] == target) {
//                return new int[]{left + 1, right + 1};
//            }
//        }
//        return null;

        // Solution 3
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int difference = target - numbers[i];
            if (numMap.isEmpty() || !numMap.containsKey(difference)) {
                numMap.put(numbers[i], i);
            } else {
                return new int[]{numMap.get(difference) + 1, i + 1};
            }
        }
        return null;
    }
}
