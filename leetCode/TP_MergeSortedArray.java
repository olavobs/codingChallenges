package leetCode;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
// representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
// merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

public class TP_MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{1, 5, 6, 7, 0, 0, 0, 0}, 4, new int[]{2, 3, 4, 8}, 4);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Mesclar dois arrays já ordenados (nums1 e nums2) em um único
 * array ordenado, armazenando o resultado dentro do próprio nums1 (que
 * tem espaço extra reservado no final).
 *
 * 1. Define três ponteiros: i no último elemento válido de nums1, j no
 *    último elemento de nums2, e k na última posição do array combinado
 *    (m + n - 1).
 * 2. Percorre de trás para frente: compara nums1[i] com nums2[j].
 * 3. Coloca o maior dos dois na posição k (começando pelo fim),
 *    decrementando o ponteiro correspondente (i ou j) e sempre
 *    decrementando k.
 * 4. Continua enquanto ainda houver elementos de nums2 para processar
 *    (j >= 0) — os elementos restantes de nums1, se sobrarem, já estão
 *    na posição correta.
 * 5. Ao final, nums1 contém o resultado da fusão ordenada, sem precisar
 *    de um array auxiliar.
 *
 * Complexidade: O(m + n).
 */
