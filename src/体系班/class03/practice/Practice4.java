package 体系班.class03.practice;

import 体系班.class03.Code03_DoubleEndsQueueToStackAndQueue.DoubleEndsQueue;
import 体系班.class03.Code03_DoubleEndsQueueToStackAndQueue.Node;

public class Practice4 {

	public static void main(String[] args) {
	
	}
	
	public static class MyQueue<T> {
		private DoubleQueue<T> queue;
		
		public MyQueue() {
			queue = new DoubleQueue<T>();
		}
		
		public void push(T value) {
			queue.addFromHead(value);
		}
		
		public T poll() {
			return queue.popFromBottom();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
	}
	
	public static class MyStack<T> {
		private DoubleQueue<T> queue;
		
		public MyStack() {
			queue = new DoubleQueue<T>();
		}
		
		public void push(T value) {
			queue.addFromHead(value);
		}

		public T pop() {
			return queue.popFromHead();
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
	}
	
	/**
	 * 栈：
	 * 从头添加元素，从头取出元素
	 * 
	 * 队列：
	 * 从头添加元素，从头取出元素
	 * 从尾添加元素，从尾取出元素
	 * 
	 */
	public static class DoubleQueue<T> {
		private Node<T> head;
		private Node<T> trail;
		
		public void addFromHead(T value) {
			Node<T> cur = new Node<T>(value);
			if (this.head == null) {
				this.head = cur;
				this.trail = cur;
			} else {
				cur.next = this.head;
				this.head.last = cur;
				this.head = cur;
			}
		}

		public void addFromBottom(T value) {
			Node<T> cur = new Node<T>(value);
			if (this.trail == null) {
				this.head = cur;
				this.trail = cur;
			} else {
				cur.last = this.trail;
				this.trail.next = cur;
				this.trail = cur;
			}
		}

		public T popFromHead() {
			if (this.head == null) {
				return null;
			}
			Node<T> cur = this.head;
			if (this.head == this.trail) {
				this.head = null;
				this.trail = null;
			} else {
				this.head = this.head.next;
				cur.next = null;
				this.head.last = null;
			}
			return cur.value;
		}

		public T popFromBottom() {
			if (this.head == null) {
				return null;
			}
			Node<T> cur = this.trail;
			if (this.head == this.trail) {
				this.head = null;
				this.trail = null;
			} else {
				this.trail = this.trail.last;
				cur.last = null;
				this.trail.next = null;
			}
			return cur.value;
		}

		public boolean isEmpty() {
			return head == null;
		}

	}
	
	public static class Node<T> {
		private T value;
		private Node<T> last;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
}


