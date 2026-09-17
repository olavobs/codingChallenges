package leetCode;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
//non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.

//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "a man a plan a c a nalp a nam a" is a palindrome.

//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.

//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

public class TP_ValidPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome(" "));
//        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("0z;z   ; 0"));

    }

    public static boolean isPalindrome(String s) {
        String adjustedString = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (adjustedString.length() < 2) {
            return true;
        }

        int left = 0;
        int right = adjustedString.length() - 1;
        while (left < right) {
            if (adjustedString.charAt(left) != adjustedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

//        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se uma frase é um palíndromo, ignorando maiúsculas e
 * caracteres não alfanuméricos.
 *
 * 1. Remove espaços das extremidades, elimina todos os caracteres que não
 *    são letras ou números (usando regex), e converte tudo para
 *    minúsculas — gerando uma versão "limpa" da string.
 * 2. Se a string limpa tiver menos de 2 caracteres, já é automaticamente
 *    um palíndromo — retorna true.
 * 3. Usa dois ponteiros, left no início e right no fim da string limpa.
 * 4. Compara os caracteres nas duas extremidades; se forem diferentes em
 *    algum momento, não é um palíndromo — retorna false.
 * 5. Avança left e recua right a cada comparação bem-sucedida, até eles
 *    se cruzarem.
 * 6. Se todas as comparações passarem, é um palíndromo — retorna true.
 *
 * Complexidade: O(n).
 */
