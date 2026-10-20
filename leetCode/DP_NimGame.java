package leetCode;

//You are playing the following Nim Game with your friend:
//
//Initially, there is a heap of stones on the table.
//You and your friend will alternate taking turns, and you go first.
//On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
//The one who removes the last stone is the winner.

//Given n, the number of stones in the heap, return true if you can win the game assuming both you and your
// friend play optimally, otherwise return false.
//
//Example 1:
//
//Input: n = 4
//Output: false
//Explanation: These are the possible outcomes:
//1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
//2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
//3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
//In all outcomes, your friend wins.
//Example 2:
//
//Input: n = 1
//Output: true
//Example 3:
//
//Input: n = 2
//Output: true

public class DP_NimGame {

    public static void main(String[] args) {
        System.out.println(canWinNim(1)); // true
        System.out.println(canWinNim(2)); // true
        System.out.println(canWinNim(4)); // false
        System.out.println(canWinNim(8)); // false
        System.out.println(canWinNim(10)); // true
    }

    public static boolean canWinNim(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return canWin(memo, n);
    }

    private static boolean canWin(Boolean[] memo, int stones) {
        if (stones == 0) {
            return false;
        }
        if (stones <= 3) {
            return true;
        }

        if (memo[stones] != null) {
            return memo[stones];
        }

        boolean result = false;
        for (int i = 1; i <= 3; i++) {
            if (!canWin(memo, stones - i)) {
                result = true;
                break;
            }
        }
        memo[stones] = result;
        return result;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dado um monte com n pedras, onde cada jogador tira de 1 a 3
 * pedras por vez e quem tira a última vence, dizer se quem começa
 * consegue ganhar jogando de forma ótima.
 *
 * 1. Define o subproblema: "o jogador da vez consegue ganhar com stones
 *    pedras no monte?".
 * 2. Casos base:
 *    - stones == 0: não sobrou pedra para tirar, o outro jogador já tirou
 *      a última → o jogador da vez perdeu, retorna false;
 *    - stones <= 3: dá para tirar todas de uma vez → retorna true.
 * 3. Usa um array memo (Boolean[]) indexado pela quantidade de pedras para
 *    guardar respostas já calculadas; se memo[stones] existir, retorna
 *    direto.
 * 4. Testa as três jogadas possíveis (tirar 1, 2 ou 3 pedras). Se alguma
 *    delas deixar o adversário numa posição perdedora
 *    (!canWin(stones - i)), o jogador da vez vence → result = true e para
 *    o laço.
 * 5. Se nenhuma jogada deixar o adversário perdendo, result fica false.
 *    Salva em memo[stones] e retorna.
 *
 * Obs: rodando os exemplos dá para ver o padrão: só se perde quando n é
 * múltiplo de 4, então a resposta também pode ser simplesmente
 * n % 4 != 0, em O(1).
 *
 * Complexidade da versão com memo: O(n) tempo, O(n) espaço.
 */
