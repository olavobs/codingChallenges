package leetCode;

//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
// target in nums. If target exists, then return its index. Otherwise, return -1.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//Example 1:
//
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1

public class BS_BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Buscar um valor (target) em um array ordenado, retornando seu
 * índice ou -1 se não existir, em tempo O(log n).
 *
 * 1. Define dois ponteiros, left no início e right no fim do array.
 * 2. Enquanto left for menor ou igual a right, calcula o ponto médio
 *    (middle).
 * 3. Se o valor no meio for igual ao alvo, retorna o índice middle.
 * 4. Se o valor no meio for menor que o alvo, descarta a metade esquerda
 *    (left = middle + 1); se for maior, descarta a metade direita
 *    (right = middle - 1).
 * 5. Se o laço terminar sem encontrar o valor, retorna -1.
 *
 * Complexidade: O(log n).
 */
