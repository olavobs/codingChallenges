package leetCode;

//Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and
// each pile has a positive integer number of stones piles[i].
//
//The objective of the game is to end with the most stones. The total number of stones across all the piles
// is odd, so there are no ties.
//
//Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones
// either from the beginning or from the end of the row. This continues until there are no more piles left,
// at which point the person with the most stones wins.
//
//Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
//
//Example 1:
//
//Input: piles = [5,3,4,5]
//Output: true
//Explanation:
//Alice starts first, and can only take the first 5 or the last 5.
//Say she takes the first 5, so that the row becomes [3, 4, 5].
//If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
//If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
//This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
//Example 2:
//
//Input: piles = [3,7,2,3]
//Output: true

public class DP_StoneGame {

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println(stoneGame(new int[]{3, 7, 2, 3}));
        System.out.println(stoneGame(new int[]{3, 7, 1}));
    }

    public static boolean stoneGame(int[] piles) {
        Integer[][] memo = new Integer[piles.length][piles.length];
        return diff(piles, memo, 0, piles.length - 1) > 0;
    }

    private static int diff(int[] piles, Integer[][] memo, int left, int right) {
        if (left == right) {
            return piles[left];
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int takeLeft = piles[left] - diff(piles, memo, left + 1, right);
        int takeRight = piles[right] - diff(piles, memo, left, right - 1);

        memo[left][right] = Math.max(takeLeft, takeRight);

        return memo[left][right];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Alice e Bob tiram, alternadamente, uma pilha de pedras de uma
 * das pontas da fileira. Dizer se Alice (que começa) termina com mais
 * pedras, com os dois jogando de forma ótima.
 *
 * 1. Em vez de guardar as pedras de cada jogador, calcula a diferença
 *    "minhas pedras - pedras do adversário" que o jogador da vez consegue
 *    no intervalo piles[left..right].
 * 2. Caso base: se left == right, só sobrou uma pilha → o jogador da vez
 *    pega ela, a diferença é piles[left].
 * 3. Usa uma matriz memo (Integer[][]) indexada por [left][right] para
 *    guardar diferenças já calculadas; se existir, retorna direto.
 * 4. O jogador da vez tem duas escolhas:
 *    - takeLeft: pega piles[left] e o adversário passa a jogar em
 *      [left + 1, right], então a diferença é
 *      piles[left] - diff(left + 1, right);
 *    - takeRight: pega piles[right], diferença é
 *      piles[right] - diff(left, right - 1).
 *    Subtrai porque a diferença do adversário conta contra o jogador
 *    atual.
 * 5. Fica com a maior das duas opções, salva em memo[left][right] e
 *    retorna.
 * 6. No método principal, Alice vence se a diferença na fileira inteira
 *    for > 0 (o total de pedras é ímpar, então não há empate).
 *
 * Obs: é o mesmo raciocínio do DP_PredictTheWinner. Pelas regras do
 * enunciado (número par de pilhas e total ímpar) quem começa sempre pode
 * garantir a vitória, então a resposta também poderia ser só true.
 *
 * Complexidade: O(n²) tempo e espaço.
 */
