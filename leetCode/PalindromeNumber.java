package leetCode;

//Verificar se um número é palíndromo

public class PalindromeNumber {

    public static void main(String[] args) {
        var num = 122232221;

        System.out.println(isPalindrome(num));
    }

    private static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        var stringNumber = Integer.toString(x);

        var length = stringNumber.length();

        for (int i = 0; i < stringNumber.length() / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }


}
