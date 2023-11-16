package 体系班.class03.practice2;

public class practice2 {
	public static void main(String[] args) {
		// 1 2 3 4 的双链表
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);	
		head.last = null;
		head.next.last = head;
		head.next.next.last = head.next;
		head.next.next.next.last = head.next.next;
		
//		printNodeList(head); // 1 2 3 4
//		System.out.println();
//		printPreListNode(head.next.next.next); //  4 3 2 1
		
		Node newHeadNode = reverseDoubleListNode(head);
		printNodeList(newHeadNode); // 4 3 2 1
		System.out.println();
		printPreListNode(newHeadNode.next.next.next); // 1 2 3 4

	}
	
	// 双链表反转
	private static Node reverseDoubleListNode(Node head) {
		Node pre = null;
		Node next = null;
		while(head!=null) {
			next = head.next;
			// 这一句一定要在上面，要不然 head.next 会变成 null, 导致 head.last 执行错误的， head.last 反转之后一定是指向下一个元素，必不是 null
			head.last = head.next;
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
	
	public static void printPreListNode(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.last;
		}
	}
	
	public static class Node {
		private int value;
		private Node next;
		private Node last;
		public Node(int value) {
			this.value = value;
		}
	}
}
