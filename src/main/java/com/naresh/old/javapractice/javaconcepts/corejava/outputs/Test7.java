package com.naresh.old.javapractice.javaconcepts.corejava.outputs;

public class Test7 {
	public static void main(String[] args) {
		crazyLoop();
	}

	static void crazyLoop() {
		int c = 0;
		JACK: while (c < 8) {
			JILL: System.out.println(c);
			if (c > 3)
				break JACK;
			else
				c++;
		}
	}
}
