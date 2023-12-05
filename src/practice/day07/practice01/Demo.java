package practice.day07.practice01;

import java.util.HashMap;
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
    // level(head);
    // 求一棵二叉树哪一层宽度最大，最大宽度是多少（设置flag变量，发现一个层的开始或者结束）
    // int value = getMaxLevel(head);
    // System.out.println("最大宽度是：" + value);
    // 先序遍历的序列化
    // Queue<String> ans = preSerial(head);
    // System.out.println(ans.toString());
    // 先序遍历的反序列化
    // Queue<String> ans = preSerial(head);
    // Node nhead = preBuildBT(ans);
    // System.out.println(nhead.value); // 1
    // 层序遍历的序列化

  }

  /**
   * 层序遍历的序列化
   */

  /**
   * 先序遍历的反序列化
   * 
   * 这个函数肯定要返回这棵树的 head
   * 递归去构建这棵树
   */

  public static Node preBuildBT(Queue<String> builds) {
    if (builds == null || builds.isEmpty()) {
      return null;
    }
    return preBuild(builds);
  }

  public static Node preBuild(Queue<String> builds) {
    String value = builds.poll();
    if (value == null) {
      return null;
    }
    Node head = new Node(Integer.valueOf(value));
    head.left = preBuild(builds);
    head.right = preBuild(builds);
    return head;
  }

  // 先序遍历的序列化
  public static Queue<String> preSerial(Node head) {
    Queue<String> ans = new LinkedList<>();
    pres(head, ans);
    return ans;
  }

  public static void pres(Node head, Queue<String> ans) {
    if (head == null) {
      ans.add(null);
    } else {
      ans.add(String.valueOf(head.value));
      pres(head.left, ans);
      pres(head.right, ans);
    }
  }

  /**
   * 求一棵二叉树哪一层宽度最大，最大宽度是多少（设置flag变量，发现一个层的开始或者结束）
   * 感觉无从下手，有种高中做数学题的感觉，大哭中😭
   * 解析：
   * 无从下手的原因，自己还是想从整体解决问题
   * 完全没有分解清楚可以通过一层一层去统计
   * 二叉树的遍历几乎离不开，栈和队列，hashMap、变量等等辅助工具
   * 怎样判断一层的开始或者结束是本题的一个重点！
   * 
   * 二叉树结构：1 2 3 4 5 6 7
   * 最大宽度的结果是：4
   * 
   * 这题隔了一晚上，又花了35mins实现，真的太艰难了
   * 但是自己能实现，说明之前对这题的理解还算不错的，要不然肯定是眼前一码黑的
   * 
   * @param head
   */
  public static int getMaxLevel(Node head) {
    if (head == null) {
      return 0;
    }
    int max = 0;
    int currentLevelNodes = 0;
    int currentLevel = 1;
    Queue<Node> queue = new LinkedList<>();
    HashMap<Node, Integer> hashMap = new HashMap<>();
    hashMap.put(head, 1);
    queue.add(head);
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      int mLevel = hashMap.get(cur);
      if (cur.left != null) {
        queue.add(cur.left);
        hashMap.put(cur.left, mLevel + 1);
      }
      if (cur.right != null) {
        queue.add(cur.right);
        hashMap.put(cur.right, mLevel + 1);
      }
      if (mLevel == currentLevel) {
        currentLevelNodes++; // 4
      } else {
        max = Math.max(max, currentLevelNodes); // 2
        currentLevel++;
        currentLevelNodes = 1;
      }
    }
    max = Math.max(max, currentLevelNodes);
    return max;
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
