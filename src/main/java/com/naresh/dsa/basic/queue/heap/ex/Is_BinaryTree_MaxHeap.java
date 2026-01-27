package com.naresh.dsa.basic.queue.heap.ex;

public class Is_BinaryTree_MaxHeap {
	
	/*It should be a complete tree (i.e. all levels except last should be full).
	Every node�s value should be greater than or equal to its child node (considering max-heap).
	*/
	
/*	isHeapUtil function is written considering following things �

	Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one such node).
	If Node has No child then it�s a leaf node and return true (Base case)
	If Node has one child (it must be left child because it is a complete tree) then we need to compare this node with its single child only.
	If Node has both child then check heap property at Node at recur for both subtrees.
	Complete code.*/
	
	int countNodes(Node root){
		if(root==null)
			return 0;
		return (1 + countNodes(root.left) + countNodes(root.right));
	}
	/* This function checks if the binary tree is complete or not */
	boolean isCompleteUtil(Node root, int index, int number_nodes)
	{
		// An empty tree is complete
		if(root == null)
			return true;
		
		// If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
		if(index >= number_nodes)
			return false;
		
		// Recur for left and right subtrees
		return isCompleteUtil(root.left, 2*index+1, number_nodes) && 
		       isCompleteUtil(root.right, 2*index+2, number_nodes);
	}
	
	// This Function checks the heap property in the tree.
		boolean isHeapUtil(Node root){
			//  Base case : single node satisfies property
			if(root.left == null && root.right==null)
				return true;
			
			//  node will be in second last level
			if(root.right == null){
				//  check heap property at Node
	            //  No recursive call , because no need to check last level
				return root.key >= root.left.key;
			} else {
				//  Check heap property at Node and
	            //  Recursive check heap property at left and right subtree
				if(root.key >= root.left.key && root.key >= root.right.key)
					return isHeapUtil(root.left) && isHeapUtil(root.right);
				else
					return false;
			}
		}
	//  Function to check binary tree is a Heap or Not.
		boolean isHeap(Node root)
		{
			if(root == null)
				return true;
			
			// These two are used in isCompleteUtil()
			int node_count = countNodes(root);
			
			if(isCompleteUtil(root, 0 , node_count)==true && isHeapUtil(root)==true)
				return true;
			return false;
		}
		
		// driver function to test the above functions
	    public static void main(String args[])
	    {
			Is_BinaryTree_MaxHeap bt = new Is_BinaryTree_MaxHeap();
	        
			Node root =new Node(10);
			root.left = new Node(9);
			root.right = new Node(8);
			root.left.left = new Node(7);
			root.left.right = new Node(6);
			root.right.left = new Node(5);
			root.right.right = new Node(4);
			root.left.left.left = new Node(3);
			root.left.left.right = new Node(2);
			root.left.right.left = new Node(1);

	        if(bt.isHeap(root) == true)
				System.out.println("Given binary tree is a Heap");
			else 
				System.out.println("Given binary tree is not a Heap");
		}
	    
}
class Node{
    int key;
    Node left, right;

    Node(int k) {
        key = k;
        left = right = null;
    }
}

/*using level order traversal 0(n) approach*/

/*bool isHeap(Node * tree)
{
	if(tree==NULL)
		return true;
	if(tree->left==NULL&&tree->right==NULL)
		return true;
	queue<node*> q;
	q.push(tree);
	bool end=false;
	while(!q.empty())
	{
		Node* p=q.front();
		q.pop();
		int l=INT_MIN,r=INT_MIN;
		if(end)
		{
			if(p->left!=NULL||p->right!=NULL)
				return false;
		}
		else
		{
			if(p->left!=NULL&&p->right!=NULL)
			{
				l=p->left->data;
				r=p->right->data;
				q.push(p->left);
				q.push(p->right);
			}
			else if(p->left!=NULL)
			{
				l=p->left->data;
				end=true;
				q.push(p->left);
			}
			else if(p->right!=NULL)
			{
				return false;
			}
			else
				end=true;
			if(!(p->data>=l&&p->data>=r))
				return false;
		}

	}
	return true;
}*/
/*
boolean isHeap(Node root)
{
   Queue<Node> q=new LinkedList<Node>();
   q.offer(root);
   Node temp;int flag=0;
   while(!q.isEmpty())
   {
       temp=q.poll();
       int l=Integer.MIN_VALUE,r=Integer.MIN_VALUE;
       if(temp.left!=null)
       {if(flag==1)
           return false;
       l=temp.left.data;q.offer(temp.left);
       }
       else flag=1;
       if(temp.right!=null)
       {if(flag==1)
           return false;
       l=temp.right.data;q.offer(temp.right);
       }
       else flag=1;
       if(temp.data<l||temp.data<r) return false;
       
   }
   return true;
}*/