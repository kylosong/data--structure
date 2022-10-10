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
 *
 * 总结：虽然最后实现了，但是时间严重超时，其次代码上不够简洁，很明显的能感受到有问题
 */
public class demo07 {
    public static void main(String[] args) {

        Node head1 = new Node(4);
        head1.next = new Node(3);
        head1.next.next = new Node(6);

        Node head2 = new Node(2);
        head2.next = new Node(5);
        head2.next.next = new Node(3);

        Node newHead = handleNode(head1, head2);
        printNodeList(newHead);
    }

    public static void printNodeList(Node head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static Node handleNode(Node head1, Node head2) {
        Node newHead = null;
        Node curHead = null;
        int sum = nodeToNum(head1) + nodeToNum(head2);
        int count = 10;
        int co = 1;
        while (sum != 0) {
            if (newHead == null) {
                newHead = new Node(sum % count);
                curHead = newHead;
            } else {
                curHead.next = new Node(sum % count / co);
                curHead = curHead.next;
            }
            sum = sum - sum % count;
            count = count * 10;
            co = co * 10;
        }
        return newHead;
    }

    public static int nodeToNum(Node head) {
        int count = 1;
        int sum =  0;
        while (head != null) {
            sum = head.val * count + sum;
            count = 10 * count;
            head = head.next;
        }
        return sum;
    }

    public static class Node {
        private int val;
        private Node next;
        public Node(int data){
            this.val = data;
            this.next = null;
        }
    }
}
