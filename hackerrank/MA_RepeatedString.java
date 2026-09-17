package hackerrank;

import java.io.IOException;

class MA_RepeatedString {

    public static void main(String[] args) throws IOException {
        System.out.println(repeatedString("aba", 10L));
    }

    public static long repeatedString(String s, long n) {
        var rest = n % s.length();

        var division = n / s.length();

        var amountOfTimes = s.chars().filter(num -> num == 'a').count();

        var count = division * amountOfTimes;

        for (int i = 0; i <= rest - 1; i++) {

            if (s.charAt(i) == 'a') {
                count++;
            }

        }

        return count;
    }

}



/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dada uma string s repetida até formar uma string de tamanho n,
 * contar quantas vezes a letra 'a' aparece nessa string longa — sem
 * precisar construí-la de verdade.
 *
 * 1. Calcula quantas vezes a string s "cabe" completamente dentro de n
 *    caracteres (divisão inteira) e quantos caracteres sobram no final
 *    (resto).
 * 2. Conta quantas vezes a letra 'a' aparece dentro de uma única cópia de
 *    s.
 * 3. Multiplica essa contagem pelo número de repetições completas, para
 *    saber quantos 'a's existem em todas as cópias inteiras de s.
 * 4. Para os caracteres restantes (o resto que não forma uma cópia
 *    completa), percorre apenas essa parte inicial de s e soma +1 para
 *    cada 'a' encontrado.
 * 5. Retorna a soma total de ocorrências de 'a'.
 *
 * Complexidade: O(|s|), pois trabalha apenas com o tamanho de s, mesmo que
 * n seja gigantesco.
 */
