package leetCode;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
//non-decreasing order.

//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].

//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]

import java.util.Arrays;

public class TP_SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));

    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int nextHighestPosition = right;
        int[] response = new int[nums.length];
        while (left <= right) {
            int leftNumberSquared = nums[left] * nums[left];
            int rightNumberSquared = nums[right] * nums[right];
            if (leftNumberSquared > rightNumberSquared) {
                left++;
                response[nextHighestPosition] = leftNumberSquared;
            } else {
                right--;
                response[nextHighestPosition] = rightNumberSquared;
            }
            nextHighestPosition--;
        }
        return response;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dado um array ordenado (que pode ter negativos), retornar um
 * array com os quadrados de cada número, também ordenado.
 *
 * 1. Como o array de entrada já está ordenado (mas pode ter negativos),
 *    os maiores valores ao quadrado estarão sempre nas extremidades (o
 *    número mais negativo ou o mais positivo).
 * 2. Usa dois ponteiros, left no início e right no fim, e preenche o
 *    array de resposta de trás para frente (a partir de
 *    nextHighestPosition, começando no último índice).
 * 3. Compara o quadrado do valor em left com o quadrado do valor em
 *    right.
 * 4. Coloca o maior dos dois quadrados na posição mais alta ainda livre
 *    do array de resposta, avançando left (se o quadrado da esquerda foi
 *    o maior) ou recuando right (se foi o da direita).
 * 5. Repete até os ponteiros se cruzarem, preenchendo o array de resposta
 *    do maior para o menor valor — resultando em um array de quadrados
 *    já ordenado.
 *
 * Complexidade: O(n).
 */
