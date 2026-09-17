package leetCode;

//Given an array of integers nums and an integer target, return indices of the two numbers such that
// they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//
// Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HM_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6))); // 0,1
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); // 1,2
        System.out.println(Arrays.toString(twoSum(new int[]{3, 4, 0}, 3))); // 0,2
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // 0,1
    }

    public static int[] twoSum(int[] nums, int target) {
        // key: number; value: index
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numMap.containsKey(difference)) {
                return new int[]{numMap.get(difference), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar os índices de dois números em um array cuja soma seja
 * igual a um valor alvo (target).
 *
 * 1. Cria um HashMap para guardar cada número já visto e o índice em que
 *    ele apareceu.
 * 2. Para cada número do array, calcula a diferença necessária para
 *    chegar ao target (target - nums[i]).
 * 3. Verifica se essa diferença já existe no mapa — ou seja, se já vimos
 *    um número que, somado ao atual, dá exatamente o target.
 * 4. Se existir, retorna os dois índices: o guardado no mapa e o índice
 *    atual.
 * 5. Se não existir, adiciona o número atual e seu índice ao mapa e
 *    continua.
 *
 * Complexidade: O(n).
 */
