package leetCode;

// Given a string s, find the length of the longest substring without duplicate characters.

//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> aux = new HashMap<>();

        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (aux.containsKey(current)) {
                left = Math.max(left, aux.get(current) + 1);
            }
            aux.put(current, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
