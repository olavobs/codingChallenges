package leetCode;

import java.util.HashMap;
import java.util.Map;

public class HM_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            var currentChar = s.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        }


        for (int i = 0; i < s.length(); i++) {
            var character = s.charAt(i);
            if (map.get(character) == 1) {
                return i;
            }
        }
        return -1;
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o índice do primeiro caractere que aparece apenas uma
 * vez em uma string.
 *
 * 1. Percorre a string uma primeira vez e conta, em um HashMap, quantas
 *    vezes cada caractere aparece.
 * 2. Percorre a string novamente, dessa vez em ordem, do início ao fim.
 * 3. Para cada caractere, verifica no mapa se a contagem dele é
 *    exatamente 1.
 * 4. Retorna o índice do primeiro caractere cuja contagem for 1 (o
 *    primeiro caractere único).
 * 5. Se nenhum caractere for único, retorna -1.
 *
 * Complexidade: O(n).
 */
