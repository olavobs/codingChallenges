package codewars;

public class MultiplesOf3Or5 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int number) {
        var sum = 0;

        if (number < 1) {
            return sum;
        }

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
