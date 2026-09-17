package codewars;

public class BF_MultiplesOf3Or5 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int number) {
        var sum = 0;

        if (number < 1) {
            return sum;
        }

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Somar todos os múltiplos de 3 ou 5 abaixo de um número dado.
 *
 * 1. Se o número for menor que 1, retorna 0 direto (não há múltiplos a
 *    somar).
 * 2. Percorre todos os inteiros de 0 até number - 1.
 * 3. Para cada i, verifica se é múltiplo de 3 ou de 5 (resto da divisão
 *    igual a 0).
 * 4. Se for, soma i ao total acumulado.
 * 5. Retorna a soma acumulada.
 *
 * Complexidade: O(n).
 */
