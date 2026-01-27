package com.naresh.dsa.gfg.io;

import java.io.File;
/*How to create a new directory by using File object?*/
public class Test5 {
	public static void main(String args[]){
		// make sure sub-directory "mmm" does not exist
		File dir=new File("mmm");
		System.out.println(dir.mkdir());// true


		// make sure at least two of "hhh\\lll\\nnn" does not exist
		File multidir=new File("hhh\\lll\\nnn");
		System.out.println(multidir.mkdir()); // false
		System.out.println(multidir.mkdirs()); // true

		// make sure at least two of "..\\ccc\\ddd\\eee" does not exist
		File updir=new File("..\\ccc\\ddd\\eee");
		System.out.println(updir.mkdir()); // false
		System.out.println(updir.mkdirs()); // true

		// If you run the code second time,
		// the result will be different. Why?
	}
}
