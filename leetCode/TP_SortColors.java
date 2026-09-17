package leetCode;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
// same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.

//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]

//Input: nums = [2,0,1]
//Output: [0,1,2]

import java.util.Arrays;

public class TP_SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{1, 2, 0});
    }

    public static void sortColors(int[] nums) {
        int index = 0;
        int next0pos = 0;
        int next2pos = nums.length - 1;

        while (index <= next2pos) {
            if (nums[index] == 0) {
                swap(nums, index, next0pos);
                next0pos++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, next2pos);
                next2pos--;
            } else {
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Ordenar in-place um array de 0s, 1s e 2s (representando cores),
 * sem usar a função de ordenação padrão.
 *
 * 1. Usa três ponteiros (técnica conhecida como "Dutch National Flag"):
 *    index percorre o array, next0pos marca onde o próximo 0 deve ir, e
 *    next2pos marca onde o próximo 2 deve ir (começando no fim do array).
 * 2. Enquanto index for menor ou igual a next2pos: se o elemento atual
 *    for 0, troca com a posição next0pos e avança tanto next0pos quanto
 *    index; se for 2, troca com a posição next2pos e apenas recua
 *    next2pos (sem avançar index, pois o valor trocado para cá ainda
 *    precisa ser reavaliado).
 * 3. Se o elemento atual for 1, já está no lugar certo (no meio) — apenas
 *    avança index.
 * 4. Repete até index ultrapassar next2pos, momento em que todos os 0s
 *    estarão no início, os 1s no meio e os 2s no final.
 * 5. Imprime o array já ordenado.
 *
 * Complexidade: O(n) tempo, O(1) espaço extra (uma única passada,
 * ordenação in-place).
 */
