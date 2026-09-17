package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
// k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

// Example 1
//
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

//Example 2:
//
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.

public class PQ_KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(kClosest(points, 2)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> closest = new PriorityQueue<>(
                (a, b) -> Integer.compare(getDistance(b), getDistance(a)));

        for (int[] point : points) {
            closest.add(point);
            if (closest.size() > k) {
                closest.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = closest.poll();
        }

        return result;
    }

    private static int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Encontrar os k pontos mais próximos da origem (0, 0) em um
 * plano X-Y.
 *
 * 1. Cria uma PriorityQueue (max-heap) que ordena os pontos pela distância
 *    ao quadrado até a origem, do maior para o menor (evita usar raiz
 *    quadrada, já que comparar distância² dá o mesmo resultado).
 * 2. Percorre todos os pontos, adicionando cada um à heap.
 * 3. Sempre que a heap ultrapassar o tamanho k, remove o elemento do topo
 *    (o de maior distância) — assim a heap nunca guarda mais que os k
 *    pontos mais próximos vistos até agora.
 * 4. Ao final, a heap contém exatamente os k pontos mais próximos da
 *    origem.
 * 5. Extrai todos os elementos da heap para o array de resultado e
 *    retorna.
 *
 * Complexidade: O(n log k).
 */
