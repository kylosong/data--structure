package practice.class07;

public class code3_1 {
// https://leetcode.cn/problems/path-sum/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static boolean isSum = false;
	
	public boolean hasPathSum(TreeNode root, int targetSum) {

		if(root == null) return false;
		isSum = false;
		process(root, 0, targetSum);
		return isSum;
    }
	
	private void process(TreeNode treeNode, int preSum, int targetSum) {
		// 叶子节点处理
		if (treeNode.left == null && treeNode.right == null) {
			if (preSum + treeNode.val == targetSum) {
				isSum = true;
			}
			return;
		}
		// 非叶子节点处理
		preSum += treeNode.val;
		if (treeNode.left != null) {
			process(treeNode.left, preSum, targetSum);
		}
		if (treeNode.right != null) {
			process(treeNode.right, preSum, targetSum);
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
