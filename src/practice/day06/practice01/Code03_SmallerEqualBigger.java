package practice.day06.practice01;

public class Code03_SmallerEqualBigger {

	public static void main(String[] args) {
		// 5 9 8 6 10
		Node head = new Node(5);
		head.next = new Node(9);
		head.next.next = new Node(8);
		head.next.next.next = new Node(6);
		head.next.next.next.next = new Node(10);
		
		partion(head, 8);

	}
	
	public static void partion(Node head, int someValue) {
		if(head == null || head.next == null) {
			return;
		}
		// 大于等于一个节点
		
	}
	
	private static Node listPartition1() {
		
		return null;
	}

 	public static class Node {
		private int val;
		private Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
		
	}


}
