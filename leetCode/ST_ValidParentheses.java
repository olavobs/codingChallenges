package leetCode;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "()[]{}"
        Output: true

        Example 3:
        Input: s = "(]"
        Output: false*/

import java.util.List;
import java.util.Stack;

public class ST_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}(())"));
    }

    public static boolean isValid(String s) {

        List<Character> acceptedOpen = List.of('{', '[', '(');

        Stack<Character> execution = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            var currentCharacter = s.charAt(i);
            if (acceptedOpen.contains(currentCharacter)) {
                execution.push(currentCharacter);
            } else {
                if (!execution.isEmpty() && execution.peek() == getClose(currentCharacter)) {
                    execution.pop();
                } else {
                    return false;
                }
            }
        }

        return execution.isEmpty();
    }

    private static Character getClose(Character currentChar) {
        return switch (currentChar) {
            case '}' -> '{';
            case ']' -> '[';
            case ')' -> '(';
            default -> ' ';
        };
    }


}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se uma string de parênteses, colchetes e chaves está
 * balanceada corretamente.
 *
 * 1. Define uma lista com os caracteres de abertura aceitos: '{', '[',
 *    '('.
 * 2. Usa uma pilha para guardar os caracteres de abertura encontrados, na
 *    ordem em que aparecem.
 * 3. Para cada caractere da string: se for um caractere de abertura,
 *    empilha; se for um caractere de fechamento, verifica se ele
 *    corresponde ao caractere de abertura no topo da pilha.
 * 4. Se corresponder, desempilha (o par foi fechado corretamente); se não
 *    corresponder (ou a pilha estiver vazia), a string é inválida —
 *    retorna false.
 * 5. Ao final, se a pilha estiver vazia, todos os pares foram fechados
 *    corretamente — retorna true; se sobrar algo na pilha, há abertura
 *    sem fechamento — retorna false.
 *
 * Complexidade: O(n).
 */
