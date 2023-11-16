package practice.class07;

import practice.class07.Code01_BinaryTreeLevelOrderTraversalII.TreeNode;

public class Code02_BalancedBinaryTree {

	public static void main(String[] args) {
		
	}
	
	public class Info {
		private boolean isBalanced;
		private int height;
		public Info(boolean isBalanced, int height) {		
			this.isBalanced = isBalanced;
			this.height = height;
		}
		
	}
	
	public boolean isBalanced(TreeNode root) {    
		return process(root).isBalanced;
    }
	
	public Info process(TreeNode x) {	
		if (x == null) {
			return new Info(true, 0);
		}
		Info lefInfo = process(x.left);
		Info rightInfo = process(x.right);
		int leftHeight = lefInfo.height;
		int rightHeight = rightInfo.height;
		int height = Math.max(leftHeight, rightHeight) + 1;
//		boolean isBalanced = Math.abs(leftHeight - rightHeight) < 2;
		boolean isBalanced = lefInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftHeight - rightHeight) < 2;
		return new Info(isBalanced, height);
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

}
