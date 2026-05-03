package com.naresh.a_dsalgo.tree.implementation;

public class BinarySearchTree {
	TreeNode root;
	public BinarySearchTree(){
		root = null;
	}
	public TreeNode nodeCreate(int value){
		return new TreeNode(value, null, null);
	}
	public void add(TreeNode start, TreeNode newNode){
		if(root == null){
			root = newNode;
			return;
		}
        if(newNode.value < start.value){
            if(start.left == null){
                start.left = newNode;
            }
            add(start.left, newNode);
        }
		if(newNode.value > start.value){
			if(start.right == null){
				start.right = newNode;
			}
				add(start.right, newNode);
		}
	}
	public void search(int value, TreeNode start){
		if(start == null){
			System.out.println("Node is not fount");
            return;
		}
		if(start.value == value){
			System.out.println("Node is fount");
			return;
		}
		if(value < start.value){
			search(value, start.left);
		}else{
            search(value, start.right);
        }
	}

}
