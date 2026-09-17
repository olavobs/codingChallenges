package leetCode;

import java.util.HashSet;
import java.util.Set;

public class HS_ContainsDuplicates {

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    // every element is distinct.

    //Input: nums = [1,2,3,1]
    //Output: true
    //Explanation:
    //The element 1 occurs at the indices 0 and 3.

    //Input: nums = [1,2,3,4]
    //Output: false
    //Explanation:
    //All elements are distinct.

    //Input: nums = [1,1,1,3,3,4,3,2,4,2]
    //Output: true

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{-1, -1, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> aux = new HashSet<>();

        for (int num : nums) {
            if (!aux.add(num)) {
                return true;
            }
        }
        return false;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se um array contém algum valor duplicado.
 *
 * 1. Cria um HashSet vazio.
 * 2. Percorre o array tentando adicionar cada número ao set.
 * 3. O método add de um Set retorna false se o elemento já existia — nesse
 *    caso, encontramos um duplicado e retorna true imediatamente.
 * 4. Se o laço terminar sem nenhuma tentativa de adição falhar, significa
 *    que todos os elementos são únicos — retorna false.
 *
 * Complexidade: O(n).
 */
