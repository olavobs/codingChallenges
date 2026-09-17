package leetCode;

// You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an
// empty record.
//
//You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and
// is one of the following:

//An integer x.
//Record a new score of x.

//'+'.
//Record a new score that is the sum of the previous two scores.

//'D'.
//Record a new score that is the double of the previous score.

//'C'.
//Invalidate the previous score, removing it from the record.

//Return the sum of all the scores on the record after applying all the operations.

//Example 1:
//
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.

// Example 2:
//Input: ops = ["5","-2","4","C","D","9","+","+"]
//Output: 27
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"-2" - Add -2 to the record, record is now [5, -2].
//"4" - Add 4 to the record, record is now [5, -2, 4].
//"C" - Invalidate and remove the previous score, record is now [5, -2].
//"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//"9" - Add 9 to the record, record is now [5, -2, -4, 9].
//"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

//Example 3:
//
//Input: ops = ["1","C"]
//Output: 0
//Explanation:
//"1" - Add 1 to the record, record is now [1].
//"C" - Invalidate and remove the previous score, record is now [].
//Since the record is empty, the total sum is 0.


import java.util.ArrayList;
import java.util.List;

public class ST_BaseballGame {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1", "C"}));
    }

    public static int calPoints(String[] operations) {
        List<Integer> computedValues = new ArrayList<>();

        for (String currentOperation : operations) {
            if (currentOperation.equals("C") && !computedValues.isEmpty()) {
                computedValues.removeLast();
            } else if (currentOperation.equals("D") && !computedValues.isEmpty()) {
                Integer previousValue = computedValues.getLast();
                computedValues.add(previousValue * 2);
            } else if (currentOperation.equals("+") && computedValues.size() > 1) {
                int size = computedValues.size();
                computedValues.add(computedValues.get(size - 1) + computedValues.get(size - 2));
            } else {
                computedValues.add(Integer.parseInt(currentOperation));
            }
        }

        return computedValues.stream().reduce(0, Integer::sum);
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Simular um jogo de beisebol com regras especiais de pontuação
 * (números, soma dos dois últimos, dobro do último, invalidar o último) e
 * retornar a soma final.
 *
 * 1. Usa uma lista (computedValues) para guardar o histórico de
 *    pontuações válidas.
 * 2. Para cada operação da entrada: se for "C", remove a última pontuação
 *    registrada; se for "D", adiciona o dobro da última pontuação; se for
 *    "+", adiciona a soma das duas últimas pontuações.
 * 3. Se a operação for um número, simplesmente converte para inteiro e
 *    adiciona à lista.
 * 4. Repete para todas as operações da entrada.
 * 5. Soma todos os valores da lista final e retorna o total.
 *
 * Complexidade: O(n).
 */
