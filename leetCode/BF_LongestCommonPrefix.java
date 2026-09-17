package leetCode;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".

//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

public class BF_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"banana", "bandana", "bandolin", "basket"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String answer = "";

        if (strs.length == 0) {
            return answer;
        }

        answer = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(answer) != 0) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        return answer;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o maior prefixo comum entre um array de strings.
 *
 * 1. Se o array de strings estiver vazio, retorna uma string vazia.
 * 2. Assume a primeira string do array como candidata inicial ao prefixo
 *    comum.
 * 3. Para cada string seguinte, verifica se ela começa com o prefixo
 *    candidato (indexOf retornando 0).
 * 4. Enquanto não começar, remove o último caractere do prefixo candidato
 *    e testa de novo, encurtando o prefixo até que ele seja compatível
 *    com a string atual.
 * 5. Ao final, o que sobrar do prefixo candidato é o maior prefixo comum
 *    entre todas as strings do array.
 *
 * Complexidade: O(n*m), onde n é o número de strings e m o tamanho médio
 * delas.
 */
