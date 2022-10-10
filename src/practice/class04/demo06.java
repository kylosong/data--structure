package practice.class04;

public class demo06 {
    public static void main(String[] args) {
//        System.out.println("hi");
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        ListNode head =  reverseKGroup(listNode, 3);
        printList(head); // 3 2 1 6 5 4 7
//        reverseKGroup(listNode, 2);
//        ListNode start = getKGroupEnd(listNode, 4);
//        System.out.println(start.next);
//        System.out.println(start.val);
    }

    public static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    /**
     * K个节点的组内逆序调整问题
     * 给定一个单链表的头节点head，和一个正数k 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
     * 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
     * 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
     *
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end; // 此时head是第一组的尾部，返回head即可
        reverse(start, end); // 第一组节点逆序
        ListNode lastEnd = start; // lastEnd指向下一组节点的头节点
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end; // lastEnd原本指向下一组节点的头节点，现在修改成指向下一组节点的尾节点
            lastEnd = start; // 灵活使用值传递和引用传递，上一行和这一行简直就是神来之笔，可以细品
        }
        return head;
    }

    /**
     * 数k个节点，返回最后一个，如果不足k个那返回的节点的next肯定是null
     * @param start
     * @param k
     * @return
     */
    public static ListNode getKGroupEnd(ListNode start, int k){
        while (--k != 0 && start.next != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(ListNode start, ListNode end){
        end = end.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static ListNode reverseGroup(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
