package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
public class HS_PermCheck {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] A) {

        Set<Integer> aux = new HashSet<>();

        for (int j : A) {
            aux.add(j);
        }

        for (int i = 1; i < A.length + 1; i++) {
            if (!aux.contains(i)) {
                return 0;
            }
        }

        return 1;

    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se um array é uma permutação dos números de 1 a N
 * (contém cada valor de 1 a N exatamente uma vez).
 *
 * 1. Adiciona todos os elementos do array em um HashSet, para consulta
 *    rápida (O(1)) e eliminando duplicatas automaticamente.
 * 2. Percorre todos os valores de 1 até N (o tamanho do array).
 * 3. Para cada valor, verifica se ele está presente no set.
 * 4. Se algum valor de 1 a N não estiver no set, o array não é uma
 *    permutação válida — retorna 0 imediatamente.
 * 5. Se o laço terminar sem falhas, todos os valores de 1 a N estão
 *    presentes — retorna 1.
 *
 * Complexidade: O(n).
 */
