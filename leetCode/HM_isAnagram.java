package leetCode;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//Input: s = "anagram", t = "nagaram"
//Output: true

//Input: s = "rat", t = "car"
//Output: false

import java.util.Arrays;

public class HM_isAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ggii", "eekk"));
    }

    public static boolean isAnagram(String s, String t) {
        // Option 1
//        return sortString(s).equals(sortString(t));

        // Option 2
        if (s.length() != t.length()) {
            return false;
        }

        int[] c = new int[26];

        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int value : c) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    private static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se duas strings são anagramas uma da outra.
 *
 * 1. (Usando a Opção 2, ativa no código) Se as strings tiverem tamanhos
 *    diferentes, já não podem ser anagramas — retorna false direto.
 * 2. Cria um array de 26 posições (uma para cada letra do alfabeto),
 *    inicializado em zero.
 * 3. Percorre as duas strings ao mesmo tempo: incrementa a posição
 *    correspondente à letra de s, e decrementa a posição correspondente
 *    à letra de t.
 * 4. Ao final, se as strings forem anagramas, cada posição do array deve
 *    estar zerada (as contagens se cancelaram exatamente).
 * 5. Se alguma posição for diferente de zero, as strings não são
 *    anagramas — retorna false; senão, retorna true.
 *
 * Obs: há também uma Opção 1 comentada, que ordena as duas strings e
 * compara — mais simples, mas O(n log n).
 *
 * Complexidade da versão ativa: O(n).
 */
