package leetCode;

//You are given an integer array coins representing coins of different denominations and an integer amount
// representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made
// up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.

//Example 1:
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//
//Input: coins = [2], amount = 3
//Output: -1
//Example 3:
//
//Input: coins = [1], amount = 0
//Output: 0
public class DP_CoinChange {

    public static void main(String[] args) {
        System.out.println("Teste 1 -> obtido: " + coinChange(new int[]{2, 3}, 8) + " | esperado: 3");
        System.out.println("Teste 2 -> obtido: " + coinChange(new int[]{1, 2, 5}, 11) + " | esperado: 3");
        System.out.println("Teste 3 -> obtido: " + coinChange(new int[]{2}, 3) + " | esperado: -1");
        System.out.println("Teste 4 -> obtido: " + coinChange(new int[]{1}, 0) + " | esperado: 0");
    }

    public static int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int result = coinChange(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int coinChange(int[] coins, int remaining, Integer[] memo) {
        if (remaining == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        if (memo[remaining] != null) {
            return memo[remaining];
        }

        for (int coin : coins) {
            if (coin <= remaining) {
                int coinsForRest = coinChange(coins, remaining - coin, memo);
                if (coinsForRest != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, coinsForRest + 1);
                }
            }
        }

        memo[remaining] = minCoins;
        return minCoins;

    }
}
