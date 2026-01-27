package com.naresh.old.javapractice.basic.queue;

import java.util.*;

/*3
2 3 4 5  6 
2 4 5 6 7
2 3 4 4 5 6 
*/

public class MergeKSortedArrays3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), n = sc.nextInt();
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i < k; i++) {
            map.put(i,new ArrayList<Integer>());
            for(int j=0; j < n; j++) {
                map.get(i).add(sc.nextInt());
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        PQ pqs = new PQ();
        PriorityQueue<PQNode> p = new PriorityQueue<PQNode>(k, pqs);
        for(int i=0; i<k; i++) {
            if(map.get(i).size()==0) p.add(new PQNode(Integer.MAX_VALUE, -1));
            else p.add(new PQNode(map.get(i).remove(0), i));
        }
        while(output.size() != n*k){
            PQNode temp = p.remove();
            output.add(temp.value);
            if(map.get(temp.index).size()!=0) p.add(new PQNode(map.get(temp.index).remove(0), temp.index));
            p.add(new PQNode(Integer.MAX_VALUE, -1));
        }
        for(Integer item: output) 
            System.out.print(item+" ");
    }
}
class PQNode {
	int value, index; //index will tell us the deleted key is associated with which array
    PQNode(int v, int i){
        value = v;
        index = i;
    }
}

class PQ implements Comparator<PQNode>{
    public int compare(PQNode one, PQNode two) {
        return one.value - two.value;
    }
}
/*
to tes input
2rows  3 colum
 */