package codewars;

import java.util.HashSet;
import java.util.Set;

public class HS_FindTheOddInt {

    public static void main(String[] args) {
        System.out.println(findIT(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));

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

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o único número que aparece um número ímpar de vezes
 * em um array (todos os outros aparecem um número par de vezes).
 *
 * 1. Usa um HashSet para guardar números que, até o momento, apareceram um
 *    número ímpar de vezes ("não pareados").
 * 2. Para cada número do array: se ele já está no set, remove (ele acabou
 *    de formar um par); se não está, adiciona (começou um novo "não par").
 * 3. Números que aparecem em pares acabam se cancelando (são adicionados e
 *    depois removidos), sobrando no set apenas o número com ocorrência
 *    ímpar.
 * 4. Retorna esse número restante no set.
 *
 * Complexidade: O(n).
 */
