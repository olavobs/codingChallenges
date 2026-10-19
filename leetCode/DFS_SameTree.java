package leetCode;

//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value

//Input: p = [1,2,3], q = [1,2,3]
//Output: true

//Input: p = [1,2], q = [1,null,2]
//Output: false

public class DFS_SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Verificar se duas árvores binárias são iguais — mesma
 * estrutura e mesmos valores em cada nó.
 *
 * 1. Se os dois nós forem null, as duas (sub)árvores terminaram juntas →
 *    são iguais, retorna true.
 * 2. Se só um deles for null, ou se os valores forem diferentes, as
 *    árvores já não são iguais → retorna false.
 * 3. Caso contrário, compara recursivamente as subárvores da esquerda
 *    entre si e as da direita entre si (busca em profundidade — DFS).
 * 4. Usa && para que as árvores só sejam iguais se os dois lados forem
 *    iguais.
 *
 * Complexidade: O(n) tempo, O(h) espaço (h = altura da árvore, pela pilha
 * de recursão).
 */
