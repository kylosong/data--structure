package practice.class07;

public class code3_4 {
// https://leetcode.cn/problems/path-sum/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		return process(root, targetSum);
    }
	
	

	private boolean process(TreeNode x, int rest) {
		if (x.left == null && x.right == null) {
			return x.val == rest;
		}
		rest -= x.val;
		
		return false;
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
