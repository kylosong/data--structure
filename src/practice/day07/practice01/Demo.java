package practice.day07.practice01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo {
  public static void main(String[] args) {
    // 1 2 3 4 5 6 7
    Node head = new Node(1);
    head.left = new Node(2);
    head.right = new Node(3);
    head.left.left = new Node(4);
    head.left.right = new Node(5);
    head.right.left = new Node(6);
    head.right.right = new Node(7);

    // pre(head);
    // in(head);
    // pos(head);
    // 非递归方法
    // npre(head);
    // nin(head);
    // npos(head);
    // 层序遍历 1 2 3 4 5 6 7
    level(head);
  }

  // 1 2 4 5 3 6 7
  public static void pre(Node head) {
    if (head == null) {
      return;
    }
    System.out.print(head.value + " ");
    pre(head.left);
    pre(head.right);
  }

  // 非递归
  /**
   * 1、出栈的时候打印
   * 2、如有右，压入右
   * 3、如有左，压入左
   * pre-order: 1 2 4 5 3 6 7
   * 
   * @param head
   */
  public static void npre(Node head) {
    System.out.print("pre-order: ");
    if (head == null) {
      System.out.print(null + " ");
      return;
    }
    Stack<Node> stack = new Stack<Node>();
    stack.push(head);
    while (!stack.isEmpty()) {
      head = stack.pop();
      System.out.print(head.value + " ");
      if (head.right != null) {
        stack.push(head.right);
      }
      if (head.left != null) {
        stack.push(head.left);
      }

    }
    System.out.println();
  }

  // 4 2 5 1 6 3 7
  public static void in(Node head) {
    if (head == null) {
      return;
    }
    in(head.left);
    System.out.print(head.value + " ");
    in(head.right);
  }

  // 非递归
  /**
   * 1、存在左子树则压栈
   * 2、如有右，压入右
   * 3、如有左，压入左
   * 4、出栈的时候打印
   * pre-in: 4 2 5 1 6 3 7
   * 
   * 模仿
   * 
   * @param head
   */
  public static void nin(Node head) {
    if (head == null) {
      System.out.println("the tree is empty!");
      return;
    }
    Stack<Node> stack = new Stack<>();
    while (!stack.isEmpty() || head != null) {
      // 放入所有的左子树
      if (head != null) {
        stack.push(head);
        head = head.left;
      } else {
        head = stack.pop();
        System.out.print(head.value + " ");
        head = head.right;
      }
    }
  }

  // 4 5 2 6 7 3 1
  public static void pos(Node head) {
    if (head == null) {
      return;
    }
    pos(head.left);
    pos(head.right);
    System.out.print(head.value + " ");
  }

  /**
   * 判断是否有左右子树
   * 先压入右子树
   * 4 5 2 6 7 3 1
   * 模仿
   * 
   * 通过另外一个栈驱动循环
   * 
   * @param head
   */
  public static void npos(Node head) {
    if (head == null) {
      System.out.println("the tree is empty!");
    }
    // 到此步的时候已经表示，head 不为 null
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.add(head);
    while (!stack1.isEmpty()) {
      head = stack1.pop();
      stack2.add(head);
      if (head.left != null) {
        stack1.add(head.left);
      }
      if (head.right != null) {
        stack1.add(head.right);
      }
    }

    while (!stack2.isEmpty()) {
      System.out.print(stack2.pop().value + " ");
    }

  }

  // 层序遍历
  /**
   * 这题原本能原创完成的，但是自己一直想着要完成所有的节点入栈再打印
   * 结果死活想不出来，最后 GG 了
   * 
   * 模仿
   * 
   * @param head
   */
  public static void level(Node head) {
    if (head == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    while (!queue.isEmpty()) {
      head = queue.poll();
      System.out.print(head.value + " ");
      if (head.left != null) {
        queue.add(head.left);
      }
      if (head.right != null) {
        queue.add(head.right);
      }
    }

  }

  public static class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
    }
  }
}
