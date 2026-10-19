package leetCode;

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//

public class DP_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1)); //1
        System.out.println(climbStairs(2)); //2
        System.out.println(climbStairs(3)); //3
        System.out.println(climbStairs(4)); //5
        System.out.println(climbStairs(5)); //8
    }

    public static int climbStairs(int n) {
        Integer[] memo = new Integer[n + 1];

        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, Integer[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Contar de quantas formas distintas é possível subir uma escada
 * de n degraus, subindo 1 ou 2 degraus por vez.
 *
 * 1. Para chegar ao degrau n, o último passo veio do degrau n - 1 (subindo
 *    1) ou do degrau n - 2 (subindo 2). Logo:
 *    formas(n) = formas(n - 1) + formas(n - 2) — a mesma recorrência de
 *    Fibonacci.
 * 2. Caso base: se n <= 1, existe só 1 forma → retorna 1.
 * 3. Usa um array memo (Integer[], começa com null) para guardar o
 *    resultado de cada n já calculado (memoização / top-down).
 * 4. Antes de calcular, verifica se memo[n] já tem valor; se tiver,
 *    retorna direto, evitando recalcular os mesmos subproblemas.
 * 5. Caso contrário, calcula recursivamente, salva em memo[n] e retorna.
 *
 * Complexidade: O(n) tempo, O(n) espaço (memo + pilha de recursão).
 * Sem memo seria O(2^n).
 */
