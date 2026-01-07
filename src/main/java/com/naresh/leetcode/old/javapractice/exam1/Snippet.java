package com.naresh.leetcode.old.javapractice.exam1;

import java.util.stream.Stream;

public class Snippet {
    public static void main(String[] args) {

	Stream<Integer> numStream = Stream.of(10, 20, 30);
	numStream.map(n -> n + 10).peek(s -> {System.out.print(s);});
    }
}
