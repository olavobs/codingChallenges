package leetCode;

//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from
// the root node down to the farthest leaf node.

//Input: root = [3,9,20,null,null,15,7]
//Output: 3

//          3
//      9       20
//            15   7

//Input: root = [1,null,2]
//Output: 2

//      1
// null    2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class DFS_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        // [1,null,2]
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2));
        System.out.println(maxDepth(root2));

        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        System.out.println(maxDepth(root1));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Calcular a profundidade máxima de uma árvore binária, ou seja,
 * a quantidade de nós no caminho mais longo da raiz até uma folha.
 *
 * 1. Caso base: se o nó for null, não há nível nenhum → retorna 0.
 * 2. Calcula recursivamente a profundidade da subárvore da esquerda e a da
 *    subárvore da direita (busca em profundidade — DFS).
 * 3. A profundidade do nó atual é 1 (ele mesmo) + a maior entre as duas
 *    subárvores.
 * 4. O valor sobe pela recursão até a raiz, que retorna a profundidade
 *    máxima da árvore inteira.
 *
 * Complexidade: O(n) tempo, O(h) espaço (h = altura da árvore, pela pilha
 * de recursão).
 */
