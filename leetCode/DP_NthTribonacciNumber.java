package leetCode;

//The Tribonacci sequence Tn is defined as follows:
//
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//Given n, return the value of Tn.
//
//
//
//Example 1:
//
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//Example 2:
//
//Input: n = 25
//Output: 1389537

public class DP_NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacci(2));
        System.out.println(tribonacci(3));
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        Integer[] memo = new Integer[n + 1];
        return tribonacci(n, memo);
    }

    public static int tribonacci(int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        return memo[n];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Calcular o n-ésimo número de Tribonacci, onde T0 = 0, T1 = 1,
 * T2 = 1 e Tn = Tn-1 + Tn-2 + Tn-3.
 *
 * 1. Casos base: se n == 0 retorna 0; se n for 1 ou 2 retorna 1.
 * 2. Cria um array memo (Integer[]) de tamanho n + 1 para guardar os
 *    valores já calculados (memoização / top-down).
 * 3. Antes de calcular T(n), verifica se memo[n] já foi preenchido; se
 *    sim, retorna o valor salvo.
 * 4. Caso contrário, calcula T(n - 1) + T(n - 2) + T(n - 3)
 *    recursivamente, salva em memo[n] e retorna.
 * 5. Assim cada valor de 0 a n é calculado uma única vez.
 *
 * Complexidade: O(n) tempo, O(n) espaço. Sem memo seria O(3^n).
 */
