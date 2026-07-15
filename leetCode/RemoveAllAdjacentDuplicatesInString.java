package leetCode;

//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing
// two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer
// is unique.

//Input: s = "abbaca"
//Output: "ca"
//Explanation:
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the
// only possible move.  The result of this move is that the string is "aaca", of which only "aa" is
// possible, so the final string is "ca".

//Input: s = "azxxzy"
//Output: "ay"

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> sta = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (sta.isEmpty() || sta.peek() != currentChar) {
                sta.push(currentChar);
            } else {
                sta.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : sta) {
            sb.append(c);
        }
        return sb.toString();
    }
}
