package practice.day06.practice01;

import java.util.Iterator;
import java.util.Stack;

import practice.day06.teacher.Code02_IsPalindromeList.Node;

public class Code02_IsPalindromeList {

	public static void main(String[] args) {
		Node head = new Node(0);
//		head.next = new Node(1);
//		head.next.next = new Node(0);
		System.out.println(isPalindrome3(head));
	}

	
	/**
	 * 给定一个单链表的头 节点head，请判断该链表是否为回文结构。

	   1）栈的方法特别简单（笔试用）
			
	   2） 改原链表的方法就需要注意边界了（面试用）
	 */
	// need n extra space
	private static boolean isPalindrome1(Node head) {
		if (head == null) {
			return false;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while (cur != null) {
			stack.add(cur);
			cur = cur.next;
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			if (stack.pop().value != head.value) {
				return false;
			}
			head = head.next;
			
		}
		
		return true;
	}
	
	
	/**
	 * 1、奇数长度找到中点，偶数长度找到下中点，找到中点以后开始放入栈中
	 * 2、将栈中元素和头节点进行比较，查看是否一致，不一致返回 false，一致不处理，默认返回 true
	 */
	// need n/2 extra space
	private static boolean isPalindrome2(Node head) {
		if (head == null) {
			return false;
		}
		
		if (head.next == null) {
			return true;
		}
		
		// 一个及以上节点，快慢指针找中点，快慢指针对链表求中点非常的好使，这个方法必须掌握
		Node right = head.next;
		Node cur = head;
//		奇数长度找到中点，偶数长度找到下中点，找到中点以后开始放入栈中，这里有一点点的小问题
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<>();
		if (right != null) {
			stack.add(right);
			right = right.next;
		}
		// 栈中元素取完，要保证都和链表head节点开始的相等
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		
		
		return true;
	}

	// need O(1) extra space
	private static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		Node n1 = head;
		Node n2 = head;
		
		while (n2.next != null && n2.next.next != null) { // find mid node
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		// n1 中点
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while (n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		
		n3 = n1;
		n2 = head;
		
		boolean res = true;
		while (n1 != null & n2 != null) {
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		// 这里使用不同的变量，然后根据逻辑实现了，如果测试通过，说明这逻辑你梳理正确了，而不是白抄老师的，现有思路，然后能用代码实现思路，然后会总结，这才是成长。白抄一百年，你也不会有任何进步的
		// 有自己的思考，哪怕花费非常非常多的时间，都是一个不小的进步，这样的学习才会有意义，不要忘记初心和本来目标
		// 有思考才会有价值
		n2 = n3.next;
		n3.next = null;
		
		while (n2 != null) {
			n1 = n2.next;
			n2.next = n3;
			n3 = n2;
			n2 = n1;
		}
	
		return res;
	}
	
	
	public static class Node {
		private int value;
		private Node next;
		public Node(int data) {		
			this.value = data;
		}
		
	}

}
