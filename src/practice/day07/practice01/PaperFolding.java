package practice.day07.practice01;

import java.util.LinkedList;
import java.util.Queue;

public class PaperFolding {
  public static void main(String[] args) {
    /**
     * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
     * 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。给定一个输入参数N，
     * 代表纸条都从下边向上方连续对折N次。请从上到下打印所有折痕的方向。
     * 例如：
     * N=1时，打印：down
     * N=2时，打印：down down up
     * 
     * 一开始读这题确实一点思路都没有
     * 解题关键：
     * 能和二叉树知识联系起来，或者说我们的数据需要一个载体
     * 发现二叉树中的凹凸规律，从上到下是这棵树的中序遍历，这题确实有点难度
     * 
     */
    printPaperFolding(4);
  }

  public static void printPaperFolding(int N) {
    process(1, N, true);
  }

  public static void process(int i, int N, boolean down) {
    if (i > N) {
      return;
    }
    process(i + 1, N, true);
    System.out.print(down == true ? "凹" : "凸");
    process(i + 1, N, false);
  }

  // 怎样先建立一颗二叉树，再打印他的中序遍历
  // 如何建立二叉树自己需要好好复习一下！
  public static void printAllFolds(int i) {
    if (i < 1) {
      return;
    }
    Queue<String> queue = new LinkedList<>();
    while (i-- < 1) {

    }
    Node head = new Node("凹");
    head.left = new Node("凹");
    head.right = new Node("凸");
  }

  public static class Node {
    Node left;
    Node right;
    String value;

    public Node(String value) {
      this.value = value;
    }

  }
}
