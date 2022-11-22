package practice.class06;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class demo02 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(7);
		
		ListNode l3 = new ListNode(5);
		l3.next = new ListNode(5);
		l3.next.next =  new ListNode(9);
		
		ListNode[] arr = {l1, l2, l3}; 
		
		// 按照自己的思路，自己可能先找到最长的那个链表，然后开始不断比较各个链表，
		// 比较找到这个数组中最小的链表，然后放到新的链表中
		

	}
	
	public class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return o1.val - o2.val;
		}}


	// 合并多个有序链表
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		for (ListNode listNode : lists) {
			if (listNode != null) {
				heap.add(listNode);
			}
			
		}
		if (heap.isEmpty()) {
			return null;
		}
		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			pre.next = cur;
			pre = cur;
			if (cur.next != null) {
				heap.add(cur.next);
			}
			
		}
		return head;
	}
	
	public int getListNodeLength(ListNode head) {
		int result = 0;
		while (head != null) {
			result++;
			head = head.next;
			
		}
		return result;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
