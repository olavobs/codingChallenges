package leetCode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            var currentChar = s.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        }


        for (int i = 0; i < s.length(); i++) {
            var character = s.charAt(i);
            if (map.get(character) == 1) {
                return i;
            }
        }
        return -1;
    }

}
