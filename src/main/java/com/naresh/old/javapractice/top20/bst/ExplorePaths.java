package com.naresh.old.javapractice.top20.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExplorePaths {

	//TC:O(n)
	//SC:O(n)
	public static List<String> explorePaths1(com.naresh.old.javapractice.top20.bst.bt.TreeNode root) {
		List<String> paths = new LinkedList<String>();
		auxPaths1(root, "", paths);
		return paths;
	}
	private static void auxPaths1(com.naresh.old.javapractice.top20.bst.bt.TreeNode root, String path, List<String> paths) {
		if(root == null) return; 
		if(root.left == null && root.right == null) {
			paths.add(path + "]]]]]]]]]]]"
				+ "'"
				+ "" + root.data);
			return;
		}
		auxPaths1(root.left, path  + "-" + root.data, paths);
		auxPaths1(root.right, path + "-" + root.data, paths);
	}
	
	static class Entry {
		com.naresh.old.javapractice.top20.bst.bt.TreeNode node;
		String path;
		Entry(com.naresh.old.javapractice.top20.bst.bt.TreeNode node, String path) {
			this.node = node;
			this.path = path;
		}
	}
	// TC:O(n)
	// SC:O(n)
	public static List<String> explorePaths2(com.naresh.old.javapractice.top20.bst.bt.TreeNode root) {
		Queue<Entry> q = new LinkedList<Entry>();
		List<String> paths = new LinkedList<String>();

		q.add(new Entry(root, ""+root.data));
		while (!q.isEmpty()) {
			Entry entry = q.remove();
			if(entry.node.left == null && entry.node.right == null) { 
				paths.add(entry.path);
				continue;
			}
			com.naresh.old.javapractice.top20.bst.bt.TreeNode lchild = entry.node.left;
			if (lchild != null)
				q.add(new Entry(lchild, entry.path + "-" + lchild.data));
			com.naresh.old.javapractice.top20.bst.bt.TreeNode rchild = entry.node.right;
			if (rchild != null)
				q.add(new Entry(rchild, entry.path + "-" + rchild.data));
		}
		return paths;
	}

	public static void main(String[] args) {
		int n = 5; //Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(explorePaths1(root));
		System.out.println(explorePaths2(root));

	}

}