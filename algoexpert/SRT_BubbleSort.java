package algoexpert;

import java.util.Arrays;

public class SRT_BubbleSort {

    public static void main(String[] args) {
        var orderedArray = bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3});

        System.out.println(Arrays.toString(orderedArray));
    }

    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Ordenar um array de inteiros (Bubble Sort).
 *
 * 1. O laço externo (i) percorre cada posição do array, do início ao fim.
 * 2. Para cada posição i, o laço interno (j) percorre a partir de i até o
 *    final do array, comparando o valor em array[i] com cada array[j].
 * 3. Sempre que array[i] for maior que array[j], os dois valores são
 *    trocados de posição (swap) — isso "empurra" o menor valor encontrado
 *    até agora para a posição i.
 * 4. Ao final de cada iteração do laço externo, a posição i já contém o
 *    menor valor entre os elementos restantes (i em diante).
 * 5. Repetindo isso para todo i, o array fica ordenado em ordem crescente.
 *
 * Obs: essa implementação foge um pouco do bubble sort "clássico" (que
 * compara vizinhos consecutivos array[j] e array[j+1]) — aqui compara-se
 * sempre array[i] fixo com cada array[j] à frente.
 *
 * Complexidade: O(n²) tempo, O(1) espaço extra.
 */
