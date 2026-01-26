package com.naresh.old.javapractice.top20.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec1 {

	private String serialize(com.naresh.old.javapractice.top20.bst.bt.TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize(root, sb);
		return sb.toString();
	}
	private void auxSerialize(com.naresh.old.javapractice.top20.bst.bt.TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.data+",");
		auxSerialize(root.left, sb);
		auxSerialize(root.right, sb);
	}
	public com.naresh.old.javapractice.top20.bst.bt.TreeNode deserialize(String in) {
		String[] tokens = in.split(",");
		List<String> list = new LinkedList<String>(Arrays.asList(tokens));
		return auxDeserialize(list);
	}
	private com.naresh.old.javapractice.top20.bst.bt.TreeNode auxDeserialize(List<String> in) {
		String val = in.remove(0);
		if(val.equals("#")) return null;
		com.naresh.old.javapractice.top20.bst.bt.TreeNode tmp = new com.naresh.old.javapractice.top20.bst.bt.TreeNode(Integer.parseInt(val));
		tmp.left = auxDeserialize(in);
		tmp.right = auxDeserialize(in);
		return tmp;
	}
	public static void main(String[] args) {
		int n = 5;//Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		Codec1 cd1 = new Codec1();
		String in = cd1.serialize(root);
		System.out.println(in);
		root = cd1.deserialize(in);
		BinaryTreeUtils.displayTree2(root);
	}

}