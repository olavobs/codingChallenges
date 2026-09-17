package leetCode;

// Given a string s, find the length of the longest substring without duplicate characters.

//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.Map;

public class SW_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> aux = new HashMap<>();

        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (aux.containsKey(current)) {
                left = Math.max(left, aux.get(current) + 1);
            }
            aux.put(current, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o tamanho da maior substring sem caracteres
 * repetidos.
 *
 * 1. Usa um HashMap para guardar o índice mais recente em que cada
 *    caractere apareceu.
 * 2. Mantém dois ponteiros: left (início da janela atual) e right
 *    (percorre a string).
 * 3. Para cada caractere em right, verifica se ele já apareceu dentro da
 *    janela atual (está no mapa); se sim, move left para logo depois da
 *    última ocorrência desse caractere, encolhendo a janela para
 *    eliminar a repetição.
 * 4. Atualiza o mapa com a posição mais recente do caractere atual.
 * 5. Calcula o tamanho da janela atual (right - left + 1) e mantém o
 *    maior valor encontrado.
 * 6. Retorna o maior tamanho de substring sem caracteres repetidos.
 *
 * Complexidade: O(n).
 */
