package com.naresh.dsa.bst;

public class FindMathPathSum {

    public static void main(String[] args) {
	int n = 4;// Integer.parseInt(args[0]);
	TreeNode root = BinaryTreeUtils.createBinaryTree(n);
	BinaryTreeUtils.displayTree2(root);
	System.out.println(findMaxPathSum11(root));
	System.out.println(maxPathSum12(root));
	System.out.println(maxPathSum2(root));
	
    }

    private static int gmax = Integer.MIN_VALUE;

    private static int findMaxPathSum11(TreeNode root) {
	auxPathSum11(root, 0);
	return gmax;
    }

    private static void auxPathSum11(TreeNode root, int cmax) {
	if (root == null)
	    return;
	if (root.left == null && root.right == null) {
	    gmax = Math.max(gmax, cmax + root.data);
	    return;
	}
	auxPathSum11(root.left, cmax + root.data);
	auxPathSum11(root.right, cmax + root.data);
    }

    private static int maxPathSum2(TreeNode root) {
	if (root == null)
	    return 0;
	if (root.left == null && root.right == null)
	    return root.data;
	int left = maxPathSum2(root.left);
	int right = maxPathSum2(root.right);

	return Math.max(left, right) + root.data;
    }
    	static int max = 0;
	public static int maxPathSum12(TreeNode root) {
		auxPathSum12(root, 0, max);
		return max;
	}
	
	private static void auxPathSum12(TreeNode root, int csum, Integer max) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			max = (Math.max(max, csum + root.data));
			return;
		}
		auxPathSum12(root.left, csum + root.data, max);
		auxPathSum12(root.right, csum + root.data, max);
	}
}
