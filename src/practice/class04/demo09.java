package practice.class04;

/***
 * 给定两个链表的头节点head1和head2，
 *
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 *
 * 例子 4 -> 3 -> 6        2 -> 5 -> 3
 * 解释 634 + 352 = 986
 * 返回 6 -> 8 -> 9
 *
 * leetcode: https://leetcode.cn/problems/add-two-numbers/submissions/
 */

public class demo09 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(3);
        head1.next.next =new ListNode(6);

        ListNode head2 = new  ListNode(2);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);

        ListNode newHead = addTwoNumbers(head1, head2);
        printNodeList(newHead);
    }
    public static void printNodeList(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    // 求链表长度
    public static int listLength(ListNode head){
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
