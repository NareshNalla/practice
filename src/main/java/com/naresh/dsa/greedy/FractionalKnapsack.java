package com.naresh.dsa.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

	public static class Item implements Comparable<Item> {
		Integer quantity;
		Integer profit;
		public Item(Integer quantity, Integer profit) {
			this.quantity = quantity;
			this.profit = profit;
		}
		@Override
		public int compareTo(Item obj2) {
			return -(this.profit - obj2.profit);
		}
		public String toString() {
			return quantity + " " + profit;
		}
	}
	
	public static double getMaxProfit(Item[] items, Integer capacity) {
	     double totProfit = 0d;
		Arrays.sort(items);
		for(Item item:items) {
			/*if(item.quantity <= w) {
				totProfit += (item.quantity * item.profit);
				w -= item.quantity;
			} else {
				totProfit += (w * item.profit);
				break;
				    
		} */
		    int curWt = (int)item.profit;
	            int curVal = (int)item.quantity;
		    if (capacity - curWt >= 0) {
	                // this weight can be picked while
	                capacity = capacity - curWt;
	                totProfit += curVal;
	            }
	            else {
	                // item cant be picked whole
	                double fraction
	                    = ((double)capacity / (double)curWt);
	                totProfit += (double)(curVal * fraction);
	                capacity
	                    = (int)(capacity - (curWt * fraction));
	                break;
	            }
		}
		return totProfit;
	}
	
	public static void main(String[] args) {
		/*int size = 5;//Integer.parseInt(args[0]);
		int w = 50;//Integer.parseInt(args[1]);
		
		Random r = new Random();		
		
		for(int i = 0; i < size; ++i) {
			int qnt = r.nextInt(100) + 1;
			int prft = r.nextInt(50) + 1;
			items[i] = new Item(qnt, prft);
			System.out.println(items[i]);
		}
		*/
	
	    Item[] items = new Item[4];
	    items[0] = new Item(10, 60);
	    items[1] = new Item(40, 40);
	    items[2] = new Item(20,100);
	    items[3] = new Item(30,120);
		
		System.out.println(getMaxProfit(items, 50));
	}

}