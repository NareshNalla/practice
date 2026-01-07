package com.naresh.leetcode.old.javapractice.companywise.factset;

import java.io.*;

public class WithOutSytem {
	  public static void main(String args[]) throws IOException {
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
	      FileOutputStream(FileDescriptor.out), "ASCII"), 512);
	    out.write("test string");
	    out.write('\n');
	    out.flush();
	  }
	}
