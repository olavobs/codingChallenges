package codility;

public class BF_BinaryGap {

//    A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
//    For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
//    Write a function:
//    class Solution { public int solution(int N); }
//    that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
//    For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..2,147,483,647].

    public static void main(String[] args) {
        System.out.println(solution(561892));

    }

    public static int solution(int N) {
        String binaryNumber = Integer.toBinaryString(N);
        int maxSequence = 0;
        int currentSequence = 0;
        boolean hasPreviousOne = false;

        for (char c : binaryNumber.toCharArray()) {
            if (c == '1') {
                if (hasPreviousOne) {
                    maxSequence = Math.max(currentSequence, maxSequence);
                    currentSequence = 0;
                } else {
                    hasPreviousOne = true;
                }
            } else {
                currentSequence++;
            }
        }
        return maxSequence;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o maior "binary gap" (maior sequência de zeros entre
 * dois uns) na representação binária de um número N.
 *
 * 1. Converte N para sua representação em string binária.
 * 2. Percorre cada caractere dessa string.
 * 3. Ao encontrar um '1': se já tinha visto um '1' antes, compara o
 *    tamanho da sequência de zeros acumulada com o maior gap encontrado
 *    até agora e reseta o contador; se for o primeiro '1' visto, apenas
 *    marca que já encontrou o início de um possível gap.
 * 4. Ao encontrar um '0', incrementa o contador da sequência atual de
 *    zeros.
 * 5. Retorna o maior gap de zeros encontrado entre dois uns (zeros depois
 *    do último '1' não contam, pois não há um '1' fechando a sequência).
 *
 * Complexidade: O(log N), proporcional ao número de dígitos binários.
 */
