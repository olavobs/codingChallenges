package leetCode;

//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order
// of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do
// the following things:
//
//Change the array nums such that the first k elements of nums contain the elements which are not equal to
// val. The remaining elements of nums are not important as well as the size of nums.
//
//Return k.

//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).

//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are underscores).

public class TP_RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    private static void swap(int[] nums, int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Remover todas as ocorrências de um valor (val) de um array,
 * in-place, e retornar quantos elementos restaram diferentes de val.
 *
 * 1. Usa um ponteiro index, que marca a próxima posição onde um elemento
 *    válido (diferente de val) deve ser escrito.
 * 2. Percorre o array com outro ponteiro i.
 * 3. Sempre que encontra um elemento diferente de val, escreve esse valor
 *    na posição index e avança index.
 * 4. Elementos iguais a val são simplesmente "pulados" (sobrescritos por
 *    valores futuros).
 * 5. Ao final, os primeiros index elementos do array contêm todos os
 *    valores diferentes de val — retorna index como a quantidade desses
 *    elementos.
 *
 * Complexidade: O(n).
 */
