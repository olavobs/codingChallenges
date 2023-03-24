package hackerrank;

import java.io.IOException;

class RepeatedString {

    public static void main(String[] args) throws IOException {
        System.out.println(repeatedString("aba", 10L));
    }

    public static long repeatedString(String s, long n) {
        var rest = n % s.length();

        var division = n / s.length();

        var amountOfTimes = s.chars().filter(num -> num == 'a').count();

        var count = division * amountOfTimes;

        for (int i = 0; i <= rest - 1; i++) {

            if (s.charAt(i) == 'a') {
                count++;
            }

        }

        return count;
    }

}


