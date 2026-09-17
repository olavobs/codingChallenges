package codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class HS_PermMissingElem {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] A) {

        //é mais rápido fazer a verificação usando contains com um set do que com uma lista,
        //o set usa uma estrutura de map por debaixo dos panos então a verificação é O(1)
        //enquanto a lista utiliza o indexOf fazendo com que sempre seja necessário percorrer toda a lista ou seja O(n)
        Set<Integer> aux = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 1; i < aux.size() + 1; i++) {
            if (!aux.contains(i)) {
                return i;
            }
        }

        return aux.size() + 1;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar o número faltante em uma sequência que deveria conter
 * cada valor de 1 a N+1 exatamente uma vez, mas está faltando um.
 *
 * 1. Converte o array em um Set (usando streams), o que elimina
 *    duplicados e permite consultas O(1) com contains.
 * 2. Percorre os valores de 1 até o tamanho do set.
 * 3. Retorna o primeiro valor que não estiver presente no set — esse é o
 *    elemento faltante.
 * 4. Se todos os valores de 1 até size estiverem presentes, o elemento
 *    faltante é size + 1 (o próximo valor esperado da sequência).
 *
 * Complexidade: O(n).
 */
