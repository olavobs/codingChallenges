package leetCode;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
//the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.

//Input: nums = [1,3,5,6], target = 5
//Output: 2

//Input: nums = [1,3,5,6], target = 2
//Output: 1

//Input: nums = [1,3,5,6], target = 7
//Output: 4
public class BS_SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Buscar um valor em um array ordenado; se não existir, retornar
 * a posição onde ele deveria ser inserido para manter a ordenação.
 *
 * 1. Define os ponteiros left e right nos extremos do array.
 * 2. Faz busca binária: calcula o meio (mid) e compara com o alvo.
 * 3. Se encontrar o valor exato, retorna o índice mid imediatamente.
 * 4. Se o valor no meio for menor que o alvo, move left para mid + 1; se
 *    for maior, move right para mid - 1.
 * 5. Quando o laço termina sem encontrar o valor, left aponta exatamente
 *    para a posição onde o alvo deveria ser inserido para manter o array
 *    ordenado — é esse valor que é retornado.
 *
 * Complexidade: O(log n).
 */
