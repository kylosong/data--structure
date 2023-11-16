package 体系班.class03.practice2;

public class practice3 {
	public static void main(String[] args) {
		// 1 2 3 4 的单链表
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);	
	
		printListNode(head); // 1 2 3 4
		Node newHead = deleteListValue(head, 3);
		System.out.println("--------");
		printListNode(newHead); // 1 2 4

	}
	
	private static Node deleteListValue(Node head, int num) {
		while(head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public static void printListNode(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	
	public static class Node {
		private int value;
		private Node next;
		public Node(int value) {
			this.value = value;
		}
	}
}
