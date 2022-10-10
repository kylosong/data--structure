package practice.class04;

public class demo01 {
    public static void main(String[] args) {
        DoubleNode a = new DoubleNode("a");
        DoubleNode b = new DoubleNode("b");
        DoubleNode c = new DoubleNode("c");
        DoubleNode d = new DoubleNode("d");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        d.last = c;
        c.last = b;
        b.last = a;
        a.last = null;

        DoubleNode newHead = reverseDoubleList(a);
        printNextNode(newHead); // d c b a
        printLastNode(newHead.next.next.next); // a b c d

    }

    /**
     * 如果不熟悉建议写画图，然后在写，链表需要特别注意边界条件
     * @param head
     */
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printNextNode(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void printLastNode(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.last;
        }
    }

    // 双链表
    public static class DoubleNode {
        private String value;
        private DoubleNode next;
        private DoubleNode last;
        public DoubleNode(String data) {
            this.value = data;
        }
    }
}
