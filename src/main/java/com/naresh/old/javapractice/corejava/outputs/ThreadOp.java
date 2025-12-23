package com.naresh.old.javapractice.corejava.outputs;

class N extends Thread
{
Thread thread, thread1, thread2;
	N()
    {
    thread1 = new Thread(this,"Thread_1");
    thread2 = new Thread(this,"Thread_2");
    thread1.start();
    thread2.start();
    }
public void run()
    {
    thread2.setPriority(Thread.MAX_PRIORITY);	
    System.out.println(thread1.equals(thread2));
    }    
}

public class ThreadOp
{
    public static void main(String args[])
    {
        new N();        
    }
}