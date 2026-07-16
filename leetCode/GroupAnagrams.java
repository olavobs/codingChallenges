package leetCode;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

//Input: strs = [""]
//Output: [[""]]

//Input: strs = ["a"]
//Output: [["a"]]

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> aux = new HashMap<>();

        for (String curr : strs) {
            String sortedWord = sort(curr);
            if (!aux.containsKey(sortedWord)) {
                aux.put(sortedWord, new ArrayList<>());
            }
            aux.get(sortedWord).add(curr);
        }
        return new ArrayList<>(aux.values());
    }

    private static String sort(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
