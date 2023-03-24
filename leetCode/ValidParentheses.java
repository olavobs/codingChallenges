package leetCode;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "()[]{}"
        Output: true

        Example 3:
        Input: s = "(]"
        Output: false*/

import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}(())"));
    }

    public static boolean isValid(String s) {

        List<Character> acceptedOpen = List.of('{', '[', '(');

        Stack execution = new Stack();

        for (int i = 0; i < s.length(); i++) {
            var currentCharacter = s.charAt(i);
            if (acceptedOpen.contains(currentCharacter)) {
                execution.push(currentCharacter);
            } else {
                if (execution.size() > 0 && execution.peek() == getClose(currentCharacter)) {
                    execution.pop();
                } else {
                    return false;
                }
            }
        }

        return execution.size() == 0;
    }

    private static Character getClose(Character currentChar) {
        switch (currentChar) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }


}
