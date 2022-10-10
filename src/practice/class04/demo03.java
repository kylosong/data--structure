package practice.class04;

/*单链表实现栈*/
public class demo03 {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.offer("a");
        myStack.offer("b");
        myStack.offer("c");
        myStack.offer("d");
        System.out.println(myStack.isEmpty()); // false
        System.out.println(myStack.size()); // 4
        System.out.println(myStack.peek()); // d
        System.out.println(myStack.pop()); // d
        System.out.println(myStack.size()); // 3
        System.out.println(myStack.peek()); // c
    }





    public static class MyStack<T> {
        private int size = 0;
        private Node<T> head;


        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }

        public void offer(T data){
            Node<T> cur = new Node<>(data);
            if (this.head == null) {
                this.head = cur;
            } else {
                cur.next = this.head;
                this.head = cur;
            }
            this.size ++;
        }

        public T pop() {
            T ans = null;
            if (this.head != null) {
                ans = this.head.value;
                this.head = this.head.next;
                this.size --;
            }
            return ans;
        }

        public T peek(){
            T ans = null;
            if (this.head != null) {
                ans = this.head.value;
            }
            return ans;
        }
    }




    public static class Node<T>{
        private T value;
        private Node<T> next;
        public Node(T data){
            this.value = data;
        }
    }
}
