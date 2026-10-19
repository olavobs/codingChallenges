package codewars;

import java.util.HashMap;
import java.util.Map;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once
 * in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a
 * character is a duplicate.
 * EXAMPLES:
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 **/

public class BF_DuplicateEncoder {

    public static void main(String[] args) {
        var word = "din";
        System.out.println(encoder(word));
        var word2 = "recede";
        System.out.println(encoder(word2));
        var word3 = "Success";
        System.out.println(encoder(word3));
        var word4 = "(( @";
        System.out.println(encoder(word4));

    }

    public static String encoder(String word) {
        StringBuilder result = new StringBuilder();
        word = word.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (Character c : word.toCharArray()) {
            String current = map.get(c) > 1 ? ")" : "(";
            result.append(current);
        }

        return result.toString();
    }

//    public static String encoder(String word) {
//        word = word.toLowerCase();
//        String result = "";
//        for (int i = 0; i < word.length(); ++i) {
//            char c = word.charAt(i);
//            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
//        }
//        return result;
//    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Para cada caractere de uma string, retornar "(" se ele aparece
 * só uma vez, ou ")" se aparece mais de uma vez (ignorando maiúsculas).
 *
 * 1. Converte a palavra inteira para minúsculas para ignorar capitalização.
 * 2. Percorre a palavra uma vez contando quantas vezes cada caractere
 *    aparece, guardando em um HashMap (caractere → quantidade) com
 *    getOrDefault(character, 0) + 1.
 * 3. Percorre a palavra de novo e, para cada caractere, consulta a
 *    contagem no map.
 * 4. Se a contagem for maior que 1, o caractere se repete → adiciona ")"
 *    ao resultado; senão, aparece só uma vez → adiciona "(".
 * 5. Usa um StringBuilder para montar a string de saída e retorna
 *    result.toString().
 *
 * Obs: o método comentado acima faz a mesma coisa sem HashMap, comparando
 * a primeira (indexOf) e a última (lastIndexOf) ocorrência de cada
 * caractere — se forem a mesma posição, ele aparece só uma vez. É mais
 * simples, mas O(n²), pois indexOf/lastIndexOf percorrem a string a cada
 * caractere.
 *
 * Complexidade da versão ativa: O(n), pois são só duas passadas pela
 * string e cada acesso ao HashMap é O(1).
 */
