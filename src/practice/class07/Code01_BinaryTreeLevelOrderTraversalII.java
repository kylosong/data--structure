package practice.class07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

		
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if(root == null) return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.isEmpty()) {
			List<Integer> perFor = new LinkedList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
				perFor.add(curNode.val);
			}
			ans.add(0, perFor);
		}
		return ans;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public static void main(String[] args) {
//		LinkedList<Integer> linkedList = new LinkedList<>();
//		linkedList.addFirst(1);
//		linkedList.addFirst(2);
//		linkedList.addFirst(3);
////		linkedList.add(1);
////		linkedList.add(2);
////		linkedList.add(3);
//		System.out.println(linkedList);
		
		// ArrayList 改查快, LinkList增删快，测试两者的效率
//		long startTime;
//		long endTime;
//		int testTime = 100000;
//		ArrayList<Integer> arr1 = new ArrayList<>();
//		startTime = System.currentTimeMillis();
//		for (int i = 0; i < testTime; i++) {
//			arr1.add(0, i);
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//		
//		LinkedList<Integer> arr2 = new LinkedList<>();
//		startTime = System.currentTimeMillis();
//		for (int i = 0; i < testTime; i++) {
//			arr2.add(0, i);
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
	}

}


