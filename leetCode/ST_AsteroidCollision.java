package leetCode;

//We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array
// represent their relative position in space.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
// right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
// both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.

//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

//Input: asteroids = [3,5,-6,2,-1,4]
//Output: [-6,2,4]
//Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side,
// the asteroid 2 destroys -1. Since 2 and 4 are both moving right, they never collide.

import java.util.Arrays;
import java.util.Stack;

public class ST_AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> aux = new Stack<>();

        for (int curr : asteroids) {

            if (curr > 0) {
                aux.push(curr);
                continue;
            }

            boolean destroyed = false;

            while (!aux.isEmpty() && curr < 0 && aux.peek() > 0) {

                if (Math.abs(curr) > aux.peek()) {
                    aux.pop();
                } else if (Math.abs(curr) == aux.peek()) {
                    aux.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                aux.push(curr);
            }
        }

        int[] answer = new int[aux.size()];

        for (int i = aux.size() - 1; i >= 0; i--) {
            answer[i] = aux.pop();
        }

        return answer;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Simular colisões entre asteroides em fila; o menor explode, e
 * ambos explodem se forem do mesmo tamanho.
 *
 * 1. Usa uma pilha (Stack) para simular os asteroides "sobreviventes" até
 *    o momento, da esquerda para a direita.
 * 2. Se o asteroide atual for positivo (indo para a direita), apenas
 *    empilha — ele só vai colidir mais tarde, com algo vindo da esquerda
 *    (negativo).
 * 3. Se for negativo (indo para a esquerda), compara com o topo da pilha
 *    enquanto houver um asteroide positivo lá: se o atual for maior (em
 *    valor absoluto), o do topo explode (pop) e a comparação continua; se
 *    forem do mesmo tamanho, ambos explodem; se o do topo for maior, o
 *    atual explode e o laço para.
 * 4. Se o asteroide atual sobreviver a todas as colisões, ele é
 *    empilhado.
 * 5. Ao final, a pilha contém os asteroides que sobreviveram, na ordem
 *    correta — o array de resposta é montado desempilhando-os.
 *
 * Complexidade: O(n).
 */
