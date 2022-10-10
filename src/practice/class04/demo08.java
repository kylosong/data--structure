package practice.class04;

/**
 * 给定两个有序链表的头节点head1和head2，
 *
 * 返回合并之后的大链表，要求依然有序
 *
 * 例子 1 -> 3 -> 3 -> 5 -> 7 2 -> 2 -> 3 -> 3-> 7
 *
 * 返回 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
 */
public class demo08 {
    public static void main(String[] args) {

    }

   public static Node mergeNodeList(Node head1, Node head2) {
        Node newHead = null;
        Node curHead = null;
        if (head1.val >= head2.val) {
            newHead = head2;
            curHead = head2;
        } else {
            newHead = head1;
            curHead = head1;
        }

       /**
        * 得到curHead第一个节点是最小的那一组有序列表，当然它不一定是最长的
        */
       while(curHead != null){
           curHead = curHead.next;
       }


       return newHead;
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
