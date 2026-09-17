package leetCode;

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
//the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.
//
//Given an array heights where each element represents the height of a vertical line, pick two lines to form a
// container. Return the maximum area (amount of water) the container can hold.
//What is area? Width × height, where width is the distance between walls, and height is the shorter wall (water
// overflows at the shorter wall).
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
// water (blue section) the container can contain is 49.
//
//Example 2:
//Input: height = [1,1]
//Output: 1

public class TP_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int currWidth = right - left;
            int currArea = currWidth * currHeight;

            answer = Math.max(currArea, answer);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Escolher duas linhas verticais que, junto com o eixo x, formam
 * o recipiente com a maior área possível de água.
 *
 * 1. Define dois ponteiros nas extremidades do array: left no início,
 *    right no fim.
 * 2. Para cada posição dos ponteiros, calcula a área possível: a largura
 *    é a distância entre os ponteiros, e a altura é o menor valor entre
 *    height[left] e height[right] (a água transborda pelo lado mais
 *    baixo).
 * 3. Compara essa área com a maior encontrada até agora e atualiza se
 *    for maior.
 * 4. Move o ponteiro que aponta para a parede mais baixa para dentro
 *    (left++ se height[left] for menor, senão right--), já que mover o
 *    ponteiro da parede mais alta nunca aumentaria a área.
 * 5. Repete até os ponteiros se encontrarem e retorna a maior área
 *    encontrada.
 *
 * Complexidade: O(n).
 */
