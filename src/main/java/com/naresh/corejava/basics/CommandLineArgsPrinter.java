package com.naresh.corejava.basics;

public class CommandLineArgsPrinter {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++)
			System.out.print(i == 0 ? args[i] : " " + args[i]);
	}
}
