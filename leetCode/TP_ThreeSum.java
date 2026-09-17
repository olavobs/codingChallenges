package leetCode;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
//and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.

//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.

//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.

//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TP_ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum > 0) {
                    right--;
                } else if (currSum < 0) {
                    left++;
                } else {
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    //remove duplicate values from the left side, while they are the same increase left by 1
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    //remove duplicate values from the right side, while they are the same decrease right by 1
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return answer;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar todas as triplas de números em um array cuja soma
 * seja zero, sem repetir triplas.
 *
 * 1. Ordena o array de entrada — isso é essencial para usar a técnica de
 *    dois ponteiros e para facilitar a remoção de duplicatas.
 * 2. Percorre o array com um ponteiro i, fixando um número por vez como o
 *    primeiro elemento da tripla.
 * 3. Pula valores de i repetidos (comparando com o anterior) para evitar
 *    triplas duplicadas começando pelo mesmo número.
 * 4. Para cada i fixo, usa dois ponteiros (left logo após i, right no
 *    fim do array) para buscar os outros dois números cuja soma com
 *    nums[i] seja igual a zero.
 * 5. Se a soma dos três for maior que zero, move right para a esquerda
 *    (precisa de um valor menor); se for menor, move left para a
 *    direita (precisa de um valor maior); se for exatamente zero,
 *    encontrou uma tripla válida — adiciona ao resultado e move os dois
 *    ponteiros, pulando também valores duplicados de left e right para
 *    não repetir a mesma tripla.
 * 6. Retorna todas as triplas únicas encontradas cuja soma é zero.
 *
 * Complexidade: O(n²).
 */
