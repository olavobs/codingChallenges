package leetCode;

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
// connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Detectar se uma lista encadeada contém um ciclo.
 *
 * 1. Se a lista estiver vazia (head null), não há ciclo — retorna false.
 * 2. Usa dois ponteiros: slow, que avança 1 nó por vez, e fast, que avança
 *    2 nós por vez (técnica do "coelho e da tartaruga" / Floyd's Cycle
 *    Detection).
 * 3. Em cada passo, verifica se fast ou fast.next chegaram a null — se
 *    sim, a lista tem um fim (não é circular), retorna false.
 * 4. Move slow um nó e fast dois nós adiante.
 * 5. Se em algum momento slow e fast apontarem para o mesmo nó, é porque o
 *    ponteiro mais rápido "deu a volta" e encontrou o mais lento dentro
 *    de um ciclo — retorna true.
 *
 * Complexidade: O(n) tempo, O(1) espaço.
 */
