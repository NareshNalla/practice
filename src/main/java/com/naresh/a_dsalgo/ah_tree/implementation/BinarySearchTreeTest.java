package com.naresh.a_dsalgo.ah_tree.implementation;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.add(bst.root, bst.nodeCreate(10));
		bst.add(bst.root, bst.nodeCreate(12));
		bst.add(bst.root, bst.nodeCreate(11));
		bst.add(bst.root, bst.nodeCreate(13));
		bst.add(bst.root, bst.nodeCreate(6));
		
		bst.search(12, bst.root);
	}
}
