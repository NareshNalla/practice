package com.naresh.old.javapractice.companywise.altimtric;

import java.io.Serializable;

public class Singleton implements Cloneable ,Serializable {
    private static volatile Singleton instance =  new Singleton();
    
    private Singleton() {}
    
   
    public Singleton getInstance() {
	   synchronized (this) {
		instance = new Singleton();
	    }	
	return instance;
    }

    static class SingleBuilder{
	private static volatile Singleton instance = new Singleton();
	
    }
}
