package leetCode;

//For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
// The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
// If word is not a substring of sequence, word's maximum k-repeating value is 0.
//Given strings sequence and word, return the maximum k-repeating value of word in sequence.

//Input: sequence = "ababc", word = "ab"
//Output: 2
//Explanation: "abab" is a substring in "ababc".

//Input: sequence = "ababc", word = "ba"
//Output: 1
//Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".

//Input: sequence = "ababc", word = "ac"
//Output: 0
//Explanation: "ac" is not a substring in "ababc".

public class BF_MaximumRepeatingSubstring {
    public static void main(String[] args) {
//        System.out.println(maxRepeating("ababc", "ab")); //2
//        System.out.println(maxRepeating("ababc", "ac")); //0
//        System.out.println(maxRepeating("ababc", "ba")); //1
        System.out.println(maxRepeating("aabaaaabaaaabaaaabaaaaba", "aaaba")); //5
    }

    public static int maxRepeating(String sequence, String word) {
        int k = 0;
        String curr = word;

        while (sequence.contains(curr)) {
            k++;
            curr += word;
        }

        return k;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar quantas vezes seguidas uma palavra (word) se repete
 * dentro de uma sequência (sequence), formando uma substring válida.
 *
 * 1. Começa com uma cópia da palavra (curr) e um contador k em zero.
 * 2. Enquanto a sequência contiver a substring atual (curr), incrementa k
 *    e concatena mais uma cópia da palavra a curr.
 * 3. Assim que curr (com mais uma repetição) deixa de ser encontrada
 *    dentro de sequence, o laço para.
 * 4. Retorna k, que representa quantas vezes seguidas a palavra se repete
 *    dentro da sequência.
 *
 * Complexidade: O(k * |sequence|) no pior caso, por causa do contains
 * repetido a cada iteração.
 */
