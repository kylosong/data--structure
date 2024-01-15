package practice.day08;

public class IsBalanced {
  public static void main(String[] args) {
    // 给定一颗二叉树的头节点head，返回这棵二叉树是不是平衡二叉树。
    // （什么是平衡二叉树？在一棵二叉树中，每棵子树的左子树和右子树高度差不超过1 ）
    Node head = new Node(0);
    head.left = new Node(1);
    head.right = new Node(2);
    head.left.left = new Node(3);
    head.left.left.left = new Node(4);
    head.left.left.left.left = new Node(5);
    System.out.println(isBalanced(head));
  }

  public static boolean isBalanced(Node head) {
    return process(head).isBalanced;
  }

  public static Info process(Node x) {
    if (x == null) {
      return new Info(true, 0);
    }
    Info leftInfo = process(x.left);
    Info righInfo = process(x.right);
    int height = Math.max(leftInfo.height, righInfo.height) + 1;
    boolean isBalanced = true;
    if (!leftInfo.isBalanced) {
      isBalanced = false;
    }
    if (!righInfo.isBalanced) {
      isBalanced = false;
    }
    if (Math.abs(leftInfo.height - righInfo.height) > 1) {
      isBalanced = false;
    }
    return new Info(isBalanced, height);
  }

  public static class Info {
    private boolean isBalanced;
    private int height;

    public Info(boolean isBalanced, int height) {
      this.isBalanced = isBalanced;
      this.height = height;
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
