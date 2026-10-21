package Module_4.problem_4;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class BalancedPartition {
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for two chains
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        // Tails for each chain
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;

        // Traverse once
        for (ListNode node = head; node != null; ) {
            ListNode next = node.next;
            node.next = null;

            if (node.val < x) {
                smallTail.next = node;
                smallTail = node;
            } else {
                largeTail.next = node;
                largeTail = node;
            }

            node = next;
        }


        smallTail.next = largeDummy.next;


        return smallDummy.next;
    }
}

public class CSC {
    public static void main(String[] args) {
        // Build test list
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        BalancedPartition bp = new BalancedPartition();
        ListNode result = bp.partition(head, 3);


        System.out.print("Partitioned List: ");
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
