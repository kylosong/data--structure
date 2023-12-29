package practice.day07.practice01;

public class SuccessorNode {
	public static void main(String[] args) {
		// 二叉树结构定义如下：给你二叉树中的某个节点，返回该节点的后继节点。
		// （后继节点指的是一棵二叉树中，在中序遍历的序列中，一个节点的下一个节点），
		// 要求时间复杂度O(K)不是O(N)，空间复杂度O(N)，而不是O(2n平方 - 1)

		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
	}

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
}
