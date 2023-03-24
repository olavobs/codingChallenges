package codewars;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once
 * in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a
 * character is a duplicate.
 * EXAMPLES:
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 **/

public class DuplicateEncoder {

    public static void main(String[] args) {
        var word = "din";
        System.out.println(encoder(word));
    }

//    public static String encoder(String word) {
//        var result = "";
//
//        word = word.toLowerCase(Locale.ROOT);
//
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < word.length(); i++) {
//            Character character = word.charAt(i);
//            map.put(character, map.getOrDefault(character, 0) + 1);
//        }
//
//        for (int i = 0; i < word.length(); i++) {
//            Character character = word.charAt(i);
//            if (map.get(character) > 1) {
//                result += ")";
//            } else {
//                result += "(";
//            }
//        }
//        return result;
//    }

    public static String encoder(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

}
