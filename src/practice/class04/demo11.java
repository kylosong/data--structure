package practice.class04;

public class demo11 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(7);

        ListNode newHead = mergeTwoLists(head1, head2);
        printListNode(newHead); // 1 2 2 3 3 3 3 5 7 7

    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }
}
