package practice.class07;


public class Code03_PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isPathSum = false;
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		isPathSum = false;
		process(root, targetSum, 0);
		return isPathSum;
    }
	
	public void process(TreeNode x, int targetSum, int preSum) {
		if (x.left == null && x.right == null) {
			if (preSum + x.val == targetSum) {
				isPathSum = true;
				return;
			}
		} 	
		// x 是非叶节点
		preSum += x.val;
		if (x.left != null) {
			process(x.left, targetSum, preSum);
		}
		if (x.right != null) {
			process(x.right, targetSum, preSum);
		}
		
	}
	
	public class Info {
		private boolean isChild;
		
	}
	
	// 有个方法可以搜集所有路径，并且能保存路径上的值
	// 判断是不是叶子节点，没有左右孩子
	public boolean isChild(TreeNode x) {
		if (x.left == null && x.right == null) {
			return true;
		} else {
			return false;
		}		
	}
	
	
	
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}
