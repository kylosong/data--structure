package practice.day06;

import java.util.Iterator;
import java.util.Stack;
import java.util.zip.CRC32;

import practice.day06.teacher.Code02_IsPalindromeList.Node;

public class Code02_IsPalindromeList {

	public static void main(String[] args) {
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(0);
		System.out.println(isPalindrome2(head));
	}

	
	/**
	 * 给定一个单链表的头 节点head，请判断该链表是否为回文结构。

	   1）栈的方法特别简单（笔试用）
			
	   2） 改原链表的方法就需要注意边界了（面试用）
	 */
	// need n extra space
	public static boolean isPalindrome1(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
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
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 两个节点及以上，寻找中节点，这里对中节点的检索自己还是不太能明白，为啥此步可以达到效果
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	

	// need O(1) extra space
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		// 怎样进行链表头节点反转？
		// right 指向 null
		return true;
	}
	
	public static class Node {
		private int value;
		private Node next;
		public Node(int data) {		
			this.value = data;
		}
		
	}

}
