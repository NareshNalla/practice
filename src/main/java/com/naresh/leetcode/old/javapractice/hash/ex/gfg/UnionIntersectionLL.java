package com.naresh.leetcode.old.javapractice.hash.ex.gfg;

import java.util.HashMap;
import java.util.HashSet;

/*
Input:
	   List1: 10->15->4->20
	   lsit2:  8->4->2->10
	Output:
	   Intersection List: 4->10
	   Union List: 2->8->20->4->15->10
	   */
public class UnionIntersectionLL {
	DataItem head;

 class DataItem {
	public int data;
	DataItem next;
	DataItem(int d){
		data = d;
		next = null;
	}
  }
 public void printList(){
	 DataItem temp = head;
	 while(temp != null){
		 System.out.println(temp.data+" ");
		 temp = temp.next;
	 }
		System.out.println("");
	}
 public void push(int new_data){

	 DataItem new_node = new DataItem(new_data);
     new_node.next = head;
     head = new_node;
 }
 public void append(int new_data){
	 if(this.head == null){
		 DataItem n= new DataItem(new_data);
		 this.head = n;
		 return;
	 }
	 DataItem n1 = this.head;
	 DataItem n2 =new DataItem(new_data);
	 while(n1.next != null){
		 n1 = n1.next;
	 }
	 n1.next = n2;
	 n2.next = null;
	 
 }
 boolean isPresent(DataItem head, int data){
	 DataItem t= head;
	 while( t != null){
		 if(t.data == data)
			 return true;
		 t =t.next;
	 }
	 return false;
 }
 UnionIntersectionLL getIntersection(DataItem head1, DataItem head2){
	 
	 HashSet<Integer> hset = new HashSet<>();
	 DataItem n1= head1;
	 DataItem n2= head2;
	 UnionIntersectionLL result = new UnionIntersectionLL();
	 
	 while(n1 != null){
		 if(hset.contains(n1.data))
			 hset.add(n1.data);
		 else
			 hset.add(n1.data);
		n1=n1.next;
	 }
	 while( n2 != null){
		 if(hset.contains(n2.data))
			 result.push(n2.data);
		 n2 = n2.next;
	 }
	 return result;
 }
UnionIntersectionLL getUnion(DataItem head1, DataItem head2){
	 
	 HashMap<Integer, Integer> hmap = new HashMap<>();
	 DataItem n1= head1;
	 DataItem n2= head2;
	 UnionIntersectionLL result = new UnionIntersectionLL();
	 
	 while(n1 != null){
		 if(hmap.containsKey(n1.data)){
			 int val = hmap.get(n1.data);
			 hmap.put(n1.data, val+1);
		 }
		 else
			 hmap.put(n1.data, 1);
		n1=n1.next;
	 }
	 while( n2 != null){
		 if(hmap.containsKey(n2.data)){
			int val = hmap.get(n2.data);
			 hmap.put(n2.data, val+1);
		 }else{
			 hmap.put(n2.data , 1);
		 }
		 n2 = n2.next;
	 }
	 for(int a:hmap.keySet())
		 result.append(a);
	 return result;
 }
 public static void main(String[] args) {
	 UnionIntersectionLL ll1= new UnionIntersectionLL();
	 UnionIntersectionLL ll2= new UnionIntersectionLL();
	 UnionIntersectionLL intersection = new UnionIntersectionLL();
	 UnionIntersectionLL union = new UnionIntersectionLL();
	 
	 /*
	 ll1.push(10);
	 ll1.push(3);
	 ll1.push(12);
	 ll1.push(6);
	 
	 ll2.push(3);
	 ll2.push(12);
	 ll2.push(16);
	 ll2.push(10);
	 */
	 ll1.push(1);
	 ll1.push(5);
	 ll1.push(1);
	 ll1.push(5);
	 ll1.push(8);
	 
	 ll2.push(1);
	 ll2.push(5);
	 ll2.push(7);
	 ll2.push(8);
	 ll2.push(7);
	 
	 
	 intersection = intersection.getIntersection(ll1.head, ll2.head);
	 union = union.getUnion(ll1.head, ll2.head);
	 
	 System.out.println("First List:");
	 ll1.printList();
	 
	 System.out.println("Second List:");
	 ll2.printList();
	 
	 System.out.println("Intersection List is:");
	 intersection.printList();
	 System.out.println("Union List is:");
	 union.printList();
	 
	 
	 
	 
	 
}
 
}

/*Union (list1, list2)
Initialize the result list as NULL and create an empty hash table. Traverse both lists one by one, for each element being visited, look the element in hash table. If the element is not present, then insert the element to result list. If the element is present, then ignore it."

It should be:
Union (list1, list2)
Initialize the result list as NULL and create an empty hash table. Traverse first list and add all the elements to the hash table and result list. Now traverse second list and for each element being visited, look the element in hash table. If the element is not present,
 then insert the element to result list. If the element is present, then ignore it."
*/

/*Union of lists can also be found by merging both the lists and then removing the duplicates from the resultant list in O(n^2).*/
/*
Time complexity of this method depends on the hashing technique used and the distribution of elements in input lists. In practical, this approach may turn out to be better than above 2 methods*/








