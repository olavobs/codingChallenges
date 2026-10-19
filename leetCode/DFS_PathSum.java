package leetCode;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
// that adding up all the values along the path equals targetSum.
//
//A leaf is a node with no children.

//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.

//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There are two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.

//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.

public class DFS_PathSum {

    public static void main(String[] args) {
        DFS_PathSum solution = new DFS_PathSum();

        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        System.out.println(solution.hasPathSum(root1, 22)); //true

        // [1,2,3]
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println(solution.hasPathSum(root2, 5)); //false

        // []
        System.out.println(solution.hasPathSum(null, 0)); //false
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null & root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se existe algum caminho da raiz até uma folha cuja
 * soma dos valores seja igual a targetSum.
 *
 * 1. Caso base: se o nó for null, não existe caminho → retorna false.
 * 2. Se o nó for uma folha (sem filho esquerdo e sem filho direito),
 *    verifica se o valor que ainda falta (targetSum) é exatamente o valor
 *    da folha.
 * 3. Caso contrário, desconta o valor do nó atual de targetSum e continua
 *    a busca recursivamente na subárvore da esquerda e na da direita
 *    (busca em profundidade — DFS).
 * 4. Usa || para retornar true assim que qualquer um dos lados encontrar
 *    um caminho válido.
 *
 * Complexidade: O(n) tempo, O(h) espaço (h = altura da árvore, pela pilha
 * de recursão).
 */
