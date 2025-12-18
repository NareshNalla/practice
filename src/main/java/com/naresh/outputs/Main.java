package com.naresh.outputs;

public class Main
{
    static void Java() 
    {
        try 
        {
            System.out.println("inside Java");
            throw new RuntimeException("demo");
        }
        finally 
        {
            System.out.println("Java's finally");
        }
    }
    static void Python() 
    {
        try
        {
            System.out.println("inside Python");
            return;
        }
        finally 
        {
            System.out.println("Python's finally");
        }
    }

    public static void main(String args[]) 
    {
        try
        {
            Java();
        }
        catch (Exception e) 
        {
            System.out.println("Exception caught");
        }
    Python();
    }
}