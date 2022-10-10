package practice.class04;

// 队列：先进先出

// 用单链表实现队列
public class demo02 {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.offer("a");
        myQueue.offer("b");
        myQueue.offer("c");
        myQueue.offer("d");
        System.out.println(myQueue.isEmpty()); // false
        System.out.println(myQueue.size()); // 4
        System.out.println(myQueue.peek()); // a
        System.out.println(myQueue.pop()); // a
        System.out.println(myQueue.size); // 3
        System.out.println(myQueue.peek()); // b
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        public Node(T data) {
            this.value = data;
        }
    }

    public static class MyQueue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }

        // 从尾部插入数据
        public void offer(T data){
            Node<T> cur = new Node<T>(data);
            if (this.tail == null) {
                this.head = cur;
                this.tail = cur;
            } else {
                this.tail.next = cur;
                this.tail = cur;
            }
            this.size ++;
        }


        // 从头部取出数据
        public T pop() {
            T ans = null;
            if (this.head != null) {
                ans = this.head.value;
                this.head = this.head.next;
                this.size --;
            }
            if (this.head == null) {
                this.tail = null;
            }
            return ans;
        }

        // 返回头部元素，但是不取出
        public T peek() {
            T  ans = null;
            if (this.head != null) {
                ans = this.head.value;
            }
            return ans;
        }

    }
}
