package 体系班.class03.practice2;



public class practice4 {
	public static void main(String[] args) {
//		MyStack<Integer> myStack = new MyStack<>();
//		myStack.addHead(1);
//		myStack.addHead(2);
//		System.out.println(myStack.popHead());
//		System.out.println(myStack.isEmpty());
//		System.out.println(myStack.popHead());
//		System.out.println(myStack.isEmpty());
		
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.push(1);
		myQueue.push(2);
		System.out.println(myQueue.poll()); // 1
		System.out.println(myQueue.isEmpty());// false
		System.out.println(myQueue.poll()); // 2
		System.out.println(myQueue.isEmpty()); // true
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
			return queue.pollFromTrail();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
	}
	
	public static class MyStack<T>{
		private DoubleQueue<T> queue;
		public MyStack(){
			queue = new DoubleQueue<>();
		}
		
		// 先进后出
		public void addHead(T value) {
			queue.addFromHead(value);
		}
		
		public T popHead() {
			return queue.pollFromHead();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
	}
	
	public static class DoubleQueue<T> {
		private DoubleNode<T> head = null;
		private DoubleNode<T> trail = null;
		
		public void addFromHead(T value) {
			DoubleNode<T> cur = new DoubleNode<T>(value);
			if (this.head == null) {
				this.head = cur;
				this.trail = cur;
			} else {
				this.head.last = cur;
				cur.next = this.head;
				this.head = cur;
			}
		}
		
		public void addFromTrail(T value) {
			DoubleNode<T> cur = new DoubleNode<T>(value);
			if (this.head == null) {
				this.head = cur;
				this.trail = cur;
			} else {
				this.trail.next = cur;
				cur.last = this.trail;
				this.head = cur;
			}
		}
		
		public T pollFromHead() {
			if (this.head == null) {
				return null;
			}
			
			DoubleNode<T> cur = this.head;
			if (this.head == this.trail) {
				this.head = null;
				this.trail = null;
			} else {
				this.head = this.head.next;
				this.head.last = null;
//				this.head = cur;
				cur.next = null;
			}
			return cur.value;
		}
		
		public T pollFromTrail() {
			if (this.head == null) {
				return null;
			}
			
			DoubleNode<T> cur = this.trail;
			if (this.trail == this.head) {
				this.head = null;
				this.trail = null;
			} else {
				this.trail = this.trail.last;
				this.trail.next = null;
				cur.last = null;
			}
			return cur.value;
		}
		
		
		public boolean isEmpty() {
			return this.head == null;
		}

	}
	
	public static class DoubleNode<T> {
		private T value;
		private DoubleNode<T> last;
		private DoubleNode<T> next;
		
		public DoubleNode(T value) {
			this.value = value;
		}
	}
}
