package leetCode;

//Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]

//Input: nums = [1], k = 1
//Output: [1]

//Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
//Output: [1,2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PQ_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 3)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        minHeap.addAll(frequencyMap.entrySet());

        int[] answer = new int[k];
        int aux = 0;
        while (aux < k) {
            answer[aux] = minHeap.poll().getKey();
            aux++;
        }
        return answer;

//        List < Map.Entry < Integer, Integer >> list = new ArrayList<>(frequencyMap.entrySet());
//        list.sort((a, b) -> b.getValue() - a.getValue());
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = list.get(i).getKey();
//        }
//        return result;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar os k elementos mais frequentes de um array.
 *
 * 1. Cria um HashMap para contar quantas vezes cada número aparece no
 *    array.
 * 2. Cria uma PriorityQueue (max-heap) que ordena as entradas do mapa
 *    pela frequência, da maior para a menor, e adiciona todas as
 *    entradas do mapa de uma vez.
 * 3. Remove k elementos do topo da heap (os de maior frequência) e guarda
 *    suas chaves no array de resposta.
 * 4. Retorna o array com os k elementos mais frequentes.
 *
 * Obs: há uma alternativa comentada no fim que ordena uma lista de
 * entradas em vez de usar heap — mesma ideia, implementação diferente.
 *
 * Complexidade: O(n log n) (heap com todos os elementos do mapa).
 */
