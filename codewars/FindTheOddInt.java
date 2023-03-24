package codewars;

import java.util.HashSet;
import java.util.Set;

public class FindTheOddInt {

    public static void main(String[] args) {


        System.out.println(findIT(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1}));

    }

    public static int findIT(int[] a) {
        Set<Integer> aux = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (aux.contains(a[i])) {
                aux.remove(a[i]);
            } else {
                aux.add(a[i]);
            }
        }

        return aux.iterator().next();
    }
}
