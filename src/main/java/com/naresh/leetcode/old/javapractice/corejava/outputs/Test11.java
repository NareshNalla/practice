package com.naresh.leetcode.old.javapractice.corejava.outputs;

class Baap {
    public int h = 4;
    public int getH(){
        System.out.println("Baap "+h); return h;
    }
}

public class Test11 extends Baap{
    public int h = 44;
    public int getH(){
        System.out.println("Test11 "+h); return h;
    }    
    public static void main(String[] args) {
        Baap b = new Test11();
        System.out.println(b.h+" "+b.getH());
        Test11 bb = (Test11) b;
        System.out.println(bb.h+" "+bb.getH());
    }
}