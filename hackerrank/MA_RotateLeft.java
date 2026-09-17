package hackerrank;

import java.util.ArrayList;
import java.util.List;

/*
A left rotation operation on an array of size shifts each of the array's elements 1 unit to the left.
rotate the array that many steps left and return the result.

        Example


        After  rotations, .

        Function Description

        Complete the rotateLeft function in the editor below.

        rotateLeft has the following parameters:

        int d: the amount to rotate by
        int arr[n]: the array to rotate
        Returns

        int[n]: the rotated array
        Input Format

        The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
        The second line contains  space-separated integers that describe .

        Sample Input

        5 4
        1 2 3 4 5
        Sample Output

        5 1 2 3 4
*/

public class MA_RotateLeft {

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);

        System.out.println(rotateLeft(4, list));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        var output = new ArrayList<Integer>();

        for (int i = 0; i < arr.size(); i++) {
            output.add(arr.get(d));

            if (d == arr.size() - 1) {
                d = 0;
            } else {
                d++;
            }
        }

        return output;

    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Rotacionar um array d posições para a esquerda.
 *
 * 1. Cria uma lista de saída vazia.
 * 2. Para cada posição do array original, adiciona à lista de saída o
 *    elemento que está atualmente no índice d (o deslocamento atual).
 * 3. Incrementa d a cada iteração; quando d chega ao último índice do
 *    array, ele volta para 0 (dando a volta, como um ponteiro circular).
 * 4. Repete até preencher toda a lista de saída, que fica com os
 *    elementos já rotacionados para a esquerda.
 * 5. Retorna a lista rotacionada.
 *
 * Complexidade: O(n).
 */
