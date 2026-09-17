package leetCode;

//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the
//linked list sorted as well.

//Input: head = [1,1,2]
//Output: [1,2]

//Input: head = [1,1,2,3,3]
//Output: [1,2,3]

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        ListNode list1 = solution.buildList(new int[]{1, 1, 2});
        System.out.println(solution.toArrayString(solution.deleteDuplicates(list1)));

        ListNode list2 = solution.buildList(new int[]{1, 1, 2, 3, 3});
        System.out.println(solution.toArrayString(solution.deleteDuplicates(list2)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                if (current.next.next == null) {
                    current.next = null;
                } else {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode buildList(int[] values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private String toArrayString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Remover elementos duplicados de uma lista encadeada já
 * ordenada, deixando cada valor aparecer apenas uma vez.
 *
 * 1. Se a lista estiver vazia ou tiver só um nó, já está sem duplicatas —
 *    retorna direto.
 * 2. Usa um ponteiro current começando na cabeça da lista.
 * 3. Compara o valor do nó atual com o valor do próximo nó.
 * 4. Se forem iguais, "pula" o próximo nó, conectando current diretamente
 *    ao nó seguinte a ele (removendo a duplicata da lista); se
 *    current.next.next for null, apenas encerra a lista ali.
 * 5. Se forem diferentes, avança current normalmente para o próximo nó.
 * 6. Repete até o fim da lista e retorna a cabeça (head), agora sem
 *    duplicatas consecutivas.
 *
 * Complexidade: O(n).
 */
