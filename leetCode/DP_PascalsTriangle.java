package leetCode;

import java.util.ArrayList;
import java.util.List;

//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
//
public class DP_PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int line = 0; line < numRows; line++) {
            List<Integer> currentLine = new ArrayList<>();

            currentLine.add(1);

            if (line > 0) {
                for (int column = 1; column < line; column++) {
                    List<Integer> previousLine = triangle.get(line - 1);
                    currentLine.add((previousLine.get(column - 1) + previousLine.get(column)));
                }
                currentLine.add(1);
            }
            triangle.add(currentLine);
        }
        return triangle;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Gerar as primeiras numRows linhas do Triângulo de Pascal, onde
 * cada número é a soma dos dois números logo acima dele.
 *
 * 1. Cria a lista triangle, que vai guardar todas as linhas.
 * 2. Para cada linha (line de 0 até numRows - 1), cria uma nova lista
 *    currentLine e adiciona 1 no começo (toda linha começa com 1).
 * 3. Se não for a primeira linha (line > 0):
 *    - pega a linha anterior (triangle.get(line - 1));
 *    - para cada coluna do meio (column de 1 até line - 1), adiciona a
 *      soma previousLine[column - 1] + previousLine[column];
 *    - adiciona 1 no final (toda linha termina com 1).
 * 4. Adiciona currentLine ao triangle.
 * 5. Cada linha é construída a partir da anterior já calculada
 *    (programação dinâmica bottom-up / tabulação).
 *
 * Complexidade: O(numRows²) tempo e espaço.
 */
