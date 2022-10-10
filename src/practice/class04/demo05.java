package practice.class04;

import java.util.Deque;
import java.util.LinkedList;

// 双链表实现双端队列
public class demo05 {
    public static void main(String[] args) {
        testDeque();
    }

    public static void testDeque() {
        DoubleQueue<Integer> myDeque = new DoubleQueue<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops! isEmpty");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops! size");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.offerHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.offerTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.popHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.popTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops! popHead 1");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops! peekHead 1");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops! size 2");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.popHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops! isEmpty popHead 2");
            }
        }
        System.out.println("测试结束！");

    }

    public static class DoubleQueue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public DoubleQueue(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size(){
            return this.size;
        }

        public void offerHead(T data) {
            Node<T> cur = new Node<>(data);
            if (this.head == null) {
                this.head = cur;
                this.tail = cur;
            } else {
                this.head.last = cur;
                cur.next = this.head;
                this.head = cur;
            }
            this.size++;
        }

        public void offerTail(T data) {
            Node<T> cur = new Node<>(data);
            if (this.tail == null) {
                this.head = cur;
                this.tail = cur;
            } else {
                this.tail.next = cur;
                cur.last = this.tail;
                this.tail = cur;
            }
            this.size++;
        }


        public T popHead(){
            T ans = null;
            if (this.head == null) {
                return null;
            }
            this.size--;
            ans = this.head.value;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.last = null;
            }
            return ans;
        }


        public T popTail(){
            T ans = null;
            if (this.tail == null) {
                return ans;
            }
            this.size--;
            ans = this.tail.value;
            if (this.tail == this.head) {
                this.tail = null;
                this.head = null;
            } else {
                this.tail = this.tail.last;
                this.tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            T ans = null;
            if (this.head != null) {
                ans = this.head.value;
            }
            return ans;
        }


        public T peekTail() {
            T ans = null;
            if (this.tail != null) {
                ans = this.tail.value;
            }
            return ans;
        }




    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> last;

        public Node(T data) {
            this.value = data;
            this.next = null;
            this.last = null;
        }
    }

    public static void printHead(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void printTail(Node tail) {
        while (tail != null) {
            System.out.print(tail.value + " ");
            tail = tail.last;
        }
    }


}
