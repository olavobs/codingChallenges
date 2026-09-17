package leetCode;

//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
//element appears only once. The relative order of the elements should be kept the same.
//
//Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique
//elements k.
//
//The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index
//k - 1 can be ignored.

//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

public class TP_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int aux = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[aux - 1]) {
                nums[aux] = nums[i];
                aux++;
            }
        }
        return aux;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Remover duplicatas de um array já ordenado, in-place, mantendo
 * a ordem relativa dos elementos únicos.
 *
 * 1. Se o array estiver vazio, retorna 0 diretamente.
 * 2. Usa um ponteiro aux, começando em 1, que marca a próxima posição
 *    onde um valor único deve ser escrito.
 * 3. Percorre o array com outro ponteiro i, comparando cada elemento com
 *    o último valor único já confirmado (nums[aux - 1]).
 * 4. Sempre que encontra um valor diferente do último único, escreve esse
 *    valor na posição aux e avança aux.
 * 5. Ao final, os primeiros aux elementos do array contêm todos os
 *    valores únicos, em ordem — retorna aux como a quantidade de
 *    elementos únicos.
 *
 * Complexidade: O(n).
 */
