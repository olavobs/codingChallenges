package leetCode;

//Write a function that reverses a string. The input string is given as an array of characters s.
//You must do this by modifying the input array in-place with O(1) extra memory.

//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]

//Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]

import java.util.Arrays;

public class TP_ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char aux = s[left];
            s[left] = s[right];
            s[right] = aux;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Inverter uma string representada como array de caracteres,
 * in-place, com memória extra O(1).
 *
 * 1. Define dois ponteiros: left no início do array e right no fim.
 * 2. Enquanto left for menor que right, troca (swap) os caracteres nas
 *    duas posições.
 * 3. Avança left para frente e recua right para trás a cada troca.
 * 4. Repete até os ponteiros se cruzarem, momento em que o array já está
 *    totalmente invertido, tudo feito in-place.
 * 5. Imprime o array já revertido.
 *
 * Complexidade: O(n) tempo, O(1) espaço extra.
 */
