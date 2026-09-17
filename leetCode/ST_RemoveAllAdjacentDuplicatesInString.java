package leetCode;

//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing
// two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer
// is unique.

//Input: s = "abbaca"
//Output: "ca"
//Explanation:
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the
// only possible move.  The result of this move is that the string is "aaca", of which only "aa" is
// possible, so the final string is "ca".

//Input: s = "azxxzy"
//Output: "ay"

import java.util.Stack;

public class ST_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> sta = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (sta.isEmpty() || sta.peek() != currentChar) {
                sta.push(currentChar);
            } else {
                sta.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : sta) {
            sb.append(c);
        }
        return sb.toString();
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Remover repetidamente pares de letras adjacentes e iguais de
 * uma string, até não haver mais pares para remover.
 *
 * 1. Usa uma pilha (Stack) de caracteres.
 * 2. Para cada caractere da string, verifica se a pilha está vazia ou se
 *    o topo dela é diferente do caractere atual.
 * 3. Se for diferente (ou a pilha estiver vazia), empilha o caractere
 *    atual.
 * 4. Se for igual ao topo, significa que encontramos um par adjacente
 *    igual — desempilha (removendo os dois caracteres da string final).
 * 5. Ao final, monta a string resultante a partir dos caracteres que
 *    restaram na pilha, na ordem em que foram empilhados.
 *
 * Complexidade: O(n).
 */
