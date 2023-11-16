package 体系班.class03.practice;

import java.awt.HeadlessException;

public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		testListNode(head);
		printListNode(head);
		
		
		
//		Node newHeadNode = reverseListNode(head);
//		printListNode(newHeadNode); // 4 3 2 1

	}
	
	private static void testListNode(Node head) {
//		head.next = new Node(8); // 会影响上文中的 head ，因为这是一个引用地址
//		head = null; // 不会影响上文中的 head，正常输出 1，2，3，4
	}
	
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


