package leetCode;

//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return
// the answer in any order.

//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".

//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SW_FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        p = sortString(p);
        int left = 0, right = left + p.length();
        List<Integer> answer = new ArrayList<>();

        while (right <= s.length()) {
            String currentValue = s.substring(left, right);
            currentValue = sortString(currentValue);
            if (currentValue.equals(p)) {
                answer.add(left);
            }

            left++;
            right++;
        }
        return answer;
    }

    private static String sortString(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar todos os índices iniciais em uma string s onde existe
 * um anagrama de outra string p.
 *
 * 1. Ordena as letras da string p (o padrão a ser encontrado) uma única
 *    vez.
 * 2. Define uma janela deslizante de tamanho igual ao de p, começando no
 *    início da string s.
 * 3. Para cada posição da janela, extrai a substring correspondente,
 *    ordena suas letras também, e compara com p já ordenado.
 * 4. Se forem iguais (mesma composição de letras), a posição inicial da
 *    janela é um índice de anagrama válido — adiciona à lista de
 *    resultados.
 * 5. Desliza a janela uma posição para frente (left++ e right++) e repete
 *    até o fim da string.
 * 6. Retorna a lista com todos os índices iniciais de anagramas
 *    encontrados.
 *
 * Complexidade: O(n * m log m), onde m é o tamanho de p (por causa da
 * ordenação repetida a cada janela).
 */
