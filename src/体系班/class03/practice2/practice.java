package 体系班.class03.practice2;

public class practice {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
//		printNodeList(head);
		Node newHead = reverseNodeList(head);
		printNodeList(newHead);
	}
	
	public static Node reverseNodeList(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void printNodeList(Node head) {
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
