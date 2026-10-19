package leetCode;

public class test {

    // sum 1 until n
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(factorial(5));
        System.out.println(sumFromArray(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(isPalindrome("ararinha"));
    }

    private static int sum(int a) {
        if (a == 0) {
            return 0;
        }
        return a + sum(a - 1);
    }

    private static int factorial(int a) {
        if (a <= 1) {
            return 1;
        }

        return a * factorial(a - 1);
    }

    private static int sumFromArray(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }

        return nums[index] + sumFromArray(nums, index + 1);
    }

    private static boolean isPalindrome(String word) {
        return isPalindromeRecursive(word, 0, word.length() - 1);
    }

    private static boolean isPalindromeRecursive(String word, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(word, left + 1, right - 1);
    }
}
