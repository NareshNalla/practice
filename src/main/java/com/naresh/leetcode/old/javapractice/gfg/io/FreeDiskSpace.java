package com.naresh.leetcode.old.javapractice.gfg.io;

import java.io.File;

/*Find free disk space using Java
*/
public class FreeDiskSpace {
	public static void main(String[] args) {
		 File file = new File("C:\\");
		 double size = file.getFreeSpace() / (1024.0 * 1024 * 1024);
		 System.out.printf( "%.3f GB\n", size);
		
		 
		double size1 = 
	              new File("C:\\").getFreeSpace() / (1024.0 * 1024 * 1024);
		System.out.printf( "%.3f GB\n", size1); 
		
		double size2 = 
	              new File("C:\\").getUsableSpace() / (1024.0 * 1024 * 1024);
		System.out.printf( "%.3f GB\n", size2);  
		
		 double size3 = 
	              new File("C:\\").getTotalSpace() / (1024.0 * 1024 * 1024);
		System.out.printf( "%.3f GB\n", size3);    
		
		
	}

}
