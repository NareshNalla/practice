package com.naresh.leetcode.old.javapractice.tree;

public class BinarySearchTreeImpl {
	Node root;
	public BinarySearchTreeImpl(){
		root = null;
	}
	public Node nodeCreate(int value){
		return new Node(value, null, null);
	}
	public void add(Node start, Node newNode){
		if(root == null){
			root = newNode;
			return;
		}
		if(newNode.value > start.value){
			if(start.right == null){
				start.right = newNode;
			}
				add(start.right, newNode);
		}
		if(newNode.value < start.value){
			if(start.left == null){
				start.left = newNode;
			}
			add(start.left, newNode);
		}
	}
	public void search(int value, Node start){
		if(start == null){
			System.out.println("Node is not fount");
		}
		if(start.value == value){
			System.out.println("Node is fount");
			return;
		}
		if(value > start.value){
			search(value, start.right);
		}
		if(value < start.value){
			search(value, start.left);
		}
	}

}
