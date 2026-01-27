package com.naresh.corejava.basics;

public class LabeledLoopBreak {
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
