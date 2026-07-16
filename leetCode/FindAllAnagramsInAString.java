package leetCode;

//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return
// the answer in any order.

//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".

//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        p = sortString(p);
        int left = 0, right = left + p.length();
        List<Integer> answer = new ArrayList<>();

        while (right <= s.length()) {
            String currentValue = s.substring(left, right);
            currentValue = sortString(currentValue);
            if (currentValue.equals(p)) {
                answer.add(left);
            }

            left++;
            right++;
        }
        return answer;
    }

    private static String sortString(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
