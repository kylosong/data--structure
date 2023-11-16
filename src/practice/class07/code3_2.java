package practice.class07;

public class code3_2 {
// https://leetcode.cn/problems/path-sum/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static boolean isSum = false;
	
	public boolean hasPathSum(TreeNode root, int targetSum) {

		if(root == null) return false;
		// 全局变量我感觉有些糟糕，状态容易被很多东西修改，所以使用的时候，应该特别注意
		isSum = false;
		process(root, 0, targetSum);
		return isSum;
    }
	
	public void process(TreeNode treeNode, int preSum, int sum) {
		if (treeNode.left == null && treeNode.right == null) {
			if (preSum + treeNode.val == sum) {
				isSum = true;
			}
			return;
		}
		preSum += treeNode.val;
		if (treeNode.left != null) {
			process(treeNode.left, preSum, sum);
		}
		if (treeNode.right != null) {
			process(treeNode.right, preSum, sum);
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
