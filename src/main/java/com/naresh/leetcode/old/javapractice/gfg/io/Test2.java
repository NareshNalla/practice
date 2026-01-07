package com.naresh.leetcode.old.javapractice.gfg.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Test2 {
	public static void main(String[]args)throws Exception {
		 FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\workspace\\Alg\\src\\com\\gfg\\io\\out.txt");
		   PrintWriter      pw  = new PrintWriter(fos);
		   pw.print(true);
		   pw.println("short content file");
		   //if u dont write any flush
		   pw.flush();
		 
		 }
}
