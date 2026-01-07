package com.naresh.leetcode.old.javapractice.gfg.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Test1 {
	public static void main(String[]args)throws Exception {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\workspace\\Alg\\src\\com\\gfg\\io\\out.txt");
		PrintWriter      pw  = new PrintWriter(fos);
		pw.print(true);
		pw.println("short content file1");
		//if u write flush or not it will save pw.flush();
		pw.close();
		fos.close();

	}

}
