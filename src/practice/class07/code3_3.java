package practice.class07;

public class code3_3 {
// https://leetcode.cn/problems/path-sum/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static boolean isSum = false;
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		isSum = false;
		process(root, 0, targetSum);
		return isSum;
    }
	
	

	private void process(TreeNode x, int preSum, int targetSum) {
		if (x.left == null && x.right == null) {
			if (x.val + preSum == targetSum) {
				isSum = true;
				return;
			}
		}
		
		preSum += x.val;
		if (x.left != null) {
			process(x.left, preSum, targetSum);
		}
		if (x.right != null) {
			process(x.right, preSum, targetSum);
		}
		
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
