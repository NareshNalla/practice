package com.naresh.corejava.misc;

enum Languages
{
    Python(10-10+10*10), Java(9+9*9-9), Angular(12*12-12-12);
    private int coders; 
    Languages(int p)
    {
         coders = p;
    }
    int getcoders()
    { 
        return coders; 
    }
}

public class EnumConstructorExample
{
    public static void main(String args[])
    {
        Languages ap;
       
        for(Languages a : Languages.values())
        System.out.println(a + " " + a.getcoders() +" coders.");
    }
}