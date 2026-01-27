package com.naresh.leetcode.collections.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {

	Stream<Integer> numStream = Stream.of(10, 20, 30);
	numStream.map(n -> n + 10).peek(s -> {System.out.print(s);});

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
