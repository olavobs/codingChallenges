package hellointerview;

//Given an array of integers nums and an integer k, find the maximum sum of any contiguous subarray of size k.

//nums = [2, 1, 5, 1, 3, 2]
//k = 3

public class SW_MaximumSumOfSubarraysOfSizeK {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    public static Integer maxSum(int[] nums, Integer k) {
        int current = 0;

        for (int i = 0; i < k; i++) {
            current += nums[i];
        }

        int answer = current;
        for (int i = k; i < nums.length; i++) {
            current += nums[i];
            current -= nums[i - k];
            answer = Math.max(answer, current);
        }
        return answer;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar a maior soma entre todas as subarrays contíguas de
 * tamanho k.
 *
 * 1. Calcula a soma dos primeiros k elementos do array — essa é a "janela"
 *    inicial.
 * 2. Guarda essa soma como o maior valor encontrado até agora (answer).
 * 3. Desliza a janela: para cada próximo elemento, soma o novo elemento
 *    que entra na janela e subtrai o elemento mais antigo que sai dela
 *    (k posições atrás).
 * 4. Compara a soma atual da janela com o maior valor encontrado e
 *    atualiza se for maior.
 * 5. Repete até o fim do array e retorna a maior soma encontrada entre
 *    todas as janelas de tamanho k.
 *
 * Complexidade: O(n).
 */
