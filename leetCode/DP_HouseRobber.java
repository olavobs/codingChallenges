package leetCode;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
// and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
// can rob tonight without alerting the police.
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
public class DP_HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7}));
        System.out.println(rob(new int[]{2, 7, 9}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    public static int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return rob(nums, memo, 0);
    }

    public static int rob(int[] nums, Integer[] memo, int pos) {
        if (pos >= nums.length) {
            return 0;
        }

        if (memo[pos] != null) {
            return memo[pos];
        }

        int stealing = nums[pos] + rob(nums, memo, pos + 2);
        int skipping = rob(nums, memo, pos + 1);

        memo[pos] = Math.max(stealing, skipping);
        return memo[pos];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Descobrir o maior valor que dá para roubar de uma fileira de
 * casas, sem nunca roubar duas casas vizinhas.
 *
 * 1. Define o subproblema: "qual o maior valor possível a partir da casa
 *    pos até o fim da rua?".
 * 2. Caso base: se pos >= nums.length, não há mais casas → retorna 0.
 * 3. Usa um array memo (Integer[]) indexado pela posição para guardar
 *    respostas já calculadas; se memo[pos] existir, retorna direto.
 * 4. Em cada casa existem duas escolhas:
 *    - roubar (stealing): pega nums[pos] e pula a vizinha, indo para
 *      pos + 2;
 *    - pular (skipping): não rouba essa casa e vai para pos + 1.
 * 5. Fica com o maior entre as duas opções, salva em memo[pos] e retorna.
 * 6. A chamada inicial começa em pos = 0.
 *
 * Complexidade: O(n) tempo, O(n) espaço.
 */
