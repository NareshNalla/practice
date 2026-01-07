package com.naresh.leetcode.old.javapractice.basic.queue.heap.ex;

public class AddElementsGrtK {
	static class MinHeap
	{
		int[] harr;
		int capacity; // maximum size
		int heap_size; // Current count

		// Constructor: Builds a heap from
		// a given array a[] of given size
		MinHeap(int arr[], int n)
		{
			heap_size = n;
			capacity = n;
			harr = new int[n];

			for (int i=0; i<n; i++)
				harr[i] = arr[i];

			// building the heap from first
			// non-leaf node by calling max
			// heapify function
			for (int i=n/2-1; i>=0; i--)
				heapify(i);
		}
		void heapify(int i)
		{
			int l = left(i);
			int r = right(i);
			int smallest = i;
			if (l < heap_size && harr[l] < harr[i])
				smallest = l;
			if (r < heap_size && harr[r] < harr[smallest])
				smallest = r;
			if (smallest != i)
			{
				int temp = harr[i];
				harr[i] = harr[smallest];
				harr[smallest] = temp;
				heapify(smallest);
			}
		}

		static int parent(int i)
		{
			return (i-1)/2;
		}

		// to get index of left child of
		// node at index i
		static int left(int i)
		{
			return (2*i + 1);
		}

		// to get index of right child of
		// node at index i
		int right(int i)
		{
			return (2*i + 2);
		}

		// Method to remove minimum element
		// (or root) from min heap
		int extractMin()
		{
			if (heap_size <= 0)
				return Integer.MAX_VALUE;
			if (heap_size == 1)
			{
				heap_size--;
				return harr[0];
			}

			// Store the minimum value, and
			// remove it from heap
			int root = harr[0];
			harr[0] = harr[heap_size-1];
			heap_size--;
			heapify(0);

			return root;
		}

		// Returns the minimum key (key at
		// root) from min heap
		int getMin()
		{
			return harr[0];
		}

		int getSize()
		{
			return heap_size;
		}

		// Inserts a new key 'k'
		void insertKey(int k)
		{
			// First insert the new key at the end
			heap_size++;
			int i = heap_size - 1;
			harr[i] = k;

			// Fix the min heap property if it is violated
			while (i != 0 && harr[parent(i)] > harr[i])
			{
				int temp = harr[i];
				harr[i] = harr[parent(i)];
				harr[parent(i)] = temp;
				i = parent(i);
			}
		}
	}


	// Returns count of steps needed to make
	// all elements greater than or equal to
	// k by adding elements
	static int countMinOps(int arr[], int n, int k)
	{
		// Build a min heap of array elements
		MinHeap h = new MinHeap(arr, n);

		int res = 0;

		while (h.getMin() < k)
		{
			if (h.getSize() == 1)
				return -1;

			// Extract two minimum elements
			// and insert their sum
			int first = h.extractMin();
			int second = h.extractMin();
			h.insertKey(first + second);

			res++;
		}

		return res;
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = {1, 10, 12, 9, 2, 3};
		int n  = arr.length;
		int k = 6;
		System.out.println(countMinOps(arr, n, k));
	}

}
