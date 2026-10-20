package leetCode;

// Alice and Bob take turns playing a game, with Alice starting first.
//
//There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or
// the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in
// the row. The winner is the one with the higher score when there are no stones left to remove.
//
//Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the
// score's difference. Alice's goal is to maximize the difference in the score.
//
//Given an array of integers stones where stones[i] represents the value of the ith stone from the left,
// return the difference in Alice and Bob's score if they both play optimally.
//
//Example 1:
//
//Input: stones = [5,3,1,4,2]
//Output: 6
//Explanation:
//- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
//- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
//- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
//- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
//- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
//The score difference is 18 - 12 = 6.
//Example 2:
//
//Input: stones = [7,90,5,1,100,10,10,2]
//Output: 122

public class DP_StoneGameVII {

    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }

    public static int stoneGameVII(int[] stones) {
        int length = stones.length;
        Integer[] sumAux = new Integer[length + 1];
        sumAux[0] = 0;

        for (int i = 0; i < length; i++) {
            sumAux[i + 1] = sumAux[i] + stones[i];
        }
        Integer[][] memo = new Integer[length][length];
        return generate(sumAux, memo, 0, length - 1);
    }

    private static int sum(Integer[] sumAux, int left, int right) {
        return sumAux[right + 1] - sumAux[left];
    }

    private static int generate(Integer[] sumAux, Integer[][] memo, int left, int right) {
        if (left == right) return 0;

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int takeLeft = sum(sumAux, left + 1, right) - generate(sumAux, memo, left + 1, right);
        int takeRight = sum(sumAux, left, right - 1) - generate(sumAux, memo, left, right - 1);

        memo[left][right] = Math.max(takeLeft, takeRight);
        return memo[left][right];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Alice e Bob removem, alternadamente, a pedra da ponta esquerda
 * ou da direita e ganham pontos iguais à soma das pedras que SOBRAM na
 * fileira. Retornar a diferença entre os pontos de Alice e de Bob, com os
 * dois jogando de forma ótima.
 *
 * 1. Monta um array de soma de prefixos (sumAux), onde sumAux[i + 1] é a
 *    soma de stones[0..i]. Assim a soma de qualquer intervalo [left, right]
 *    sai em O(1): sumAux[right + 1] - sumAux[left] (método sum).
 * 2. Define o subproblema: "qual a maior diferença 'meus pontos - pontos
 *    do adversário' que o jogador da vez consegue com as pedras
 *    stones[left..right]?".
 * 3. Caso base: se left == right, só sobrou uma pedra → quem a remove
 *    ganha 0 pontos (não sobra nada), então a diferença é 0.
 * 4. Usa uma matriz memo (Integer[][]) indexada por [left][right] para
 *    guardar diferenças já calculadas; se existir, retorna direto.
 * 5. O jogador da vez tem duas escolhas:
 *    - takeLeft: remove a pedra da esquerda, ganha a soma de
 *      [left + 1, right] e o adversário passa a jogar nesse intervalo:
 *      sum(left + 1, right) - generate(left + 1, right);
 *    - takeRight: remove a pedra da direita, ganha a soma de
 *      [left, right - 1]: sum(left, right - 1) - generate(left, right - 1).
 *    Subtrai porque a diferença do adversário conta contra o jogador
 *    atual.
 * 6. Fica com a maior das duas opções, salva em memo[left][right] e
 *    retorna.
 * 7. A chamada inicial no array inteiro (0 até length - 1) já é a
 *    diferença Alice - Bob, porque Alice começa. Maximizar essa diferença
 *    do ponto de vista de cada jogador atende ao mesmo tempo ao objetivo de
 *    Alice (aumentar) e ao de Bob (diminuir).
 *
 * Obs: é o mesmo raciocínio do DP_StoneGame e do DP_PredictTheWinner; a
 * diferença é que o ponto ganho não é a pedra removida, e sim a soma das
 * restantes — por isso a soma de prefixos.
 *
 * Complexidade: O(n²) tempo e espaço.
 */
