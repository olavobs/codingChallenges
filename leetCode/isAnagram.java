package leetCode;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//Input: s = "anagram", t = "nagaram"
//Output: true

//Input: s = "rat", t = "car"
//Output: false

import java.util.Arrays;

public class isAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        // Option 1
//        return sortString(s).equals(sortString(t));

        // Option 2
        if (s.length() != t.length()) {
            return false;
        }

        char[] c = new char[26];

        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (char value : c) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    private static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
