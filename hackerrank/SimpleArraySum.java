package hackerrank;

import java.util.List;

public class SimpleArraySum {

    public static void main(String[] args) {
        System.out.println(simpleArraySum(List.of(1, 2, 3, 4, 10, 11)));
    }

    public static int simpleArraySum(List<Integer> ar) {
        return ar.stream().reduce(0, (x,y)-> x+y);

    }

}
