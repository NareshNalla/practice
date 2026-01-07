package com.naresh.leetcode.old.javapractice.corejava.outputs;

public class Test6 {
public static void main(String[] args) {
    int x = 1;        
    int y = 2;         
    int z = x++;  
    int a = --y;      
    int b = z--;   
    b += ++z;    
    
    int answ = x>a?y>b?y:b:x>z?x:z;   
    System.out.println(answ);
}
}
