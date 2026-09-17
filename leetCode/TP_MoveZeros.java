package leetCode;

//Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while
//keeping the order of non-zero elements unchanged. Perform this operation in-place without creating a copy
//of the array.

//nums = [2,0,4,0,9]
// output: [2,4,9,0,0]


import java.util.Arrays;

public class TP_MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{2, 0, 4, 0, 0, 0, 1, 9});
    }


    public static void moveZeroes(int[] nums) {
        int zeroPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[zeroPosition];
                nums[zeroPosition] = nums[i];
                nums[i] = temp;
                zeroPosition++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Mover todos os zeros de um array para o final, mantendo a
 * ordem relativa dos elementos não-zero, sem criar uma cópia do array.
 *
 * 1. Usa um ponteiro zeroPosition, que marca a próxima posição onde um
 *    elemento não-zero deve ser colocado.
 * 2. Percorre o array com outro ponteiro i.
 * 3. Sempre que encontra um elemento diferente de zero, troca (swap) esse
 *    elemento com o que está na posição zeroPosition, e avança
 *    zeroPosition.
 * 4. Como os zeros "ficam para trás" a cada troca, ao final do laço
 *    todos os elementos não-zero estarão agrupados no início, na ordem
 *    original, e os zeros empurrados para o final.
 * 5. Imprime o array já reorganizado.
 *
 * Complexidade: O(n).
 */
