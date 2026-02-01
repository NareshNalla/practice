package com.naresh.dsalgo.gfg;

import java.util.Stack;

/*
 Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(])

5+[4{3+8(3-1))}] ---false
8+(9-7)+[6{9-7}+3-(10/5)] ----true
[(8*9) - {(a-b)+(5-4) + }]/{9-7})  ---false
[(8*9) - {(a-b)+(5-4) + }/{9-7}]  -----true 
 */
public class TestSepianse {

    public static void main(String[] args) {

	String in = "[(8*9) - {(a-b)+(5-4) + }/{9-7}]";

	System.out.println(evaluateExpression(in));

    }

    private static boolean evaluateExpression(String in) {
	// Deque<Character> stack      = new ArrayDeque<Character>();
	 Stack<Character> stack = new Stack<>();
	 for (int i = 0; i < in.length(); i++) {
	     char ch = in.charAt(i);
	    if(ch == '(' || ch =='{' || ch =='[' ) {
		stack.push(ch);
		continue;
	    }
	    if(!stack.isEmpty()) {
	    char check ;
	    switch(ch) {
	    case '}':
		  check = stack.pop();
		if(check == '(' || check == '[' )
		    return false;
		break;
	    case ')':
		  check = stack.pop();
		if(check == '{' || check == '[' )
		    return false;
		break;
	    case ']':
		  check = stack.pop();
		if(check == '(' || check == '{' )
		    return false;
		break;
	    }
	    }else {
		return false;
	    }

	}
	System.out.println(stack.toString());
	return (stack.isEmpty());
    }
}
