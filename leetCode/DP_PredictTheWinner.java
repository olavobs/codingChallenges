package leetCode;

//You are given an integer array nums.
//
//Two players are playing a game with this array: Player 1 and Player 2.
//
//Player 1 and Player 2 take turns, with Player 1 starting first. Both players start the game with a score of 0.
//
//At each turn, the current player takes the number at either end of the array (i.e., nums[0] or
// nums[nums.length - 1]), removing it from the array and adding it to their own score. The game ends when
// there are no more elements in the array.
//
//Return true if Player 1's final score is greater than or equal to Player 2's final score, and false otherwise.
//
//Note that a tie counts as a win for Player 1. You may assume that both players play optimally.
//
//
//
//Example 1:
//
//Input: nums = [1,5,2]
//
//Output: false
//
//Explanation:
//
//Player 1 must open by taking either 1 or 2, and both choices lead to the same result.
//If Player 1 takes 1, the array becomes [5,2]. Player 2 takes 5, leaving 2 for Player 1.
//If Player 1 takes 2, the array becomes [1,5]. Player 2 takes 5, leaving 1 for Player 1.
//Either way, Player 1 finishes with 1 + 2 = 3 and Player 2 finishes with 5. Player 1 can never win, so
// return false.
//Example 2:
//
//Input: nums = [1,5,233,7]
//
//Output: true
//
//Explanation:
//
//Player 1 first takes 1, leaving [5,233,7]. Player 2 must then choose between 5 and 7, and no matter which
// number Player 2 chooses, Player 1 can take 233 on the next turn.
//Player 1 finishes with a higher score (234) than Player 2 (12), so return true.

public class DP_PredictTheWinner {

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2})); // false
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7})); // true
        System.out.println(predictTheWinner(new int[]{1, 2, 2, 1})); // true
        System.out.println(predictTheWinner(new int[]{1, 2, 3, 4, 2, 1})); // true
    }

    public static boolean predictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return diff(nums, memo, 0, nums.length - 1) >= 0;
    }

    private static int diff(int[] nums, Integer[][] memo, int left, int right) {
        if (left == right) return nums[left];

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int takeLeft = nums[left] - diff(nums, memo, left + 1, right);
        int takeRight = nums[right] - diff(nums, memo, left, right - 1);

        memo[left][right] = Math.max(takeLeft, takeRight);

        return memo[left][right];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dois jogadores tiram, alternadamente, um número de uma das
 * pontas do array e somam aos seus pontos. Dizer se o Jogador 1 termina
 * com pontuação maior ou igual à do Jogador 2, com os dois jogando de
 * forma ótima.
 *
 * 1. Em vez de guardar a pontuação de cada jogador, calcula a diferença
 *    "meus pontos - pontos do adversário" que o jogador da vez consegue
 *    no intervalo nums[left..right].
 * 2. Caso base: se left == right, só sobrou um número → o jogador da vez
 *    pega ele, a diferença é nums[left].
 * 3. Usa uma matriz memo (Integer[][]) indexada por [left][right] para
 *    guardar diferenças já calculadas; se existir, retorna direto.
 * 4. O jogador da vez tem duas escolhas:
 *    - takeLeft: pega nums[left] e o adversário passa a jogar em
 *      [left + 1, right], então a diferença é
 *      nums[left] - diff(left + 1, right);
 *    - takeRight: pega nums[right], diferença é
 *      nums[right] - diff(left, right - 1).
 *    Subtrai porque a diferença do adversário conta contra o jogador
 *    atual.
 * 5. Fica com a maior das duas opções, salva em memo[left][right] e
 *    retorna.
 * 6. No método principal, o Jogador 1 vence se a diferença no array
 *    inteiro for >= 0 (empate conta como vitória dele).
 *
 * Complexidade: O(n²) tempo e espaço (n² intervalos possíveis, cada um
 * calculado uma vez).
 */
