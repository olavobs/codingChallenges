package leetCode;

//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number
// is the sum of the two preceding ones, starting from 0 and 1. That is, F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//Given n, calculate F(n).

//Example 1:
//
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//Example 2:
//
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//Example 3:
//
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//

public class DP_FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(30));
    }

    private static int fibonacci(int n) {
        Integer[] memo = new Integer[n + 1];
        return fibonacci(n, memo);
    }

    private static int fibonacci(int n, Integer[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Calcular o n-ésimo número de Fibonacci, onde F(0) = 0,
 * F(1) = 1 e F(n) = F(n - 1) + F(n - 2).
 *
 * 1. Casos base: F(0) = 0 e F(1) = 1, retornados diretamente.
 * 2. Cria um array memo (Integer[]) de tamanho n + 1 para guardar os
 *    valores já calculados (memoização / top-down).
 * 3. Antes de calcular F(n), verifica se memo[n] já foi preenchido; se
 *    sim, retorna o valor salvo.
 * 4. Caso contrário, calcula F(n - 1) + F(n - 2) recursivamente, salva o
 *    resultado em memo[n] e retorna.
 * 5. Assim cada valor de 0 a n é calculado uma única vez.
 *
 * Complexidade: O(n) tempo, O(n) espaço. Sem memo seria O(2^n).
 */
