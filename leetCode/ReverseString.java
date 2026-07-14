package leetCode;

//Write a function that reverses a string. The input string is given as an array of characters s.
//You must do this by modifying the input array in-place with O(1) extra memory.

//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]

//Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char aux = s[left];
            s[left] = s[right];
            s[right] = aux;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
