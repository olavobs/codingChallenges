package leetCode;

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
//is the number of days you have to wait after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]

//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]

//Input: temperatures = [30,60,90]
//Output: [1,1,0]

import java.util.Arrays;
import java.util.Stack;

public class ST_DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 50, 70, 65})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);

        Stack<Integer> indexDays = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!indexDays.isEmpty() && temperatures[i] > temperatures[indexDays.peek()]) {
                int index = indexDays.pop();
                answer[index] = i - index;
            }

            indexDays.push(i);
        }
        return answer;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Para cada dia, descobrir quantos dias faltam até um dia com
 * temperatura mais quente (0 se não houver nenhum dia mais quente à
 * frente).
 *
 * 1. Cria um array de resposta do mesmo tamanho da entrada, preenchido
 *    com zeros.
 * 2. Usa uma pilha (Stack) para guardar índices de dias cuja temperatura
 *    "mais quente" ainda não foi encontrada.
 * 3. Para cada dia i, enquanto a pilha não estiver vazia e a temperatura
 *    atual for maior que a temperatura do dia no topo da pilha, isso
 *    significa que encontramos o próximo dia mais quente para aquele dia
 *    guardado: desempilha o índice e calcula a diferença de dias
 *    (i - index) no array de resposta.
 * 4. Empilha o índice do dia atual (ele ainda pode ser "batido" por um
 *    dia futuro).
 * 5. Ao final, os índices que nunca tiveram um dia mais quente à frente
 *    permanecem com 0 no array de resposta.
 *
 * Complexidade: O(n) — cada índice entra e sai da pilha no máximo uma
 * vez.
 */
