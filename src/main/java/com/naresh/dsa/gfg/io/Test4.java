package com.naresh.dsa.gfg.io;

import java.io.File;
import java.io.IOException;
/* What are the difference between File.getAbsolutePath() and File.getCanonicalPath()? Can they return different result? */

public class Test4 {
	static void testPath(){
		   File f1 = new File("/home/jc/../rz/rz.zip"); // file does not exist
		   File f2 = new File("Test4.class");    // file in rz dir under /home/rzhang

		   // no try/catch block needed
		   // return "/home/jc/../rz/rz.zip" always
		   System.out.println("Absolute path for f1: " + f1.getAbsolutePath());
		   // return "/home/rzhang/rz/T.class"
		   System.out.println("Absolute path for f2: " + f2.getAbsolutePath());

		   try {
		     // not compilable if neither try/catch block nor throws present
		     // return "/home/rz/rz.zip"
		     System.out.println("Canonical path for f1: " + f1.getCanonicalPath());

		     // return "/home/rzhang/rz/T.class"
		     System.out.println("Canonical path for f2: " + f2.getCanonicalPath());
		   }
		   catch (IOException ioe)
		   {
		     ioe.printStackTrace();
		   }
		 }

		 public static void main(String[] args){
			 Test4.testPath();
		 }
}
