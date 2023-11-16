package 体系班.class03.practice;



public class Practice02 {

	public static void main(String[] args) {
		
		// 1 2 3 4 的双链表
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);	
		head.pre = null;
		head.next.pre = head;
		head.next.next.pre = head.next;
		head.next.next.next.pre = head.next.next;
		
//		printListNode(head); // 1 2 3 4
//		System.out.println();
//		printPreListNode(head.next.next.next); //  4 3 2 1
		
		Node newHeadNode = reverseDoubleListNode(head);
		printListNode(newHeadNode); // 4 3 2 1
		System.out.println();
		printPreListNode(newHeadNode.next.next.next); // 1 2 3 4

	}
	

	// 单链表反转
	private static Node reverseListNode(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	// 双链表反转
	private static Node reverseDoubleListNode(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;	
		}
		return pre;
	}
	
	public static void printListNode(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	public static void printPreListNode(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.pre;
		}
	}
	
	public static class Node {
		private int value;
		private Node next;
		private Node pre;
		
		public Node(int value) {
			this.value = value;
		}
		
	}

}


