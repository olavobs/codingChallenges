package leetCode;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

//Input: strs = [""]
//Output: [[""]]

//Input: strs = ["a"]
//Output: [["a"]]

import java.util.*;

public class HM_GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> aux = new HashMap<>();

        for (String curr : strs) {
            String sortedWord = sort(curr);
            if (!aux.containsKey(sortedWord)) {
                aux.put(sortedWord, new ArrayList<>());
            }
            aux.get(sortedWord).add(curr);
        }
        return new ArrayList<>(aux.values());
    }

    private static String sort(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Agrupar um array de strings em grupos de anagramas (palavras
 * que usam as mesmas letras, em qualquer ordem).
 *
 * 1. Cria um HashMap onde a chave é a versão "ordenada" (letras em ordem
 *    alfabética) de cada palavra, e o valor é a lista de palavras
 *    originais que compartilham essa mesma assinatura.
 * 2. Para cada palavra do array, ordena suas letras para gerar a chave.
 * 3. Se a chave ainda não existir no mapa, cria uma nova lista vazia para
 *    ela.
 * 4. Adiciona a palavra original à lista correspondente à sua chave —
 *    anagramas caem sempre na mesma lista, pois têm a mesma versão
 *    ordenada.
 * 5. Retorna todas as listas de valores do mapa, cada uma representando
 *    um grupo de anagramas.
 *
 * Complexidade: O(n * m log m), onde m é o tamanho médio das palavras
 * (por causa da ordenação de cada uma).
 */
