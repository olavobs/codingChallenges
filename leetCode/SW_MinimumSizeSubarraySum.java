package leetCode;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
// sum is greater than or equal to target. If there is no such subarray, return 0 instead.

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

//Input: target = 4, nums = [1,4,4]
//Output: 1

//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0

public class SW_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o menor tamanho de subarray contígua cuja soma seja
 * maior ou igual a um valor alvo (target).
 *
 * 1. Usa dois ponteiros, left e right, formando uma janela deslizante, e
 *    uma variável sum para a soma da janela atual.
 * 2. Expande a janela avançando right e somando o valor correspondente a
 *    sum.
 * 3. Enquanto a soma da janela for maior ou igual ao target, tenta
 *    encolher a janela pela esquerda: atualiza o menor tamanho
 *    encontrado (min), subtrai o valor que sai da janela de sum, e avança
 *    left.
 * 4. Repete até right percorrer todo o array.
 * 5. Se nenhuma subarray válida foi encontrada, retorna 0; caso
 *    contrário, retorna o menor tamanho de subarray cuja soma é maior ou
 *    igual ao target.
 *
 * Complexidade: O(n).
 */
