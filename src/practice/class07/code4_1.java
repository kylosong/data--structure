package practice.class07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import class03.index;


public class code4_1 {
// https://leetcode.cn/problems/path-sum-ii/
// 充分使用到了值传递和引用传递，如果一个程序员这个都不清，确实是一件非常糟糕的事情，初级程序员面试可以问一问
// 返回上一步的时候清理当前path，递归结束不影响上一层的数据，这一步非常妙和有经验，没有经验的估计想不出来，调试也需要调试半天
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	List<Integer> path = new ArrayList<>();
    	List<List<Integer>> sumList = new ArrayList<>();
    	if (root == null) {
			return sumList;
		}
    	process(root, path, 0, targetSum, sumList);
    	return sumList;
    }
    
    private void process(TreeNode x, List<Integer> path, int preSum, int targetSum, List<List<Integer>> sumList) {
		if (x.left == null && x.right == null) {
			if (preSum + x.val == targetSum) {
				path.add(x.val);
				sumList.add(copyArrayList(path));
				
				path.remove(path.size() - 1);
			}
			return;
		}
		
		preSum += x.val;
		path.add(x.val);
		if (x.left != null) {
			process(x.left, path, preSum, targetSum, sumList);
		}
		if (x.right != null) {
			process(x.right, path, preSum, targetSum, sumList);
		}
		
		path.remove(path.size() - 1);
		
	}

	private List<Integer> copyArrayList(List<Integer> path) {
		List<Integer> arr = new ArrayList<>();
		for (Integer item : path) {
			arr.add(item);
		}
		return arr;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
	}

}
