package practice.day07.practice01;

import practice.day07.practice01.Demo.Node;

public class Demo2 {
  public static void main(String[] args) {
    // 1 2 3 4 5 6 7
    Node head = new Node(1);
    head.left = new Node(2);
    head.right = new Node(3);
    head.left.left = new Node(4);
    head.left.right = new Node(5);
    head.right.left = new Node(6);
    head.right.right = new Node(7);

    // pre(head); // 1 2 4 5 3 6 7
    // in(head); // 4 2 5 1 6 3 7
    // pos(head); // 4 5 2 6 7 3 1
    // 非递归方法
    // npre(head);
    // nin(head);
    // npos(head);
    // 层序遍历，1 2 3 4 5 6 7
    // level(head);
  }
}
