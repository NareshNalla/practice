package com.naresh.leetcode.old.javapractice.java8.mt.defog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
class CopyOnWriteArrayListDemo extends Thread {
    static CopyOnWriteArrayList l = 
                     new CopyOnWriteArrayList();
    public void run()
    {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println("Child Thread"
                     + " going to add element");
        }
  
        // Child thread trying to add new
        // element in the Collection object
        l.add("D");
    }
  
    public static void main(String[] args)
        throws InterruptedException
    {
        l.add("A");
        l.add("B");
        l.add("C");
  
        // We create a child thread that is
        // going to modify ArrayList l.
        CopyOnWriteArrayListDemo t = new CopyOnWriteArrayListDemo();
        t.start();
  
        // Now we iterate through the ArrayList
        // and get exception.
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
            Thread.sleep(600);
        }
        System.out.println(l);
    }
}