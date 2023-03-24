package codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PermMissingElem {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] A) {

        //é mais rápido fazer a verificação usando contains com um set do que com uma lista,
        //o set usa uma estrutura de map por debaixo dos panos então a verificação é O(1)
        //enquanto a lista utiliza o indexOf fazendo com que sempre seja necessário percorrer toda a lista ou seja O(n)
        Set<Integer> aux = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 1; i < aux.size() + 1; i++) {
            if (!aux.contains(i)) {
                return i;
            }
        }

        return aux.size() + 1;
    }
}
