package leetCode;

//Verificar se um número é palíndromo

public class TP_PalindromeNumber {

    public static void main(String[] args) {
        var num = 122232221;

        System.out.println(isPalindrome(num));
    }

    private static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        var stringNumber = Integer.toString(x);

        var length = stringNumber.length();

        for (int i = 0; i < stringNumber.length() / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }


}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se um número inteiro é palíndromo (lê-se igual de
 * trás para frente).
 *
 * 1. Se o número for negativo, já não pode ser palíndromo (por causa do
 *    sinal) — retorna false direto.
 * 2. Converte o número para string.
 * 3. Percorre a string comparando caracteres a partir das duas
 *    extremidades em direção ao centro (posição i com posição
 *    length - 1 - i).
 * 4. Se em algum momento os caracteres comparados forem diferentes, não é
 *    um palíndromo — retorna false.
 * 5. Se todas as comparações passarem, é um palíndromo — retorna true.
 *
 * Complexidade: O(n), onde n é o número de dígitos.
 */
