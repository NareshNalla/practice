package com.naresh.corejava.basics;

class Baap {
    public int h = 4;
    public int getH(){
        System.out.println("Baap "+h); return h;
    }
}

public class InheritanceFieldShadowing extends Baap{
    public int h = 44;
    public int getH(){
        System.out.println("InheritanceFieldShadowing "+h); return h;
    }    
    public static void main(String[] args) {
        Baap b = new InheritanceFieldShadowing();
        System.out.println(b.h+" "+b.getH());
        InheritanceFieldShadowing bb = (InheritanceFieldShadowing) b;
        System.out.println(bb.h+" "+bb.getH());
    }
}