package leetCode;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
// represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
// letters.
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//Input: digits = "2"
//Output: ["a","b","c"]

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BT_LetterCombinationOfAPhoneNumber {

    private static final Map<Character, String> LETTERS = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public static void main(String[] args) {
        System.out.println(letterCombinations("947"));
        System.out.println(letterCombinations("45"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        generateAnswer(digits, 0, answer, "");
        return answer;
    }

    private static void generateAnswer(String digits, int position, List<String> answer, String currentCombination) {
        if (position == digits.length()) {
            answer.add(currentCombination);
            return;
        }

        String letters = LETTERS.get(digits.charAt(position));
        for (char letter : letters.toCharArray()) {
            generateAnswer(digits, position + 1, answer, currentCombination + letter);
        }
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dada uma string de dígitos de 2 a 9, retornar todas as
 * combinações de letras que esses dígitos podem formar no teclado de um
 * telefone.
 *
 * 1. Cria um Map (LETTERS) ligando cada dígito às letras do teclado
 *    (ex.: 2 → "abc").
 * 2. Se a string de dígitos estiver vazia, retorna a lista vazia.
 * 3. Chama a função recursiva generateAnswer começando na posição 0 com a
 *    combinação atual vazia ("").
 * 4. Caso base: se position == digits.length(), já escolheu uma letra para
 *    cada dígito → adiciona currentCombination na resposta e volta.
 * 5. Caso contrário, pega as letras do dígito atual e, para cada letra,
 *    chama a recursão para a próxima posição com a combinação atual +
 *    essa letra (backtracking: tenta cada opção e volta para tentar a
 *    próxima).
 * 6. Ao final, answer contém todas as combinações possíveis.
 *
 * Complexidade: O(4^n * n) tempo, onde n é o número de dígitos (até 4
 * letras por dígito, e cada combinação tem tamanho n).
 */
