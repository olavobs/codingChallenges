package hackerrank;

import java.util.List;

public class BF_SimpleArraySum {

    public static void main(String[] args) {
        System.out.println(simpleArraySum(List.of(1, 2, 3, 4, 10, 11)));
    }

    public static int simpleArraySum(List<Integer> ar) {
        return ar.stream().reduce(0, (x, y) -> x + y);

    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Somar todos os elementos de um array de inteiros.
 *
 * 1. Recebe a lista de inteiros.
 * 2. Usa reduce da Stream API para somar todos os elementos, começando de
 *    0.
 * 3. Retorna a soma total.
 *
 * Complexidade: O(n).
 */
