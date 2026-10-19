package leetCode;

//Given the root of a binary tree, invert the tree, and return its root.
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]

//Input: root = [2,1,3]
//Output: [2,3,1]
//Example 3:
//
//Input: root = []
//Output: []

import java.util.LinkedList;
import java.util.Queue;

public class DFS_InvertBinaryTree {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [4,2,7,1,3,6,9]
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        teste("Teste 1", sol, root1, "[4, 7, 2, 9, 6, 3, 1]");

        // [2,1,3]
        TreeNode root2 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        teste("Teste 2", sol, root2, "[2, 3, 1]");

        // árvore vazia
        teste("Teste 3", sol, null, "[]");
    }

    static void teste(String nome, Solution sol, TreeNode root, String esperado) {
        String antes = paraTexto(root);
        TreeNode resultado = sol.invertTree(root);
        String depois = paraTexto(resultado);

        System.out.println(nome);
        System.out.println("  antes:    " + antes);
        System.out.println("  depois:   " + depois);
        System.out.println("  esperado: " + esperado);
        System.out.println("  " + (depois.equals(esperado) ? "OK" : "ERRADO"));
    }

    static String paraTexto(TreeNode root) {
        if (root == null) return "[]";

        java.util.List<String> valores = new java.util.ArrayList<>();
        Queue<TreeNode> fila = new LinkedList<>();
        fila.add(root);

        while (!fila.isEmpty()) {
            TreeNode atual = fila.poll();
            if (atual == null) {
                valores.add("null");
            } else {
                valores.add(String.valueOf(atual.val));
                fila.add(atual.left);
                fila.add(atual.right);
            }
        }

        while (!valores.isEmpty() && valores.getLast().equals("null")) {
            valores.removeLast();
        }
        return valores.toString();
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            var aux = root.left;
            root.left = root.right;
            root.right = aux;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Inverter uma árvore binária (espelhar), trocando o filho da
 * esquerda com o da direita em todos os nós.
 *
 * 1. Caso base: se o nó for null (árvore vazia ou passou de uma folha),
 *    retorna null.
 * 2. Troca os filhos do nó atual usando uma variável auxiliar (aux):
 *    left vira right e right vira left.
 * 3. Chama a mesma função recursivamente para o novo filho da esquerda e
 *    para o novo filho da direita (busca em profundidade — DFS), invertendo
 *    as subárvores também.
 * 4. Retorna o próprio nó (root), agora com toda a árvore abaixo dele
 *    invertida.
 *
 * Obs: os métodos teste e paraTexto são só auxiliares para imprimir a
 * árvore por níveis (BFS com fila) e conferir o resultado.
 *
 * Complexidade: O(n) tempo, O(h) espaço (h = altura da árvore, pela pilha
 * de recursão).
 */
